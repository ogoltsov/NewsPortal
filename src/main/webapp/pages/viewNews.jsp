<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<bean:message key="news.get.action"/>
<bean:define id="newsItem" name="newsForm" property="news" />
<p>id: <bean:write name="newsItem" property="id" /></p>
<p>title: <bean:write name="newsItem" property="title" /></p>
<p>brief: <bean:write name="newsItem" property="brief" /></p>
<p>date: <bean:write name="newsItem" property="date" /></p>
<p>content: <bean:write name="newsItem" property="content" /></p>

<html:link action="/news?methot=delete&id=${newsItem.id}">Delete</html:link>
<html:link action="/news?method=listNews">Back</html:link>
<html:link action="/news?method=showEditNews&id=${newsItem.id}">Edit</html:link>

</body>
</html>
