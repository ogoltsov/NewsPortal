<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<div class="left_menu">
    <h4><bean:message key="left.menu.title.news" /></h4>
    <div class="left_menu_items_block">
        <ul>
            <li><html:link action="/news?method=listNews" ><bean:message key="left.menu.ref.news.list" /></html:link></li>
            <li><html:link action="/news?method=showAddNews" ><bean:message key="left.menu.ref.add.news" /></html:link></li>
        </ul>
    </div>
</div>