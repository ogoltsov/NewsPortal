package com.epam.ogoltsov.servlet;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encoding = "utf-8";

    public void init(FilterConfig filterConfig) throws ServletException {
        String encodingParam = filterConfig.getInitParameter("encoding");
        if (encodingParam != null) {
            encoding = encodingParam;
        }
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }


}
