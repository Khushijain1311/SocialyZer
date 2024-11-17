<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Competitor</title>
    <link rel="stylesheet" href="styles/addCompetitor.css"/>
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
            <h2 id="register-heading">Add Competitor</h2>
            <form id="registerForm">
                <div class="input-group">
                    <label for="competitor">Enter Competitor name :</label>
                    <input type="text" id="competitor" name="competitor" placeholder="Enter Competitor name" required>
                </div>
              
               

                   <button class="btnanchor"> <a href="competitorgraph.jsp">Add</a></button>
            </form>
        </div>
    </div>
        </div>
    
</body>
</html>