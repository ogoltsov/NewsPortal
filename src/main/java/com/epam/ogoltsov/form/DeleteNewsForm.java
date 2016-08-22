package com.epam.ogoltsov.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

public class DeleteNewsForm extends ActionForm {

    private String[] itemsToDelete;

    public DeleteNewsForm() {
        this.itemsToDelete = null;
    }

    public String[] getItemsToDelete() {
        return itemsToDelete;
    }

    public void setItemsToDelete(String[] itemsToDelete) {
        this.itemsToDelete = itemsToDelete;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = null;
        if ((itemsToDelete == null) || (itemsToDelete.length == 0)) {
            errors = new ActionErrors();
            errors.add("error.news.delete", new ActionMessage("error.news.delete.count"));
        }
        return errors;

    }
}
