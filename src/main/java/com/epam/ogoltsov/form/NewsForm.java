package com.epam.ogoltsov.form;

import com.epam.ogoltsov.model.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class NewsForm extends ActionForm {

    private News news;
    private String id;
    private String title;
    private String date;
    private String brief;
    private String content;
    private List<News> newsList;
    private String[] itemsToDelete;

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

    public String[] getItemsToDelete() {
        return itemsToDelete;
    }

    public void setItemsToDelete(String[] itemsToDelete) {
        this.itemsToDelete = itemsToDelete;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        title = "";
        brief = "";
        content = "";


    }
}
