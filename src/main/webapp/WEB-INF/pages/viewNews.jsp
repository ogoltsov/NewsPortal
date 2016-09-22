<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<style>
    div.news {
        padding-bottom: 10px;
    }
</style>

<div>
    <ol class="breadcrumb">
        <li>Home</li>
        <li>
            <a href="/news">
                <spring:message code="news.list.title.news"/>
            </a>
        </li>
        <li class="active">
            ${news.title}
            <%--<bean:write name="newsItem" property="title"/>--%>
        </li>
    </ol>
    <div class="container-fluid news">
        <div class="row">
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                <p class="text-center">
                    <spring:message code="news.edit.title"/>
                </p>
            </div>
            <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                <p class="text-justify">
                    <b>
                        ${news.title}
                        <%--<bean:write name="newsItem" property="title"/>--%>
                    </b>
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                <p class="text-center">
                    <spring:message code="news.edit.brief"/>
                </p>
            </div>
            <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                <p class="text-justify">
                    ${news.brief}
                    <%--<bean:write name="newsItem" property="brief"/>--%>
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                <p class="text-center">
                    <spring:message code="news.edit.date"/>
                </p>
            </div>
            <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                <p class="text-justify">
                    ${news.date}
                    <%--<bean:write name="newsItem" property="date" format="yyy-MM-dd"/>--%>
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                <p class="text-center">
                    <spring:message code="news.edit.content"/>
                </p>
            </div>
            <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                <p class="text-justify">
                    ${news.content}
                    <%--<bean:write name="newsItem" property="content"/>--%>
                </p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="container">
            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4
                            col-xs-offset-8 col-sm-offset-8 col-md-offset-8 col-lg-offset-8">
                <div class="btn-group">
                    <%--<html:link action="/news?method=listNews">--%>
                        <a href="">
                            <button type="button" class="btn btn-default">
                                <spring:message code="news.action.back"/>
                            </button>
                        </a>
                    <%--</html:link>--%>
                    <%--<html:link action="/news?method=showEditNews&id=${newsItem.id}">--%>
                        <a href="">
                            <button type="button" class="btn btn-default" formaction="">
                                <spring:message code="news.action.edit"/>
                            </button>
                        </a>

                    <%--</html:link>--%>
                    <%--<html:link action="/delete">--%>
                        <a href="">
                            <button type="button" class="btn btn-danger">
                                <spring:message code="news.action.delete"/>
                            </button>
                        </a>
                        <%--<html:param name="itemsToDelete" value="${newsItem.id}"/>--%>
                    <%--</html:link>--%>
                </div>
            </div>
        </div>
    </div>
</div>