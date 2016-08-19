package com.epam.ogoltsov.action;

import com.epam.ogoltsov.form.NewNewsForm;
import com.epam.ogoltsov.form.NewsForm;
import com.epam.ogoltsov.model.News;
import com.epam.ogoltsov.service.IService;
import com.epam.ogoltsov.service.NewsService;
import com.epam.ogoltsov.servlet.SpringContextSingleton;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewNewsAction extends DispatchAction {

    private IService<News> service;

    public NewNewsAction() {
        service = SpringContextSingleton.getContext().getBean("newsService", NewsService.class);
    }

    public ActionForward addViewNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {
        NewNewsForm newsForm = (NewNewsForm) form;

        newsForm.setTitle(null);
        newsForm.setBrief(null);
        newsForm.setContent(null);
        newsForm.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        return mapping.findForward("showAddNews");
    }

    public ActionForward addNews(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        NewNewsForm newsForm = (NewNewsForm) form;
        News news = new News();
        news.setTitle(newsForm.getTitle());
        news.setBrief(newsForm.getBrief());
        news.setContent(newsForm.getContent());
        news.setDate(LocalDate.parse(newsForm.getDate(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        service.insert(news);

        return mapping.findForward("main");
    }
}
