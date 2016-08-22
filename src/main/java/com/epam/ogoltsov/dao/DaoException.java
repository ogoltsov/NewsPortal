package com.epam.ogoltsov.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoException extends Exception {
    DaoException(String s, Exception e) {
        super(s, e);
    }

    private static final Logger log = LoggerFactory.getLogger(DaoException.class);
    private static final String EXCEPTION_TITLE = "DBConnectionPool exception: ";

    public DaoException(String message) {
        super(message);
        log.debug(EXCEPTION_TITLE + "message: " + message);
    }
}
