<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<ol class="breadcrumb">
    <li>Home</li>
    <li>
        <a href="${pageContext.request.contextPath}/news.do?method=listNews">
            <spring:message code="news.list.title.news"/>
        </a>
    </li>
    <li><a href="${pageContext.request.contextPath}/news.do?method=showViewNews&id=${news1.id}">${news1.title}</a></li>
    <li class="active">
        <spring:message code="news.list.title.edit"/>
    </li>
</ol>
<style>
    div.error {
        color: red;
    }
</style>
<form:form action="/news?method=editNews">
    <%--<html:hidden name="newsForm" property="id" value="${news1.id}"/>--%>






    <div class="row">
        <div class="container">
            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4
                            col-xs-offset-8 col-sm-offset-8 col-md-offset-8 col-lg-offset-8">
                <div class="btn-group">
                        <%--<html:link action="/news?method=listNews">--%>
                    <button type="submit" class="btn btn-success" formaction="/save">
                        <spring:message code="news.action.save"/>
                    </button>
                        <%--</html:link>--%>
                    <%--<html:link action="/news.do?method=showViewNews&id=${news1.id}">--%>
                        <button type="submit" formaction="/news.do?method=showViewNews&id=${news1.id}"
                                class="btn btn-warning">
                            <spring:message code="news.action.cancel"/>
                        </button>
                    <%--</html:link>--%>
                    <%--<html:link action="/delete">--%>
                        <button type="button" class="btn btn-danger">
                            <spring:message code="news.action.delete"/>
                        </button>
                        <%--<html:param name="itemsToDelete" value="${news1.id}"/>--%>
                    <%--</html:link>--%>
                </div>
            </div>
        </div>
    </div>
</form:form>