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


</nav>

<div class="container">

        <table class="table table-striped table-bordered">
            <thead class="table-dark">
            <tr>
                <th>employeeAsset Id</th>
                <th>employee fullName</th>
                <th>AssetTitle</th>
                <th>assignStatus</th>
                <th>assignedDate</th>
                <th>unassignedDate</th>
                <th>aboardDate</th>
                <th>order of assign</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="employeeAsset" items="${employeeAssets}">
                <tr>
                    <td><c:out value="${employeeAsset.id}"/></td>
                    <td><c:out value="${employeeAsset.employeeEntity.name} ${employeeAsset.employeeEntity.family}"/></td>
                    <td><c:out value="${employeeAsset.assetEntity.title}"/></td>
                    <td>
                        <c:choose>
                            <c:when test="${employeeAsset.assignStatus}">
                                Assigned
                            </c:when>
                            <c:otherwise>
                                Unassigned
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td><c:out value="${employeeAsset.assignedDate}"/></td>
                    <td><c:out value="${employeeAsset.unassignedDate}"/></td>

                    <td><c:out value="${employeeAsset.aboardDate}"/> <!-- نمایش تاریخ aboardDate --></td>


                    <td><c:out value="${employeeAsset.version}"/></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    <br>
     <a href="<c:url value='/assets'/>" class="btn btn-danger">back</a>

</div>
</body>
</html>