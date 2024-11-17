<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/register.css">
    <title>Register</title>
</head>
<body>
    <div class="container">
    <!--navbar -->
<div class="navbar">
    <a href="index.jsp">Home</a>
    <a href="dashBoard.jsp" class="right">Dashboard</a>
    <a href="login.jsp" class="right">Login</a>
  </div>

  <!--login page-->
  <div class="register ">
    <div class="register-container shadow">
        <h2 id="register-heading">Register</h2>
        <form id="registerForm">
            <div class="input-group">
                <label for="email">Enter Email:</label>
                <input type="email" id="email" name="email" placeholder="email" required>
            </div>
            <div class="input-group">
                <label for="password">Enter Password:</label>
                <input type="password" placeholder="Password" id="password" name="password" required>
            </div>
            <div class="input-group">
                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" id="confirmPassword" placeholder="Confirm password" name="confirmPassword" required>
            </div>
            <button type="submit" class="btn">Register</button>
        </form>
    </div>
</div>

    </div>

    <script>
        document.getElementById("registerForm").addEventListener("submit", function(event) {
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirmPassword").value;
    
            if (password !== confirmPassword) {
                alert("Passwords do not match");
                event.preventDefault();
            }
        });
    </script>
</body>
</html>