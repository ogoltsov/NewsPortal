package com.epam.ogoltsov.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.config.ExceptionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionHandler extends org.apache.struts.action.ExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(ExceptionHandler.class);
    private static final String EXCEPTION = "Exception handler: ";

    @Override
    public ActionForward execute(Exception ex, ExceptionConfig ae, ActionMapping mapping, ActionForm formInstance, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        log.error(EXCEPTION + ex);
        return super.execute(ex, ae, mapping, formInstance, request, response);
    }
}
