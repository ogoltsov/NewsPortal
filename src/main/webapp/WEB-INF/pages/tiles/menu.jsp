<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<style>
    div.left_menu {
        padding-top: 10px;
    }
</style>

<div class="left_menu">
    <div class="left_menu_items_block">
        <div class="list-group">
            <html:link action="/news?method=listNews" styleClass="list-group-item ">
                <bean:message key="left.menu.ref.news.list"/>
            </html:link>
            <html:link action="/newNews?method=addViewNews" styleClass="list-group-item ">
                <bean:message key="left.menu.ref.add.news"/>
            </html:link>
            <br>
        </div>
    </div>
</div>