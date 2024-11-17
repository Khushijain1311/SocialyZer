<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel=" stylesheet" href="styles/competitorGraph.css"/>
    <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
    
</head>


<body>
    <div class="navbar">
        <a href="index.jsp">Home</a>
        <a href="dashBoard.jsp" class="right">Dashboard</a>
        <a href="login.jsp" class="right">Logout</a>
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
           <div class="box1" >1000 likes</div>
           <div class="box2">1000 likes</div>
        </div>
        <div class="statistic-content-box">
            <div class="box1" >1000 shares</div>
           <div class="box2">1000 shares</div>
        </div>
        <div class="statistic-content-box">
            <div class="box1" >1000 followers</div>
           <div class="box2">1000 follower</div>
        </div>

        <div class="statistic-content-box">
            <div class="box1" >Positive sentiment</div>
           <div class="box2">Positive sentiment</div>
        </div>
    </div>

    <div class="graph-container">
        <div class="graph-box">
            <div class="graph-heading">
                heading 1
            </div>
            <div class="graph" id="graph3">
                
            </div>
        </div>


   </div>
  </div>
  <!-- <div class="footer">footer</div> -->
 
 <script src="js/competitorGraph.js"></script>
</body>
</html>