package com.epam.ogoltsov.pool;

class DBConnectionPoolException extends RuntimeException {

    DBConnectionPoolException(String message, Exception exception) {
        super(message, exception);
    }
}
