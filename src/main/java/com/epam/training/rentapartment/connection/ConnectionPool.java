package com.epam.training.rentapartment.connection;

import com.epam.training.rentapartment.exception.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    private static ConnectionPool INSTANCE;
    private final ConnectionCreator connectionCreator = new ConnectionCreator();

    private static final int POOL_SIZE = 20;
    private Queue<Connection> connections;

    private static final Lock INSTANCE_LOCK = new ReentrantLock();
    private static final Lock CONNECTION_LOCK = new ReentrantLock();
    private Semaphore connectionSemaphore = new Semaphore(POOL_SIZE);

    private static AtomicBoolean initialized = new AtomicBoolean(false);

    private ConnectionPool() throws ConnectionException {
        connections = new ArrayDeque<>();
    }

    public static ConnectionPool getINSTANCE() {
        if (!initialized.get()) {
            try {
                INSTANCE_LOCK.lock();
                if (!initialized.get()) {
                    INSTANCE = new ConnectionPool();
                    INSTANCE.createConnections();
                }
            } catch (ConnectionException e) {
                LOGGER.error(e.getMessage(), e);
            } finally {
                INSTANCE_LOCK.unlock();
            }
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        try {
            LOGGER.info(Thread.currentThread().getName() + " trying to get resource.");
            connectionSemaphore.acquire();
            CONNECTION_LOCK.lock();
            Connection connection = connections.poll();
            LOGGER.info(Thread.currentThread().getName() + " used.");
            return connection;
        } catch (InterruptedException e) {
            LOGGER.error(e);
        } finally {
            CONNECTION_LOCK.unlock();
        }
        LOGGER.error(new RuntimeException("Somethings happened wrong."));
        throw new RuntimeException("Somethings happened wrong.");
    }

    public void releaseConnection(Connection connection) {
        try {
            LOGGER.info(Thread.currentThread().getName() + " trying to return resource.");
            CONNECTION_LOCK.lock();
            connections.add(connection);
            LOGGER.info(Thread.currentThread().getName() + " returned!");
            connectionSemaphore.release();
        } finally {
            CONNECTION_LOCK.unlock();
        }
    }

    private void createConnections() {
        for (int i = 0; i < POOL_SIZE; i++) {
            Connection connection = connectionCreator.createConnection();
            connections.add(connection);
        }
        initialized.set(true);
    }

}