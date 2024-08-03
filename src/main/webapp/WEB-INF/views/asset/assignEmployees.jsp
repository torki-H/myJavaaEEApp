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

    <!-- Toggler/collapsibe Button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Navbar links -->
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/employees'/>">Employee Management</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/teachers'/>">Teacher Management</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row">
        <h1>List Employees</h1>
    </div>

<%--    <div class="row">--%>
<%--        <div class="col-lg-3">--%>
<%--            <a href="<c:url value='/employees/new'/>" class="btn btn-primary btn-sm mb-3">Add Employee</a>--%>
<%--        </div>--%>
<%--        <div class="col-lg-2">--%>
<%--            <form style="display: flex; align-items: center;" action="<c:url value='/search'/>" method="post">--%>
<%--                <label style="display: inline-block">Name:</label>--%>
<%--                <input class="input-details" type="text" id="name" name="name">--%>
<%--                <button class="button-details" type="submit">Search</button>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>
    <form action="${pageContext.request.contextPath}/assets/${assetId}/assign" method="post">
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
        <button type="submit">Assign</button>
    </form>

</div>
</body>
</html>





















<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Assign Employees</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Assign Employees to Asset</h1>--%>
<%--<form action="${pageContext.request.contextPath}/assets/${assetId}/assign" method="post">--%>
<%--    <table>--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th>Select</th>--%>
<%--            <th>Name</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <c:forEach var="employee" items="${employees}">--%>
<%--            <tr>--%>
<%--                <td><input type="checkbox" name="employeeIds" value="${employee.id}"/></td>--%>
<%--                <td>${employee.name}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--    <button type="submit">Assign</button>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>