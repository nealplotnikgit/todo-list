<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="academy.learnprogramming.util.Mappings" %>
<HTML>
<head>
<title>View Item</title>
</head>
<body>

<div align="center">
    <table>
        <tr>
            <td><label>ID</label></td>
            <td>
                <c:out value="${viewItem.getId()}"/>
            </td>
        </tr>
        <tr>
            <td><label>Title</label></td>
            <td><c:out value="${viewItem.getTitle()}"/></td>
        </tr>
        <tr>
            <td><label>Deadline</label></td>
            <td><c:out value="${viewItem.getDeadline()}"/></td>
        </tr>
        <tr>
            <td><label>Details</label></td>
            <td><c:out value="${viewItem.getDetails()}"/></td>
        </tr>
        <tr>
            <td><a href="${Mappings.ITEMS}">Return</a></td>
        </tr>
    </table>
</div>

</body>
</HTML>