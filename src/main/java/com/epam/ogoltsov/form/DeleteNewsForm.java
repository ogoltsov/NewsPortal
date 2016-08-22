package com.epam.ogoltsov.form;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class DeleteNewsForm extends ActionForm {
    private static final Logger log = LoggerFactory.getLogger(DeleteNewsForm.class);
    private static final String FORM_VALIDATE = "DeleteForm validate";
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
        log.debug(FORM_VALIDATE);
        ActionErrors errors = null;
        if ((itemsToDelete == null) || (itemsToDelete.length == 0)) {
            errors = new ActionErrors();
            errors.add("error.news.delete", new ActionMessage("error.news.delete.count"));
        }
        return errors;
    }
}
