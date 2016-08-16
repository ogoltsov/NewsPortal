<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<h1>Welcome, Mr. K!</h1>
<h3><bean:message key="news.list.title"/></h3>
<div class="news">
    <html:form action="/news?method=delete">
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
                        <html:multibox property="itemsToDelete" value="${news.id}"/>
                    </td>
                </tr>
            </logic:iterate>
            <tr>
                <td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><a href="/news.do?method=addViewNews">Add</a></td>
                <td>
                    <button type="submit" class="btn btn-default">Delete</button>
                </td>
            </tr>
            </tbody>
        </table>
    </html:form>

    <html:link page="/Locale.do?method=russian">Russian</html:link>
    <html:link page="/Locale.do?method=english">English</html:link>

</div>

