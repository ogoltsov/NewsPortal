<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<html:form action="/news?method=editNews">
<bean:define id="news1" name="newsForm" property="news"/>
    <%--<html:hidden name="newsForm" property="id" value="${news1.id}"/>--%>
    <html:text name="newsForm" property="id" value="${news1.id}" />
    <br>

    <html:text name="newsForm" property="title" value="${news1.title}"  size="200" maxlength="200"/>
    <br>
    <html:textarea name="newsForm" property="brief" value="${news1.brief}" cols="5" rows="5"/>
    <br>
    <html:text name="newsForm" property="date" value="${news1.date}"/>
    <br>
    <html:textarea name="newsForm" property="content" value="${news1.content}" cols="5" rows="5"/>
    <br>
    <html:submit value="Save"/>
    <br>
    </html:form>
</body>
</html>
