package com.epam.ogoltsov.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class DBConnectionPoolException extends RuntimeException {

    private static final Logger log = LoggerFactory.getLogger(DBConnectionPoolException.class);
    private static final String EXCEPTION_TITLE = "DBConnectionPool exception: ";
    DBConnectionPoolException(String message, Exception exception) {
        super(message, exception);
        log.debug(EXCEPTION_TITLE +"message: " + message+ " exception: "+ exception);
    }
}
