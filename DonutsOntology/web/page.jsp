<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" >

        <title>Doughnut Search</title>
    </head>
    <body  style="background: url(resources/food.png)">
    <center>
        <br>
        <h1>Doughnut Search</h1><br>
         <img src="resources/3.png" style="width: 500px" />
        <img src="resources/2.png" style="width: 500px" />
        </center>
    <form style="margin-left: 10%;margin-right: 10%" action="QueryDonuts" method="POST">
            <div class="form-group">
                <label for="Bases">Doughnut Bases</label>
                <select class="form-control" name="base" >
                    <c:forEach var="b" items="${bases}" >
                        <option <c:if test="${b eq base}">selected="true"</c:if>>${b}</option>
                    </c:forEach>                    
                </select>

            </div>
            <div class="form-group">
                <label for="Frostings">Doughnut Frostings</label>
                <select class="form-control" name="frost">
                    <c:forEach var="frosting" items="${frostings}" >
                    <option <c:if test="${frosting eq frost}">selected="true"</c:if>>${frosting}</option>
                    </c:forEach>   
                </select>

            </div>
<%--
            <div class="form-group">
                <label for="Bases">Topping 1</label>
                <div class="row">
                    <div class="col-md-6" >

                        <select  class="form-control" id="topping1" onchange="changeToppingSelect(1)" name="topping1">
                            <option value="None">None</option>
                            <option value="ChocolateTopping">ChocolateTopping</option>
                            <option value="FruitTopping">FruitTopping</option>
                            <option value="SugarTopping">SugarTopping</option>

                        </select>
                    </div>
                    <div  class="col-md-6" >
                        <select class="form-control" id="subtopping1" name="subtopping1">

                        </select>
                    </div>
                </div>

            </div>
            
            <div class="form-group">
                <label for="Bases">Topping 2</label>
                <div class="row">
                    <div class="col-md-6" >

                        <select  class="form-control" id="topping2" onchange="changeToppingSelect(2)" name="topping2">
                            <option value="None">None</option>
                            <option value="ChocolateTopping">ChocolateTopping</option>
                            <option value="FruitTopping">FruitTopping</option>
                            <option value="SugarTopping">SugarTopping</option>

                        </select>
                    </div>
                    <div  class="col-md-6" >
                        <select class="form-control" id="subtopping2" name="subtopping2">

                        </select>
                    </div>
                </div>

            </div>
            
            <div class="form-group">
                <label for="Bases">Topping 3</label>
                <div class="row">
                    <div class="col-md-6" >

                        <select  class="form-control" id="topping3" onchange="changeToppingSelect(3)" name="topping3">
                            <option value="None">None</option>
                            <option value="ChocolateTopping">ChocolateTopping</option>
                            <option value="FruitTopping">FruitTopping</option>
                            <option value="SugarTopping">SugarTopping</option>

                        </select>
                    </div>
                    <div  class="col-md-6" >
                        <select class="form-control" id="subtopping3" name="subtopping3">

                        </select>
                    </div>
                </div>

            </div>--%>
            <button class="btn btn-info" style="float: right" >Submit Query</button>

        </form>
    
    <br/><br/><br/>
    <table class="table table-bordered table-hover table-striped" style="margin-left: 10%;margin-right: 10%;width: 80%" >
        <tr><th>Donut</th><th>Sugar Content</th></tr>
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

     
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="resources/js/jquery-3.3.1.slim.min.js"></script>
        <script src="resources/js/popper.min.js" ></script>
        <script src="resources/js/bootstrap.min.js"></script>
        <script>
                            function changeToppingSelect(i) {

                                switch (document.getElementById("topping" + i).value) {
                                    case "ChocolateTopping":
                                        document.getElementById("subtopping" + i).innerHTML = "<option>ChocolateChipTopping</option>"
                                                + "<option>ChocolateDrizzleTopping</option>"
                                                + "<option>ChocolateSprinkleTopping</option>";
                                        break;
                                    case "FruitTopping":
                                        document.getElementById("subtopping" + i).innerHTML = "<option>CherryTopping</option>"
                                                + "<option>StrawberryTopping</option>"
                                                + "<option>RaisinTopping</option>"
                                                + "<option>NutsTopping</option>"
                                                + "<option>WalnutTopping</option>"
                                                + "<option>PeanutTopping</option>"
                                                + "<option>HazelnutTopping</option>";
                                        break;
                                    case "SugarTopping":
                                        document.getElementById("subtopping" + i).innerHTML = "<option>CookieCrumbleTopping</option>"
                                                + "<option>HoneyDrizzleTopping</option>"
                                                + "<option>MarshmellowTopping</option>"
                                                + "<option>SugarSprinkleTopping</option>"
                                                + "<option>ToastedCoconutTopping</option>";
                                        break;
                                    default :
                                        document.getElementById("subtopping" + i).innerHTML = "";
                                        break;
                                }
                            }
        </script>
    </body>
</html>