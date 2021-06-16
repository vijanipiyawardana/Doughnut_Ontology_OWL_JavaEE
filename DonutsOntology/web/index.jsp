<%-- 
    Document   : index
    Created on : Jul 19, 2019, 2:21:21 PM
    Author     : vijani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" >

        <title>Doughnut Search Home</title>
    </head>
    <body  style="background: url(resources/food.png)">
    <center>
        <br>
        <h1>Doughnut World</h1>  <br>
        <img src="resources/pinkdonutfront-lr.jpg" style="width: 250px" /><br><br><br><br>

        <form style="margin-left: 10%;margin-right: 10%" action="StandardSearch" method="POST">    
            <button type="submit" class="btn btn-secondary btn-lg btn-block">Standard Search</button>
        </form>

        <br><br>

        <form style="margin-left: 10%;margin-right: 10%" action="GetSweetData" method="POST">    
            <button type="submit" class="btn btn-secondary btn-lg btn-block">Custom Search</button>
        </form>


    </center>

</body>
</html>
