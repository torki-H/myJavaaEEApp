<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Assigned Employees</title>
</head>
<body>
<h1>Assigned Employees to Assets</h1>
<table>
    <thead>
    <tr>
        <th>Employee ID</th>
        <th>Employee Name</th>
        <th>Asset ID</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="assignment" items="${assignedEmployees}">
        <tr>
            <td>${assignment.employee.id}</td>
            <td>${assignment.employee.name}</td>
            <td>${assignment.asset.id}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>