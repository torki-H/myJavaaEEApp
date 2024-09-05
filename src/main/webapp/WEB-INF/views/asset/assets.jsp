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
        <h1>List of Assets</h1>
    </div>

    <div class="row">
        <div class="col-lg-2">
            <a href="<c:url value='/assets/new'/>" class="btn btn-primary btn-sm mb-3">Add Asset</a>
        </div>
        <div class="col-lg-2">
            <form style="display: flex; align-items: center;" action="<c:url value='/assetSearch'/>" method="post">
                <label style="display: inline-block">title:</label>
                <input class="input-details" type="text" id="title" name="title">
                <button class="button-details" type="submit">Search</button>
            </form>
        </div>
    </div>

    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>Asset Id</th>
            <th>Asset Title</th>
            <th>Asset Description</th>
            <th>Asset Healthy Status</th>
            <th>Category</th>
            <th>Actions</th>
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
                <td><c:out value="${asset.categoryEntity.getDescription()}"/></td>
                <td>
                    <a href="<c:url value='/assets/edit/${asset.id}'/>" class="btn btn-primary">Update</a>
                    <a href="<c:url value='/assets/${asset.id}'/>" class="btn btn-danger">Delete</a>
                    <a href="<c:url value='/assets/${asset.id}/assign'/>" class="btn btn-primary">Assign</a>
                    <a href="<c:url value='/assets/${asset.id}/unAssign'/>" class="btn btn-danger">UnAssign</a>

                    <c:choose>
                        <c:when test="${asset.healthyStatus == 'false'}">
                            <a href="<c:url value='/assets/${asset.id}/aboard'/>" class="btn btn-primary">aboard</a>
                        </c:when>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>