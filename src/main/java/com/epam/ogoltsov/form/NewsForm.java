package com.epam.ogoltsov.form;

import com.epam.ogoltsov.model.News;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Pattern;

public class NewsForm extends ActionForm {

    private News news;
    private String id;
    private String title;
    private String date;
    private String brief;
    private String content;
    private List<News> newsList;
    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        title = "";
        brief = "";
        content = "";
    }

    private static final String NUMBER_PATTERN = "^\\d+$";
    private static final String DATE_PATTERN = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        String method = request.getParameter("method");

        if (method.equals("editNews")) {
            if (!isValid(NUMBER_PATTERN, id))
                errors.add("news.id.err", new ActionMessage("error.news.id.required"));
            if (!(title.length() <= 100))
                errors.add("news.title.err", new ActionMessage("error.news.title.length"));
            if (!(brief.length() <= 500))
                errors.add("news.brief.err", new ActionMessage("error.news.brief.length"));
            if (!(content.length() <= 2048))
                errors.add("news.content.err", new ActionMessage("error.news.content.length"));
            if (!isValid(DATE_PATTERN, date))
                errors.add("news.date.err", new ActionMessage("error.news.date.format"));
        }
        return errors;
    }

    private boolean isValid(String regex, String input) {
        return Pattern.matches(regex, input);
    }


}
