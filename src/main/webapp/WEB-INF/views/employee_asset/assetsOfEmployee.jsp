<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee Management System</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <!-- Brand -->
    <a class="navbar-brand" href="#">Employee Management System</a>


</nav>

<div class="container">

    <c:if test="${not empty message}">
        <div style="color: red;">${message}</div>
    </c:if>

        <br>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>EmployeeAsset Id</th>
            <th>Asset title</th>
            <th>Asset healthyStatus</th>
            <th>Asset description</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="employeeAsset" items="${employeeAssets}">
            <tr>
                <td><c:out value="${employeeAsset.id}"/></td>
                <td><c:out value="${employeeAsset.assetEntity.title}"/></td>
                <td><c:out value="${employeeAsset.assetEntity.healthyStatus}"/></td>
                <td><c:out value="${employeeAsset.assetEntity.description}"/></td>


            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>





