<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.resource.datasource.factory.DataSourceLocator"%>
<%@page  errorPage="./error/errosException.jsp"  %>
<html>
<head>
</head>
<body>

<%=DataSourceLocator.testConnection()%>

</body>
</html>