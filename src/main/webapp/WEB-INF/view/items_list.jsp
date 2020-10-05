<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="academy.learnprogramming.util.Mappings" %>
<HTML>
<head>
<title>ToDo Items</title>
</head>
<body>

<div align="center">
<c:url var="addLink" value="${Mappings.ADDITEM}"></c:url>
<h2><a href="${addLink}">Add Item</h2></a>

<table border="1" cellpassing="5">
<caption><h2>todo items</h2></caption>
<tr>
<th>Title</th>
<th>Deadline</th>
<th>Edit</th>
<th>View</th>
<th>Delete</th>

<c:forEach var="item" items="${toDoData.items}">
    <c:url var="deleteLink" value="${Mappings.DELETEITEM}">
            <c:param name="id" value="${item.getId()}"></c:param>
    </c:url>
    <c:url var="editLink" value="${Mappings.ADDITEM}">
            <c:param name="id" value="${item.getId()}"></c:param>
    </c:url>
    <c:url var="viewLink" value="${Mappings.VIEWITEM}">
            <c:param name="id" value="${item.getId()}"></c:param>
    </c:url>
    <tr>
    <td><c:out value="${item.getTitle()}"/></td>
    <td><c:out value="${item.getDeadline()}"/></td>
    <td><a href="${editLink}">Edit</a></td>
    <td><a href="${viewLink}">View</a></td>
    <td><a href="${deleteLink}">Delete</a></td>
    </tr>
</c:forEach>
</tr>
</table>
</div>

</body>
</HTML>