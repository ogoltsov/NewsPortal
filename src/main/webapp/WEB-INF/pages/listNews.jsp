<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style>
    div.actions > div {
        display: inline;
    }

    div.newsActions {
        border-bottom: 1px solid lightgray;
        padding-top: 10px;
        padding-bottom: 5px;
    }

    div.deleteButton {
        padding-top: 20px;
        padding-bottom: 50px;
    }

    div.news {
        padding-top: 10px;
        background: #ffffff; /* Old browsers */
        background: -moz-linear-gradient(left, #ffffff 0%, #f9f9f9 50%, #ffffff 99%);
        background: -webkit-linear-gradient(left, #ffffff 0%, #f9f9f9 50%, #ffffff 99%);
        background: linear-gradient(to right, #ffffff 0%, #f9f9f9 50%, #ffffff 99%);
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#ffffff', GradientType=1);
    }

    div.errors {
        color: red;
    }
</style>
<div>
    <ol class="breadcrumb">
        <li>Home</li>
        <li class="active">
            <%--<spring:message code="news.list.title.news"/>--%>
        </li>
    </ol>

    <div class="newsList">
        <form action="/delete?method=delete">
            <c:forEach items="${newsList}" var="news">
                <jsp:useBean id="news" class="com.epam.ogoltsov.model.News"/>
                <div class="news">
                    <div class="col-xs-8 col-sm-8 col-md-8 col-lg-9">
                        <div class="title">
                            <p class="text-justify">
                                <b>
                                        ${news.title}
                                        <%--<bean:write name="news" property="title"/>--%>
                                </b>
                            </p>
                        </div>
                        <div class="brief">
                            <p class="text-justify">
                                    ${news.brief}
                            </p>
                        </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
                        <div class="newsMenu">
                            <div class="newsDate">
                                <p>
                                        <%--<bean:write name="news" property="date" format="yyyy-MM-dd"/>--%>
                                        ${news.date}
                                </p>
                            </div>
                        </div>
                    </div>

                    <div class="newsActions">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-xs-8 col-sm-8 col-md-8 col-lg-9"></div>
                                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
                                    <div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                                            <%--<html:link action="/news?method=showViewNews&id=${news.id}">--%>
                                            <%--<bean:message key="news.action.view"/>--%>
                                            <%--</html:link>--%>
                                    </div>
                                    <div class="col-xs-3 col-sm-3 col-md-5 col-lg-5">
                                            <%--<html:link action="/news?method=showEditNews&id=${news.id}">--%>
                                            <%--<bean:message key="news.action.edit"/>--%>
                                            <%--</html:link>--%>
                                    </div>
                                    <div class="col-xs-3 col-sm-3 col-md-2 col-lg-2">
                                            <%--<html:multibox property="itemsToDelete" value="${news.id}"/>--%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>


            <div class="container deleteButton">
                <div class="errors">
                    <%--<html:errors/>--%>
                </div>
                <div class="col-xs-3 col-sm-3 col-md-2 col-lg-1
                            col-xs-offset-9 col-sm-offset-9 col-md-offset-10 col-lg-offset-11">
                    <button type="submit" class="btn btn-danger">
                        <%--<bean:message key="news.action.delete"/>--%>
                        <%--<spring:message code="news.action.delete"/>--%>
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>