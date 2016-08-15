<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><bean:message key="news.list.title"/></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Welcome, Mr. K!</h1>
<h3><bean:message key="news.list.title"/></h3>
<div class="news">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>id</th>
            <th>title</th>
            <th>brief</th>
            <th>date</th>
            <th>content</th>
            <th>action</th>
            <th>#</th>
        </tr>
        </thead>
        <tbody>

        <logic:iterate name="newsForm" property="newsList" id="news">
            <tr>
                <td>
                    <bean:write name="news" property="id"/>
                </td>
                <td>
                    <bean:write name="news" property="title"/>
                </td>
                <td>
                    <bean:write name="news" property="brief"/>
                </td>
                <td>
                    <bean:write name="news" property="date"/>
                </td>
                <td>
                    <bean:write name="news" property="content"/>
                </td>
                <td>
                    <html:link action="/news?method=showViewNews&id=${news.id}">View</html:link>
                    <html:link action="/news?method=showEditNews&id=${news.id}">Edit</html:link>
                </td>
                <td>
                    <input type="checkbox">
                </td>
            </tr>
        </logic:iterate>
        <tr>
            <td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="#">Add</a></td>
            <td>
                <button type="submit" class="btn btn-default">Delete</button>
            </td>
        </tr>
        </tbody>
    </table>



    <html:link page="/app/Locale?method=russian">Russian</html:link>
    <html:link page="/app/Locale?method=english">English</html:link>
</div>

</body>
</html>
