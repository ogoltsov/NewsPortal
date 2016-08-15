package com.epam.ogoltsov.action;

import com.epam.ogoltsov.form.NewsForm;
import com.epam.ogoltsov.model.News;
import com.epam.ogoltsov.service.IService;
import com.epam.ogoltsov.service.NewsService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewsActions extends DispatchAction {

    public ActionForward listNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {
        log.debug("listNews()...");
        NewsForm newsForm = (NewsForm) form;
        try (IService<News> newsService = new NewsService()) {
            newsForm.setNewsList(newsService.findAll());
        }
        return mapping.findForward("listNews");
    }

    public ActionForward showViewNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        log.debug("viewNews()...");
        NewsForm newsForm = (NewsForm) form;
        try (IService<News> service = new NewsService()) {
            News news = service.findById(Integer.valueOf(newsForm.getId()));
            newsForm.setNews(news);
        }
        return mapping.findForward("showViewNews");
    }

    public ActionForward showEditNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        log.debug("editViewNews()...");
        NewsForm newsForm = (NewsForm) form;
        try (IService<News> service = new NewsService()) {
            News news = service.findById(Integer.valueOf(newsForm.getId()));
            newsForm.setNews(news);
            newsForm.setId(String.valueOf(news.getId()));
        }
        return mapping.findForward("showEditNews");
    }

    public ActionForward editNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        News news = new News();

        if ((!newsForm.getId().equals("")) && (newsForm.getId() != null))
            news.setId(Integer.parseInt(newsForm.getId()));
        else news.setId(null);
        news.setTitle(newsForm.getTitle());
        news.setDate(LocalDate.parse(newsForm.getDate(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        news.setBrief(newsForm.getBrief());
        news.setContent(newsForm.getContent());
        newsForm.setNews(news);

        try (IService<News> newsService = new NewsService()) {
            newsService.save(news);
        }
        return mapping.findForward("showViewNews");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;

        try (IService<News> service = new NewsService()) {
            for (String item : newsForm.getItemsToDelete()) {
                service.delete(Integer.valueOf(item));
            }
        }
        return mapping.findForward("deleteNews");
    }

    public ActionForward addViewNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        News news = new News();
        news.setDate(LocalDate.now());
        newsForm.setNews(news);
        return mapping.findForward("showAddNews");

    }

    public ActionForward addNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        NewsForm newsFormo = (NewsForm) form;
        News news = new News();
        news.setTitle(newsFormo.getTitle());
        news.setBrief(newsFormo.getBrief());
        news.setContent(newsFormo.getContent());
        news.setDate(LocalDate.parse(newsFormo.getDate(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        News newNews;
        try (IService<News> service = new NewsService()) {
            newNews = service.insert(news);
        }
        newsFormo.setNews(newNews);
        return mapping.findForward("showViewNews");
    }


}
