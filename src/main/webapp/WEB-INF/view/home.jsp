<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="academy.learnprogramming.util.Mappings" %>
<HTML>
<head>
<title>ToDo List App</title>
</head>
<body>
<div align="center">
<c:url var="itemsLink" value="${Mappings.ITEMS}"></c:url>
<h2><a href="${itemsLink}">Show Items<a/></h2>
</div>
</body>
</HTML>

