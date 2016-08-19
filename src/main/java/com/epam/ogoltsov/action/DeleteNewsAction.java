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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteNewsAction extends Action {

    private IService<News> service;

    public DeleteNewsAction() {
        service = SpringContextSingleton.getContext().getBean("newsService", NewsService.class);
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        DeleteNewsForm deleteNewsForm = (DeleteNewsForm) form;
        for (String item : deleteNewsForm.getItemsToDelete())
            service.delete(Integer.valueOf(item));
        deleteNewsForm.setItemsToDelete(null);
        return mapping.findForward("mainPage");
    }
}
