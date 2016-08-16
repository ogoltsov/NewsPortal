<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<bean:define id="news1" name="newsForm" property="news"/>
<div class="form-group">
    <label for="InputTitle">Title:</label>
    <html:text name="newsForm" property="title" value="${news1.title}" size="100" maxlength="200"
               styleClass="form-control" styleId="InputTitle"/>
</div>
<div class="form-group">
    <label for="InputBrief">Brief:</label>
    <html:textarea styleId="InputBrief" styleClass="form-control" name="newsForm" property="brief"
                   value="${news1.brief}" cols="50" rows="5"/>
</div>
<div class="form-group">
    <label for="InputDate">Date:</label>
    <html:text styleId="InputDate" styleClass="form-control" name="newsForm" property="date" value="${news1.date}"/>
</div>
<div class="form-group">
    <label for="InputContent">Content:</label>
    <html:textarea styleId="InputContent" styleClass="form-control" name="newsForm" property="content"
                   value="${news1.content}" cols="5" rows="10"/>
</div>
