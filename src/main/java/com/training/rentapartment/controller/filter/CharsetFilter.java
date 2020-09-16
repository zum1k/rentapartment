package com.training.rentapartment.controller.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter {
    private static final String REQUEST_ENCODING = "requestEncoding";
    private static final String UTF_8 = "UTF-8";
    private static final String JSP_PARAMETERS = "text/html; charset=UTF-8";
    private String encoding;

    @Override
    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter(REQUEST_ENCODING);
        if (encoding == null) encoding = UTF_8;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {
        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(encoding);
        }
        response.setContentType(JSP_PARAMETERS);
        response.setCharacterEncoding(UTF_8);
        next.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
