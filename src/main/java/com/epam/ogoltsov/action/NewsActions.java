package com.epam.ogoltsov.action;

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
    private static final String NEWS_SERVICE_BEAN = "newsService";
    private static final String FORWARD_LIST_NEWS = "listNews";
    private static final String GET_ALL_NEWS = "Get list of all news";
    private static final String VIEW_NEWS = "Views News: ";
    private static final String FORWARD_VIEW_NEWS = "showViewNews";
    private static final String SHOW_NEWS_FOR_EDIT = "Show news for edit: ";
    private static final String FORWARD_EDIT_NEWS = "showEditNews";
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String EDIT_NEWS = "News was changed";
    private static final String ACTION_INIT = "NewsAction init";


    private IService<News> service;

    public NewsActions() {
        log.debug(ACTION_INIT);
        service = SpringContextSingleton.getContext().getBean(NEWS_SERVICE_BEAN, NewsService.class);
    }

    public NewsActions(IService<News> service) {
        this.service = service;
    }

    public ActionForward listNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                  HttpServletResponse response) throws Exception {
        log.debug(GET_ALL_NEWS);
        NewsForm newsForm = (NewsForm) form;
        newsForm.setNewsList(service.findAll());
        return mapping.findForward(FORWARD_LIST_NEWS);
    }

    public ActionForward showViewNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;
        News news = service.findById(Integer.valueOf(newsForm.getId()));
        newsForm.setNews(news);

        log.debug(VIEW_NEWS + news);
        return mapping.findForward(FORWARD_VIEW_NEWS);
    }

    public ActionForward showEditNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        NewsForm newsForm = (NewsForm) form;

        News news = service.findById(Integer.valueOf(newsForm.getId()));

        newsForm.setTitle(news.getTitle());
        newsForm.setBrief(news.getBrief());
        newsForm.setContent(news.getContent());
        newsForm.setDate(news.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        newsForm.setNews(news);
        newsForm.setId(String.valueOf(news.getId()));

        log.debug(SHOW_NEWS_FOR_EDIT + news);
        return mapping.findForward(FORWARD_EDIT_NEWS);
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
                DateTimeFormatter.ofPattern(DATE_PATTERN)));
        news.setBrief(newsForm.getBrief());
        news.setContent(newsForm.getContent());
        newsForm.setNews(news);
        log.debug(EDIT_NEWS);
        service.save(news);
        return mapping.findForward(FORWARD_VIEW_NEWS);
    }
}
