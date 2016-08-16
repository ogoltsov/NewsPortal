<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<bean:define id="news1" name="newsForm" property="news"/>

<ol class="breadcrumb">
    <li>Home</li>
    <li><a href="${pageContext.request.contextPath}/news.do?method=listNews">News</a></li>
    <li class="active">New news</li>
</ol>
<html:form action="/news?method=addNews">

    <jsp:include page="/WEB-INF/pages/tiles/editFields.jsp"/>

    <div class="row">
        <div class="container">
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3
                            col-xs-offset-9 col-sm-offset-9 col-md-offset-9 col-lg-offset-9">
                <div class="btn-group">
                    <button type="submit" class="btn btn-success">
                        Save
                    </button>
                    <button type="submit" class="btn btn-warning"
                            formaction="/news.do?method=listNews">
                        Cancel
                    </button>
                </div>
            </div>
        </div>
    </div>
</html:form>
