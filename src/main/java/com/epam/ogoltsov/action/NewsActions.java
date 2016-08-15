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

      news.setId(Integer.parseInt(newsForm.getId()));
      news.setTitle(newsForm.getTitle());

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDate date = LocalDate.parse(newsForm.getDate(), formatter);
      news.setDate(date);

      news.setBrief(newsForm.getBrief());
      news.setContent(newsForm.getContent());
      newsForm.setNews(news);

      try (IService<News> newsService = new NewsService()) {
          newsService.save(news);
      }
        return mapping.findForward("showViewNews");
    }


}
