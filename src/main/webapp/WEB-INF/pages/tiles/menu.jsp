<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style>
    div.left_menu {
        padding-top: 10px;
    }
</style>

<div class="left_menu">
    <div class="left_menu_items_block">
        <div class="list-group">
                <a href="" class="list-group-item">
                    <spring:message code="left.menu.ref.news.list"/>
                </a>
            <%--<html:link action="/news?method=listNews" styleClass="list-group-item ">--%>
            <%--<bean:message key="left.menu.ref.news.list"/>--%>
            <%--</html:link>--%>

                <a href="" class="list-group-item">
                    <spring:message code="left.menu.ref.add.news"/>
                </a>
            <%--<html:link action="/newNews?method=addViewNews" styleClass="list-group-item ">--%>
            <%--<bean:message key="left.menu.ref.add.news"/>--%>
            <%--</html:link>--%>
        </div>
    </div>
</div>