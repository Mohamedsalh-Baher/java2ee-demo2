<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us</title>
</head>
<body>
<%@ include file="main-nav.jsp"%>
<h1>Contact Us</h1>
<form method="POST" action="/contact">
    <label for="email">Email:</label>
    <input type="text" id="email" name="email" value="${email}">
    <span style="color: red;">${emailError}</span>
    <br>

    <label for="subject">Subject:</label>
    <input type="text" id="subject" name="subject" value="${subject}">
    <span style="color: red;">${subjectError}</span>
    <br>

    <label for="messageBody">Message:</label>
    <textarea id="messageBody" name="messageBody" rows="4" cols="50">${messageBody}</textarea>
    <span style="color: red;">${messageError}</span>
    <br>

    <button id="sendButton" type="submit">Send</button>
    <div id="spinner" style="display: none;">Sending...</div>
</form>

<p style="color: green;">${successMessage}</p>
<p style="color: red;">${errorMessage}</p>

<script>
    document.getElementById('sendButton').addEventListener('click', function () {
        this.disabled = true;
        document.getElementById('spinner').style.display = 'inline';
    });
</script>
</body>
</html>

