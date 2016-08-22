package com.epam.ogoltsov.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceException extends Exception {

    private static final Logger log = LoggerFactory.getLogger(ServiceException.class);
    private static final String EXCEPTION_TITLE = "DBConnectionPool exception: ";

    ServiceException(String message, Exception exception) {
        super(message, exception);
        log.debug(EXCEPTION_TITLE +"message: " + message+ " exception: "+ exception);
    }
}
