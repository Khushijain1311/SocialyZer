<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>home</title>
    <link rel="stylesheet" href="styles/home.css"/>
    <link
    href="https://cdn.jsdelivr.net/npm/remixicon@4.2.0/fonts/remixicon.css"
    rel="stylesheet"
/>
</head>
<body>
    <!--complete code responsive-->
        <!--navbar -->
    <div class="navbar">
        <!-- <a href="/Pages/home.html">Home</a> -->
        <img src="images/logo2.png" alt="">
        <a href="dashBoard.jsp" class="right">Dashboard</a>
        <a href="login.jsp" class="right">Login</a>
      </div>
    
      <!--Hero section -->
      <div class="hero-container">
        <div class="hero-left">
            <div class="hero-left-top">
                Welcome to the Socialyzer your social media analytics tool.
            </div>
            <div class="hero-left-bottom">
                <h1>Services</h1>
                <ul>
                    <li> Sentiment Analysis.</li>
                    <li> Analytics result in graphical form.</li>
                    <li> Competitor Analysis.</li>
                </ul>

            </div>

        </div>
        <div class="hero-right">
            <img src="images/download.png"  class=" hero-image" alt=" Image of socialmedia analytics"/>
        </div>
      </div>
      
      <div class="footer">
        <p>&copy; 2024 Social Media Analytics Dashboard. All rights reserved.</p>
          <div class="social-icons">
            <!-- <i class="ri-twitter-fill"></i> -->
            <a href="https://www.facebook.com/"><img src="https://cdn.iconscout.com/icon/free/png-256/free-facebook-263-721950.png" alt="Facebook"></a>
            <a href="https://twitter.com/" ><img  id="twitterlogo" src="/images/twitterlogo.png" alt=""></a>
            <a href="https://www.instagram.com/"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTGv52zcXHLbInvZWxtVTGHtIcY0-qYmL-38g&usqp=CAU" alt="Instagram"></a>
           
          </div>
          
      </div>
    
        
    
</body>
</html>