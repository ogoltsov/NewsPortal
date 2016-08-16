package com.epam.ogoltsov.dao;

public class DaoException extends Exception {
    DaoException(String s, Exception e) {
        super(s, e);
    }

    public DaoException(String s) {
        super(s);
    }
}
