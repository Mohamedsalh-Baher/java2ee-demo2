<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Fahrenheit to Celsius Converter</title>
</head>
<body>

<h1>Fahrenheit to Celsius</h1>
<p>Enter a temperature in Fahrenheit to convert it to Celsius. After submitting, the result will be displayed below.</p>

<form action="${pageContext.request.contextPath}/temp-converter" method="post">
    <label for="fahrenheit">Temperature in Fahrenheit:</label>
    <input type="text" id="fahrenheit" name="fahrenheit" placeholder="e.g., 32">
    <button type="submit">Convert</button>
</form>

<c:if test="${not empty resultMessage}">
    <p><strong>Result:</strong> ${resultMessage}</p>
</c:if>

<c:if test="${not empty errorMessage}">
    <p style="color: red;"><strong>Error:</strong> ${errorMessage}</p>
</c:if>

<p><a href="index.jsp">Back to Week 5</a></p>

</body>
</html>
