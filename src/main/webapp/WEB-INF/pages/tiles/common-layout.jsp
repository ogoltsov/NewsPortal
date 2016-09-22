<%@page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title><tiles:insertAttribute name="title"/></title>
    <!-- Bootstrap CSS -->
    <%--<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">--%>
    <%--<script src=${pageContext.request.contextPath}/js/jquery.min.js"></script>--%>
    <%--<script src=${pageContext.request.contextPath}/js/tether.min.js"></script>--%>
    <%--<script src=${pageContext.request.contextPath}/js/bootstrap.js"></script>--%>


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<style>
    div.workspace {
        padding-top: 10px;
        /*border: 1px solid black;*/
    }
    div.header {
        /*border: 1px solid red;*/
    }
    div.menu{
        /*border: 1px solid deeppink;*/
    }
</style>
<div class="container-fluid">
    <div class="row">
        <div class="header">
            <tiles:insertAttribute name="header"/>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-2">
            <div class="menu">
                <tiles:insertAttribute name="menu"/>
            </div>
        </div>
        <div class="col-xs-9 col-sm-9 col-md-9 col-lg-10">
            <div class="workspace">
                <tiles:insertAttribute name="body"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>