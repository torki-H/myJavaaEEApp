<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Category Management System</title>
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
        <h1>List of Categories</h1>
    </div>

    <div class="row">
        <div class="col-lg-3">
            <a href="<c:url value='/categories/new'/>" class="btn btn-primary btn-sm mb-3">Add Category</a>
        </div>

    </div>

    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>Category Id</th>
            <th>Category Description</th>
            <th>Actions</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td><c:out value="${category.id}"/></td>
                <td><c:out value="${category.description}"/></td>
                <td>
                    <a href="<c:url value='/categories/edit/${category.id}'/>" class="btn btn-primary">Update</a>
                    <a href="<c:url value='/categories/${category.id}'/>" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>