package com.training.rentapartment.controller.filter;

import com.training.rentapartment.controller.HttpRequestParameters;
import com.training.rentapartment.controller.SessionAttribute;
import com.training.rentapartment.controller.command.PagePath;
import com.training.rentapartment.controller.command.access.CommandAccess;
import com.training.rentapartment.controller.mapper.UserMapper;
import com.training.rentapartment.entity.UserType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RoleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        UserType role = parseRole(servletRequest);
        String command = servletRequest.getParameter(HttpRequestParameters.COMMAND);
        if (CommandAccess.matchCommandRole(command, role)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher(PagePath.LINK_TO_MAIN);
            requestDispatcher.forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }

    private UserType parseRole(ServletRequest servletRequest) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        UserMapper mapper = new UserMapper();
        if (request.getSession().getAttribute(SessionAttribute.USER) != null) {
            return mapper.parseSession(request).getType();
        } else {
            return UserType.GUEST;
        }
    }
}
