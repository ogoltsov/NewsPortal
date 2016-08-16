package com.epam.ogoltsov.pool;

class DBConnectionPoolException extends RuntimeException {
    public DBConnectionPoolException() {
    }

    DBConnectionPoolException(String message) {
        super(message);
    }

    DBConnectionPoolException(String message, Exception exception) {
        super(message, exception);
    }
}
