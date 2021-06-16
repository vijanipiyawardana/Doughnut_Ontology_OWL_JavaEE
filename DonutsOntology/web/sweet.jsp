<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Yummy Doughnuts</title>
  </head>
  <body style="background: url(resources/food.png)">
  <center>
      <br>
        <h1>Yummy Doughnut Search</h1>  <br>
        <img src="resources/2.png" style="width: 500px" />
         <img src="resources/1.png" style="width: 500px" /><br><br>
  </center>
  
     <form style="margin-left: 10%;margin-right: 10%" action="SweetDonuts" method="POST">
            <div class="form-group">
                <label for="Sweetness">Sweetness</label>
                <select class="form-control" name="sweetValue">
                    <c:forEach   var="Sweetness" items="${sweetValues}" >
                    <option <c:if test="${Sweetness eq sweetValue}">selected="true"</c:if>>${Sweetness}</option>
                    </c:forEach>                    
                </select>

            </div>
           <button class="btn btn-info" style="float: right" >Submit Query</button>
    
    </form>  
   
                            

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 
      <br/><br/><br/>
    <table class="table table-bordered table-hover table-striped" style="margin-left: 10%;margin-right: 10%;width: 80%" >
        <tr><th>Donut</th>
            <!--th>Sugar Content</th-->
        </tr>
        <c:forEach items="${results}" var="row" >
            <tr>
        <c:forEach items="${row}" var="v" >
            <td>
                ${v}
            </td>
        </c:forEach>    
            </tr>
        </c:forEach>
    </table>
     
     </body>
</html>