package com.epam.ogoltsov.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;

import java.util.regex.Pattern;

class FormUtil {
    private static final String DATE_PATTERN = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";

    static ActionErrors validateFields(String title, String brief, String content, String date) {
        ActionErrors errors = new ActionErrors();
        if (!(title.length() <= 100))
            errors.add("news.title.err", new ActionMessage("error.news.title.length"));
        if (!(brief.length() <= 500))
            errors.add("news.brief.err", new ActionMessage("error.news.brief.length"));
        if (!(content.length() <= 2048))
            errors.add("news.content.err", new ActionMessage("error.news.content.length"));
        if (!isValid(DATE_PATTERN, date))
            errors.add("news.date.err", new ActionMessage("error.news.date.format"));
        return errors;
    }

    static boolean isValid(String regex, String input) {
        return Pattern.matches(regex, input);
    }

}
