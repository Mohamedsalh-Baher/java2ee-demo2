<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cylinder Volume Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@include file="../../main-nav.jsp" %>

<div class="container mt-5">
    <h1 class="text-center">Cylinder Volume Calculator</h1>

    <!-- Display error message if any -->
    <c:if test="${not empty errorMessage}">
        <p style="color:red;">${errorMessage}</p>
    </c:if>

    <!-- Input form -->
    <form action="calculateVolume" method="post" class="mt-4">
        <div class="mb-3">
            <label for="radius" class="form-label">Radius</label>
            <input type="text" id="radius" name="radius" class="form-control" placeholder="Enter radius in units" required>
        </div>
        <div class="mb-3">
            <label for="height" class="form-label">Height</label>
            <input type="text" id="height" name="height" class="form-control" placeholder="Enter height in units" required>
        </div>
        <button type="submit" class="btn btn-primary">Calculate Volume</button>
    </form>

    <!-- Display the volume if calculated -->
    <c:if test="${not empty cylinderVolume}">
        <h2>Calculated Volume:</h2>
        <p>${cylinderVolume}</p>
    </c:if>

    <!-- Link back to index.jsp -->
    <p><a href="index.jsp">Back to Home</a></p>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>


