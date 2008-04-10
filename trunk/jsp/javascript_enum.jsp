<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.enumeration.EnumUtils"%>
<html>
<head>
<script type="text/javascript">
function getEnumValues()
{
	var constVar = <%=EnumUtils.CONSTANT%>;
	var arrayVar = <%=EnumUtils.stringToArray()%>
	
	alert(constVar);
	
	alert(arrayVar.CASA);
	alert(arrayVar.APT);
	alert(arrayVar.TERRENO);  
}
</script>
</head>
<body>
	<script>
		getEnumValues();
	</script>
</body>
</html>