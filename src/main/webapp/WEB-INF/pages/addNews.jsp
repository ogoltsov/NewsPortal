<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<bean:define id="newsForm" name="newNewsForm"/>
<style>
    div.errors {
        color: red;
    }
</style>
<ol class="breadcrumb">
    <li>Home</li>
    <li><a href="${pageContext.request.contextPath}/news.do?method=listNews">News</a></li>
    <li class="active">New news</li>
</ol>
<div class="errors">
    <html:errors/>
</div>
<html:form action="/newNews?method=addNews">

    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    <script>
        $(document).ready(function () {
            var date_input = $('input[id="InputDate"]'); //our date input has the name "date"
            var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
            date_input.datepicker({
                format: 'yyyy-mm-dd',
                container: container,
                todayHighlight: true,
                autoclose: true
            })
        })
    </script>
    <div class="form-group">
        <label for="InputTitle">
            <bean:message key="news.edit.title"/>:</label>
        <html:text name="newsForm" property="title" value="${newsForm.title}" size="100" maxlength="100"
                   styleClass="form-control" styleId="InputTitle"/>
    </div>
    <div class="form-group">
        <label for="InputBrief"><bean:message key="news.edit.brief"/>:</label>
        <html:textarea styleId="InputBrief" styleClass="form-control" name="newsForm" property="brief"
                       value="${newsForm.brief}" cols="50" rows="5"/>
    </div>
    <div class="form-group">
        <label for="InputDate"><bean:message key="news.edit.date"/>:</label>
        <html:text styleId="InputDate" styleClass="form-control" name="newsForm" property="date" value="${newsForm.date}" maxlength="10"/>
    </div>
    <div class="form-group">
        <label for="InputContent"><bean:message key="news.edit.content"/>:</label>
        <html:textarea styleId="InputContent" styleClass="form-control" name="newsForm" property="content"
                       value="${newsForm.content}" cols="5" rows="10"/>
    </div>
    <div class="row">
        <div class="container">
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3
                            col-xs-offset-9 col-sm-offset-9 col-md-offset-9 col-lg-offset-9">
                <div class="btn-group">
                    <button type="submit" class="btn btn-success">
                        <bean:message key="news.action.save"/>
                    </button>
                    <button type="submit" class="btn btn-warning"
                            formaction="/news.do?method=listNews">
                        <bean:message key="news.action.cancel"/>
                    </button>
                </div>
            </div>
        </div>
    </div>
</html:form>
