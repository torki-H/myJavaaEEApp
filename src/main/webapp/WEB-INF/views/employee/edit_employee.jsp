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
    <a class="navbar-brand" href="#">Employee Management System</a>
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
<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 container justify-content-center card">
            <h1 class="text-center">Update Employee</h1>
            <div class="card-body">
                <form action="<c:url value='/employees/${employee.id}' />" method="POST">
                    <div class="form-group">
                        <label>Employee Name</label>
                        <input
                                type="text"
                                name="name"
                                class="form-control"
                                value="${employee.name}"
                                placeholder="Enter Employee name"
                                required
                        />
                    </div>

                    <div class="form-group">
                        <label>Employee Family</label>
                        <input
                                type="text"
                                name="family"
                                class="form-control"
                                value="${employee.family}"
                                placeholder="Enter Employee family"
                                required
                        />
                    </div>

                    <div class="form-group">
                        <label>Employee Date</label>
                        <input
                                type="text"
                                name="employedDate"
                                class="form-control"
                                value="${employee.employedDate}"
                                placeholder="Enter employee date"
                                required
                        />
                    </div>

                    <div class="box-footer">
                    </div>
                    <div class="box-footer d-flex justify-content-between">
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <a href="<c:url value='/employees'/>" class="btn btn-primary">Back</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>