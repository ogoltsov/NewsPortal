package com.epam.ogoltsov.action;

import com.epam.ogoltsov.form.DeleteNewsForm;
import com.epam.ogoltsov.form.NewsForm;
import com.epam.ogoltsov.model.News;
import com.epam.ogoltsov.service.IService;
import com.epam.ogoltsov.service.NewsService;
import com.epam.ogoltsov.servlet.SpringContextSingleton;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class NewsActions extends DispatchAction {
    private static final Logger log = LoggerFactory.getLogger(NewsActions.class);

    private IService<News> service;
//    private NewsService service = SpringContextSingleton.getContext().getBean("newsService", NewsService.class);

//    public NewsService getService() {
//        return service;
//    }
//
//    public void setService(NewsService service) {
//        this.service = service;
//    }

    public NewsActions() {
        service = SpringContextSingleton.getContext().getBean("newsService", NewsService.class);

    }


    public NewsActions(IService<News> service) {
        this.service = service;
    }

    public ActionForward listNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {
        log.debug("listNews()...");
        NewsForm newsForm = (NewsForm) form;
        newsForm.setNewsList(service.findAll());
        return mapping.findForward("listNews");
    }

    public ActionForward showViewNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        log.debug("viewNews()...");
        NewsForm newsForm = (NewsForm) form;
        News news = service.findById(Integer.valueOf(newsForm.getId()));
        newsForm.setNews(news);
        return mapping.findForward("showViewNews");
    }

    public ActionForward showEditNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        log.debug("editViewNews()...");
        NewsForm newsForm = (NewsForm) form;

        News news = service.findById(Integer.valueOf(newsForm.getId()));
        newsForm.setNews(news);
        newsForm.setId(String.valueOf(news.getId()));
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

        service.save(news);
        return mapping.findForward("showViewNews");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                HttpServletResponse response) throws Exception {
        DeleteNewsForm deleteNewsForm = (DeleteNewsForm) form;

        if ((deleteNewsForm.getItemsToDelete() != null) && (deleteNewsForm.getItemsToDelete().length != 0)) {
            for (String item : deleteNewsForm.getItemsToDelete())
                service.delete(Integer.valueOf(item));
            return mapping.findForward("deleteNews");
        }
        return listNews(mapping, form, request, response);
    }

    public ActionForward addViewNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        News news = new News();
        news.setDate(LocalDate.now());
        news.setId(null);
        newsForm.setNews(news);

        return mapping.findForward("showAddNews");
    }

    public ActionForward addNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        News news = new News();
        news.setTitle(newsForm.getTitle());
        news.setBrief(newsForm.getBrief());
        news.setContent(newsForm.getContent());
        news.setDate(LocalDate.parse(newsForm.getDate(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        News newNews;
        newNews = service.insert(news);
        newsForm.setNews(newNews);
        return mapping.findForward("showViewNews");
    }


}
