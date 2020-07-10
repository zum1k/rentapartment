package com.training.rentapartment.model.pool;

import com.training.rentapartment.exception.ConnectionException;
import com.training.rentapartment.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static Logger logger = LogManager.getLogger(ConnectionPool.class);

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
                logger.error(e.getMessage(), e);
            } finally {
                INSTANCE_LOCK.unlock();
            }
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        try {
            logger.info(Thread.currentThread().getName() + " trying to get resource.");
            connectionSemaphore.acquire();
            CONNECTION_LOCK.lock();
            Connection connection = connections.poll();
            logger.info(Thread.currentThread().getName() + " used.");
            return connection;
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        } finally {
            CONNECTION_LOCK.unlock();
        }
        logger.error(new RuntimeException("Somethings happened wrong."));
        throw new RuntimeException("Somethings happened wrong.");
    }

    public void releaseConnection(Connection connection) {
        try {
            logger.info(Thread.currentThread().getName(), " trying to return resource.");
            CONNECTION_LOCK.lock();
            connections.add(connection);
            logger.info(Thread.currentThread().getName(), " returned!");
            connectionSemaphore.release();
        } finally {
            CONNECTION_LOCK.unlock();
        }
    }


    public void closeConnections() throws ConnectionPoolException {
        try {
            for (int i = 0; i < connections.size(); i++) {
                connections.poll().close();
            }
        } catch (SQLException e) {
            throw new ConnectionPoolException(e.getMessage(), e);
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
