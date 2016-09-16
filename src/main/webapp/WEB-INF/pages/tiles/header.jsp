<style>
    div.header {
        border-bottom: 1px solid lightgray;
        display: block;
    }

    div.buttons {
        padding-top: 15px;
    }

</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid header">
    <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
        <h2>
            <bean:message key="newsPortal.title"/>
        </h2>
    </div>
    <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2 buttons">
        <c:if test="${org.apache.struts.action.LOCALE==ru_RU}">
            <html:link page="/Locale.do?method=russian" styleClass=" ">
                <button type="button" class="btn btn-default active">
                    <bean:message key="newsPortal.buttons.lang.russian"/>RU
                </button>
            </html:link>
            <html:link page="/Locale.do?method=english" styleClass="">
                <button type=type"button" class="btn btn-default">
                    <bean:message key="newsPortal.buttons.lang.english"/>EN
                </button>
            </html:link>
        </c:if>
    </div>
</div>