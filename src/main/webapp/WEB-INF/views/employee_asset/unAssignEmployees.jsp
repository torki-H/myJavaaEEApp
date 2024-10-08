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

    <form action="${pageContext.request.contextPath}/assets/${assetId}/unAssign" method="post">
        <br>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>EmployeeAsset Id</th>
            <th>Employee Name</th>
            <th>Employee Family</th>
            <th>Select</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="employeeAsset" items="${employeeAssets}">
            <tr>
                <td><c:out value="${employeeAsset.id}"/></td>
                <td><c:out value="${employeeAsset.employeeEntity.name}"/></td>
                <td><c:out value="${employeeAsset.employeeEntity.family}"/></td>
                <td><input type="checkbox"  name="employeeIds" value="${employeeAsset.employeeEntity.id}" /></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
        <div class="box-footer d-flex justify-content-between">
            <button type="submit" class="btn btn-primary" onclick="return validateSelection();">
                unAssign
            </button>
            <a href="<c:url value='/assets'/>" class="btn btn-primary">Back</a>
        </div>
    </form>
</div>
<script>
    function validateSelection() {
        const checkboxes = document.querySelectorAll('input[name="employeeIds"]:checked');
        if (checkboxes.length === 0) {
            alert("You must make uncheck at least one row");
            return false;
        }
        return true;
    }
</script>

</body>
</html>





