package com.epam.ogoltsov.action;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LanguageSelectAction extends DispatchAction {

    private static final Logger log = LoggerFactory.getLogger(LanguageSelectAction.class);
    private static final String FORWARD_MAIN_PAGE = "mainPage";
    private static final String SET_ENGLISH_LOCALE = "User choose english locale";
    private static final String SET_RUSSIAN_LOCALE = "User choose russian locale";

    public ActionForward english(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().setAttribute(
                Globals.LOCALE_KEY, Locale.US);
        log.debug(SET_ENGLISH_LOCALE);
        return mapping.findForward(FORWARD_MAIN_PAGE);
    }

    public ActionForward russian(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().setAttribute(
                Globals.LOCALE_KEY, new Locale("ru","RU"));
        log.debug(SET_RUSSIAN_LOCALE);
        return mapping.findForward(FORWARD_MAIN_PAGE);
    }
}
