package com.epam.ogoltsov.service;

import com.epam.ogoltsov.dao.DaoException;

public class ServiceException extends RuntimeException {


    public ServiceException(String s) {
        super(s);
    }

    public ServiceException(String s, Exception e) {
        super(s, e);
    }
}
