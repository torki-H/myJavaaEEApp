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
    <a class="navbar-brand" href="/assets">Asset Management</a>
    <a class="navbar-brand" href="employees">Employee Management</a>
    <a class="navbar-brand" href="categories">Category Management</a>
</nav>

<div class="container">
    <div class="row">
        <h1>List of Employees</h1>
    </div>

    <div class="row">
        <div class="col-lg-3">
            <a href="<c:url value='/employees/new'/>" class="btn btn-primary btn-sm mb-3">Add Employee</a>
        </div>
        <div class="col-lg-2">
            <form style="display: flex; align-items: center;" action="<c:url value='/search'/>" method="post">
                <label style="display: inline-block">Name:</label>
                <input class="input-details" type="text" id="name" name="name">
                <button class="button-details" type="submit">Search</button>
            </form>
        </div>
    </div>

    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>Employee Id</th>
            <th>Employee Name</th>
            <th>Employee Family</th>
            <th>Employee Date</th>
            <th>Actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td><c:out value="${employee.id}"/></td>
                <td><c:out value="${employee.name}"/></td>
                <td><c:out value="${employee.family}"/></td>
                <td><c:out value="${employee.employedDate}"/></td>
                <td>
                    <a href="<c:url value='/employees/edit/${employee.id}'/>" class="btn btn-primary">Update</a>
                    <a href="<c:url value='/employees/${employee.id}'/>" class="btn btn-danger">Delete</a>
                    <a href="<c:url value='/employees/${employee.id}/assignedAssets'/>" class="btn btn-primary">assignedAssets</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>