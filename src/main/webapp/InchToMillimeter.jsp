<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inch to Millimeter Converter</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Inch to Millimeter Converter</h1>
    <form method="post" action="convert2" class="mt-4">
        <div class="mb-3">
            <label for="inches" class="form-label">Enter Inches:</label>
            <input type="text" id="inches" name="inches" class="form-control"
                   value="<c:out value='${inchesInput}' />">
        </div>
        <button type="submit" class="btn btn-primary">Convert</button>
    </form>
    <div class="mt-4">
        <!-- Display error message -->
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger">${errorMessage}</div>
        </c:if>
        <!-- Display result message -->
        <c:if test="${not empty resultMessage}">
            <div class="alert alert-success">${resultMessage}</div>
        </c:if>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
