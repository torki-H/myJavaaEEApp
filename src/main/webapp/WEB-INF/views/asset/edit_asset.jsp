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
    <!-- Brand -->
    <a class="navbar-brand" href="#">Asset Management System</a>

</nav>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-lg-6 col-md-6 col-sm-6 container justify-content-center card">
            <h1 class="text-center">Update Asset</h1>

            <div class="card-body">
                <form action="<c:url value='/assets/${asset.id}/update'/>" method="POST">
                    <input type="hidden" name="_method" value="PUT" />
                    <div class="form-group">
                        <label>Asset Title</label>
                        <input
                                type="text"
                                name="title"
                                class="form-control"
                                placeholder="Enter Asset Title"
                                value="${asset.title}"
                        />
                    </div>

                    <div class="form-group">
                        <label>Asset Description</label>
                        <input
                                type="text"
                                name="description"
                                class="form-control"
                                placeholder="Enter Asset Description"
                                value="${asset.description}"
                        />
                    </div>

                    <div class="form-group">
                        <label>Asset Healthy Status</label>
                        <select name="healthyStatus" class="form-control">
                            <option value="true" <c:if test="${asset.healthyStatus == 'true'}"></c:if>>Healthy</option>
                            <option value="false" <c:if test="${asset.healthyStatus == 'false'}"></c:if>>Needs Repair</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Asset Category</label>
                        <%--                        <input--%>
                        <%--                                type="text"--%>
                        <%--                                name="categoryEntity"--%>
                        <%--                                class="form-control"--%>
                        <%--                                placeholder="Enter category name"--%>
                        <%--                                value="${asset.categoryEntity}"--%>
                        <%--                        />--%>

                        <select name="categoryEntity" class="form-control">
                            <c:forEach var="category" items="${categories}">
                                <option value="${category.id}" <c:if test="${asset.categoryEntity.id == category.id}">selected</c:if>>${category.description}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="box-footer d-flex justify-content-between">
                        <button type="submit" class="btn btn-primary">
                            Submit
                        </button>
                        <a href="<c:url value='/assets'/>" class="btn btn-primary">Back</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>