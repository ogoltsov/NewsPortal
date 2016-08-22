package com.epam.ogoltsov.model;

import java.time.LocalDate;

public class News extends BaseEntity {

    private String title;
    private String brief;
    private String content;
    private LocalDate date;

    public News() {
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (!title.equals(news.title)) return false;
        if (!brief.equals(news.brief)) return false;
        if (!content.equals(news.content)) return false;
        return date.equals(news.date);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + brief.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + date.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + super.getId() +
                "title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
