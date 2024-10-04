<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="ISO-8859-1">
    <title>Welcome To Management System</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .navbar {
            margin-bottom: 20px;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
            color: #343a40;
        }

        .container {
            max-width: 800px;
            margin: auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
    </style>
</head>

<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
    <a class="navbar-brand" href="/assets">Asset Management</a>
    <a class="navbar-brand" href="employees">Employee Management</a>
    <a class="navbar-brand" href="categories">Category Management</a>
</nav>

<div class="container">
    <h1>Welcome to my  Management System</h1>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3oAiTqTq6UDEwdLZc2fYlrQz1/3E3G8G5/VG6ao8zQ6Q3lJKm4kz4/c7xH49dS"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
        integrity="sha384-8M+AjLKwFvNMqWCrW32wO2Ib56M4C7pc1N8BvK6KAdp2HwphD+Xidi9GakFhK+T1"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4CL8E+Knujsl5/16tQHggE/q51c3H/GgK6Y6S3QQ24eE7AHqc5Fo5UO"
        crossorigin="anonymous"></script>
</body>

</html>