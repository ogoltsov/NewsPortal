package com.epam.ogoltsov.service;

import com.epam.ogoltsov.dao.DaoException;

class ServiceException extends RuntimeException {

    ServiceException(String s) {
        super(s);
    }

    ServiceException(String s, Exception e) {
        super(s, e);
    }
}
