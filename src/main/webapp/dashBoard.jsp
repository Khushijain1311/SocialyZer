<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel=" stylesheet" href="styles/dashBoard.css"/>
    <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
    
</head>


<body>
    <div class="navbar">
        <a href="index.jsp">Home</a>
        <a href="dashBoard.jsp" class="right">Dashboard</a>
        <a href="login.jsp" class="right">Login</a>
      </div>
    
  
  <div class="container">
    <div class="small-menu" onclick="show()">menu</div>
   <div class="side-nav">
    <div class="side-nav-top" onclick="closed()">
        close
    </div>
    <div class="side-nav-container">
        <a href="Filter.jsp">Filter</a>
        <a href="addCompetitor.jsp">Add 
            Competitor
        </a>
        <a href="addUser.jsp">Add user</a>
    </div>

   </div>

   <!--analytical information-->
   <div class="statistic-container">
    <div class="statistic-content-container">
        <div class="statistic-content-box">
            1000 likes
        </div>
        <div class="statistic-content-box">
            1000 shares
        </div>
        <div class="statistic-content-box">
            1000 followers

        </div>

        <div class="statistic-content-box">
            Postive sentiment score
        </div>
    </div>

    <div class="graph-container">
        <div class="graph-box">
            <div class="graph-heading">
                heading 1
            </div>
            <div class="graph" id="graph1">
                
            </div>
        </div>

        <div class="graph-box">
            <div class="graph-heading">
                heading 1
            </div>
            <div class="graph" id="graph2">
                
            </div>
        </div>
    </div>

   </div>
  </div>
  <!-- <div class="footer">footer</div> -->
 
 <script src="js/dashboardChart.js"></script>
</body>
</html>