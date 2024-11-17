<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>


    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Account Details</title>
    <link rel="stylesheet"  href="styles/addaccounts.css"/>
</head>
<body>
    <div class="container">
        <!--navbar -->
    <div class="navbar">
        <a href="index.jsp">Home</a>
        <a href="dashBoard.jsp" class="right">Dashboard</a>
        <a href="login.jsp" class="right">Login</a>
      </div>
    
      <!--Add User page-->
      <div class="register ">
        <div class="register-container shadow">
            <h2 id="register-heading">Filter Selection</h2>
            <form id="registerForm">
                <div class="input-group">
                    <label for="platform-name">Enter Filter type:</label>
                    <input type="text" id="platform-name" name="platform-name" placeholder="Enter platform name" required>
                </div>
                <div class="input-group">
                    <label for="user-name">Enter Filter description:</label>
                    <input type="text" placeholder=" Enter the user name" id="user-name" name="user-name" required>
                </div>

               
               
                <button type="submit" class="btn">Submit</button>
            </form>
        </div>
    </div>
    
        </div>
    
</body>
</html>