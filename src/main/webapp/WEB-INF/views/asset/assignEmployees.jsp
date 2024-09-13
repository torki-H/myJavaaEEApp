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
    <a class="navbar-brand" href="#">Employee Management System</a>
</nav>

<div class="container">

    <c:if test="${not empty message}">
        <div style="color: red;">${message}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/assets/${assetId}/assign" method="post">
        <br>
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
            <tr>
                <th>Employee Id</th>
                <th>Employee Name</th>
                <th>Employee Family</th>
                <th>Employee Date</th>
                <th>Select</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td><c:out value="${employee.id}"/></td>
                    <td><c:out value="${employee.name}"/></td>
                    <td><c:out value="${employee.family}"/></td>
                    <td><c:out value="${employee.employedDate}"/></td>
                    <td><input type="checkbox" name="employeeIds" value="${employee.id}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="submit" class="btn btn-primary" onclick="return validateSelection();">Assign</button>
    </form>
</div>
<script>
    function validateSelection() {
        const checkboxes = document.querySelectorAll('input[name="employeeIds"]:checked');
        if (checkboxes.length === 0) {
            alert("You must make at least one selection");
            return false;
        }
        return true;
    }
</script>

</body>
</html>