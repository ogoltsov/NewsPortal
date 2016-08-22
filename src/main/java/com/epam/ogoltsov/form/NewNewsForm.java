package com.epam.ogoltsov.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class NewNewsForm extends ActionForm {

    private static final Logger log = LoggerFactory.getLogger(NewNewsForm.class);
    private static final String FORM_VALIDATE = "NewsNewsForm validate";

    private String title;
    private String date;
    private String brief;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = null;
        log.debug(FORM_VALIDATE);
        if ("addNews".equals(request.getParameter("method"))) {
            errors = FormUtil.validateFields(title, brief, content, date);
        }

        return errors;
    }
}
