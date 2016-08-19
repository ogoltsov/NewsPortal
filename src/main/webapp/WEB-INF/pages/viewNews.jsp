<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<style>
    div.news {
        padding-bottom: 10px;
    }
</style>

<div>
    <bean:define id="newsItem" name="newsForm" property="news"/>
    <ol class="breadcrumb">
        <li>Home</li>
        <li><a href="${pageContext.request.contextPath}/news.do?method=listNews">News</a></li>
        <li class="active"><bean:write name="newsItem" property="title"/></li>
    </ol>
    <div class="container-fluid news">
        <div class="row">
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                <p class="text-center">
                    Title:
                </p>
            </div>
            <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                <p class="text-justify">
                    <b><bean:write name="newsItem" property="title"/></b>
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                <p class="text-center">
                    Brief:
                </p>
            </div>
            <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                <p class="text-justify">
                    <bean:write name="newsItem" property="brief"/>
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                <p class="text-center">
                    Date:
                </p>
            </div>
            <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                <p class="text-justify">
                    <bean:write name="newsItem" property="date"/>
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                <p class="text-center">
                    Content:
                </p>
            </div>
            <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                <p class="text-justify">
                    <bean:write name="newsItem" property="content"/>
                </p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="container">
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3
                            col-xs-offset-9 col-sm-offset-9 col-md-offset-9 col-lg-offset-9">
                <div class="btn-group">
                    <html:link action="/news?method=listNews">
                        <button type="button" class="btn btn-default">
                            Back
                        </button>
                    </html:link>
                    <html:link action="/news?method=showEditNews&id=${newsItem.id}">
                        <button type="button" class="btn btn-default">
                            Edit
                        </button>
                    </html:link>
                    <html:link action="/delete">
                        <button type="button" class="btn btn-danger">
                            Delete!
                        </button>
                        <html:param name="itemsToDelete" value="${newsItem.id}"/>
                    </html:link>
                </div>
            </div>
        </div>
    </div>
</div>