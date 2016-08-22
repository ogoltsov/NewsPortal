package com.epam.ogoltsov.action;

import com.epam.ogoltsov.form.DeleteNewsForm;
import com.epam.ogoltsov.model.News;
import com.epam.ogoltsov.service.IService;
import com.epam.ogoltsov.service.NewsService;
import com.epam.ogoltsov.servlet.SpringContextSingleton;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteNewsAction extends Action {
    private static final Logger log = LoggerFactory.getLogger(DeleteNewsForm.class);
    private static final String NEWS_SERVICE_BEAN = "newsService";
    private static final String DELETE_NEWS_ACTION_INIT = "Delete news Action init";
    private static final String NEWS_DELETED = "News was deleted";

    private IService<News> service;

    public DeleteNewsAction() {
        service = SpringContextSingleton.getContext().getBean(NEWS_SERVICE_BEAN, NewsService.class);
        log.debug(DELETE_NEWS_ACTION_INIT);
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        DeleteNewsForm deleteNewsForm = (DeleteNewsForm) form;
        for (String item : deleteNewsForm.getItemsToDelete())
            service.delete(Integer.valueOf(item));
        deleteNewsForm.setItemsToDelete(null);
        log.debug(NEWS_DELETED);
        return mapping.findForward("mainPage");
    }
}
