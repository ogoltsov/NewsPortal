package com.epam.ogoltsov.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(EncodingFilter.class);
    private static final String ENCODING = "encoding";
    private static final String ENCODING_FILTER_INIT = "Encoding filter init";

    private static String encoding = "utf-8";

    public void init(FilterConfig filterConfig) throws ServletException {
        String encodingParam = filterConfig.getInitParameter(ENCODING);
        if (encodingParam != null) {
            encoding = encodingParam;
        }
        log.debug(ENCODING_FILTER_INIT);
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
