<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/employees">Employee Management</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row">
        <h1> List Of Employees </h1>
    </div>


    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th> Employee Id</th>
            <th> Employee Name</th>
            <th> Employee Family</th>
            <th> Employee Date </th>
            <th> Actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.family}</td>
                <td>${employee.employedDate}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/employees/edit/${employee.id}"
                       class="btn btn-primary">Update</a>
                    <a href="${pageContext.request.contextPath}/employees/${employee.id}"
                       class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="<c:url value='/employees'/>" class="btn btn-primary">Back</a>

</div>
</body>
</html>