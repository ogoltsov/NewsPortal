<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>
<bean:define id="news1" name="newsForm" property="news"/>
<ol class="breadcrumb">
    <li>Home</li>
    <li><a href="${pageContext.request.contextPath}/news.do?method=listNews">News</a></li>
    <li><a href="${pageContext.request.contextPath}/news.do?method=showViewNews&id=${news1.id}">${news1.title}</a></li>
    <li class="active">Edit</li>
</ol>
<style>
    div.errors {
        color: red;
    }
</style>
<div class="errors">
    <html:errors/>
</div>
<html:form action="/news?method=editNews">
    <html:hidden name="newsForm" property="id" value="${news1.id}"/>
    <jsp:include page="/WEB-INF/pages/tiles/editFields.jsp"/>
    <div class="row">
        <div class="container">
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3
                            col-xs-offset-9 col-sm-offset-9 col-md-offset-9 col-lg-offset-9">
                <div class="btn-group">
                    <html:link action="/news?method=listNews">
                        <html:submit styleClass="btn btn-success" value="Save"/>
                    </html:link>
                    <html:link action="/news.do?method=showViewNews&id=${news1.id}">
                        <button type="submit" formaction="/news.do?method=showViewNews&id=${news1.id}"
                                class="btn btn-warning">
                            Cancel
                        </button>
                    </html:link>
                    <html:link action="/news?method=delete">
                        <button type="button" class="btn btn-danger">
                            Delete!
                        </button>
                        <html:param name="itemsToDelete" value="${news1.id}"/>
                    </html:link>
                </div>
            </div>
        </div>
    </div>
</html:form>