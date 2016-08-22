package com.epam.ogoltsov.form;

import com.epam.ogoltsov.model.News;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class NewsForm extends ActionForm {

    private static final String NUMBER_PATTERN = "^\\d+$";

    private static final Logger log = LoggerFactory.getLogger(NewsForm.class);
    private static final String FORM_RESET = "NewsFrom reset";
    private static final String FORM_VALIDATE = "NewsForm validate";

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
        log.debug(FORM_RESET);
        title = "";
        brief = "";
        content = "";
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        log.debug(FORM_VALIDATE);
        ActionErrors errors = new ActionErrors();

        if ("editNews".equals(request.getParameter("method"))) {
            errors = FormUtil.validateFields(title, brief, content, date);
            if (!FormUtil.isValid(NUMBER_PATTERN, id))
                errors.add("news.id.err", new ActionMessage("error.news.id.required"));
        }
        return errors;
    }
}