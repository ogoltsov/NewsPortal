package com.epam.ogoltsov.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NEWS")
public class News {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @SequenceGenerator(name = "id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    private Integer id;

    @Column(name = "TITLE", nullable = false, unique = true, length = 100)
    private String title;

    @Column(name = "BRIEF", nullable = false, unique = true, length = 500)
    private String brief;

    @Column(name = "CONTENT", nullable = false, unique = true, length = 2050)
    private String content;

    @Column(name = "NEWS_DATE", nullable = false)
    private Date date;

    public News() {
    }

    public News(News news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.brief = news.getBrief();
        this.content = news.getContent();
        this.date = news.getDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
                "id=" + id +
                "title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
