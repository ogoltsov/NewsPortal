package com.epam.ogoltsov.service;

import com.epam.ogoltsov.dao.DaoException;

public class ServiceException extends Exception {

    ServiceException(String s) {
        super(s);
    }

    ServiceException(String s, Exception e) {
        super(s, e);
    }
}
