<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
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
    }
    div.news {
        padding-top: 10px;
        background: #ffffff; /* Old browsers */
        background: -moz-linear-gradient(left, #ffffff 0%, #f9f9f9 50%, #ffffff 99%);
        background: -webkit-linear-gradient(left, #ffffff 0%, #f9f9f9 50%, #ffffff 99%);
        background: linear-gradient(to right, #ffffff 0%, #f9f9f9 50%, #ffffff 99%);
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#ffffff', GradientType=1);
    }
</style>
<div>
    <ol class="breadcrumb">
        <li>Home</li>
        <li class="active">News list</li>
    </ol>

    <div class="newsList">
        <html:form action="/news?method=delete">
            <logic:iterate name="newsForm" property="newsList" id="news">
                <div class="news">
                    <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9">
                        <div class="title">
                            <p class="text-justify">
                                <b>
                                    <bean:write name="news" property="title"/>
                                </b>
                            </p>
                        </div>
                        <div class="brief">
                            <p class="text-justify">
                                <bean:write name="news" property="brief"/>...
                            </p>
                        </div>
                    </div>
                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        <div class="newsMenu">
                            <div class="newsDate">
                                <p><bean:write name="news" property="date"/></p>
                            </div>
                        </div>
                    </div>

                    <div class="newsActions">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-xs-9 col-sm-9 col-md-9 col-lg-9"></div>
                                <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                        <html:link action="/news?method=showViewNews&id=${news.id}">View</html:link>
                                    </div>
                                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                        <html:link action="/news?method=showEditNews&id=${news.id}">Edit</html:link>
                                    </div>
                                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                        <html:multibox property="itemsToDelete" value="${news.id}"/>
                                    </div>
                                    <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </logic:iterate>
            <div class="container deleteButton">
                <div class="col-xs-1 col-sm-1 col-md-1 col-lg-1
                            col-xs-offset-11 col-sm-offset-11 col-md-offset-11 col-lg-offset-11">
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </div>
        </html:form>
    </div>
</div>