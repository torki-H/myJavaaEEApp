<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Asset Management System</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="#">Asset Management System</a>

</nav>

<div class="container">
    <div class="row">
        <h1>List Assets</h1>
    </div>


    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>Asset Id</th>
            <th>Asset Title</th>
            <th>Asset Description</th>
            <th>Asset Healthy Status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="asset" items="${assets}">
            <tr>
                <td><c:out value="${asset.id}"/></td>
                <td><c:out value="${asset.title}"/></td>
                <td><c:out value="${asset.description}"/></td>
                <td>
                    <c:choose>
                        <c:when test="${asset.healthyStatus == 'true'}">Healthy</c:when>
                        <c:otherwise>Needs Repair</c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>