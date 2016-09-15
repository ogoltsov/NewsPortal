<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<style>
    div.news {
        padding-bottom: 10px;
    }
</style>

<div>
    <bean:define id="newsItem" name="newsForm" property="news"/>
    <ol class="breadcrumb">
        <li>Home</li>
        <li>
            <a href="${pageContext.request.contextPath}/news.do?method=listNews">
                <bean:message key="news.list.title.news"/>
            </a>
        </li>
        <li class="active"><bean:write name="newsItem" property="title"/></li>
    </ol>
    <div class="container-fluid news">
        <div class="row">
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                <p class="text-center">
                    <bean:message key="news.edit.title"/>
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
                    <bean:message key="news.edit.brief"/>
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
                    <bean:message key="news.edit.date"/>
                </p>
            </div>
            <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                <p class="text-justify">
                    <bean:write name="newsItem" property="date" format="yyy-MM-dd"/>
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                <p class="text-center">
                    <bean:message key="news.edit.content"/>
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
            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4
                            col-xs-offset-8 col-sm-offset-8 col-md-offset-8 col-lg-offset-8">
                <div class="btn-group">
                    <html:link action="/news?method=listNews">
                        <button type="button" class="btn btn-default">
                            <bean:message key="news.action.back"/>
                        </button>
                    </html:link>
                    <html:link action="/news?method=showEditNews&id=${newsItem.id}">
                        <button type="button" class="btn btn-default">
                            <bean:message key="news.action.edit"/>
                        </button>
                    </html:link>
                    <html:link action="/delete">
                        <button type="button" class="btn btn-danger">
                            <bean:message key="news.action.delete"/>
                        </button>
                        <html:param name="itemsToDelete" value="${newsItem.id}"/>
                    </html:link>
                </div>
            </div>
        </div>
    </div>
</div>