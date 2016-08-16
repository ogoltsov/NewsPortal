<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <!-- Bootstrap CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <script src=${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src=${pageContext.request.contextPath}/js/tether.min.js"></script>
    <script src=${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body>
<style>
    div.workspace {
        padding-top: 10px;
    }
</style>
<div class="container-fluid">
    <div class="row">
        <tiles:insert attribute="header"/>
    </div>
    <div class="row">
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
            <tiles:insert attribute="menu"/>
        </div>
        <div class="col-xs-9 col-sm-9 col-md-9 col-lg-10">
            <div class="workspace">
                <tiles:insert attribute="body"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>