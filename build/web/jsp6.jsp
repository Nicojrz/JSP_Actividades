<%-- 
    Document   : jsp6
    Created on : 31 mar 2023, 12:43:24
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Importes</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" href="style.css" type="text/css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;300;400;600;700;800;900&display=swap" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <h1 style="margin-top: 4%">Calculadora de IVA</h1> <br>
        <div class="container-sm">
            <table class="table table-light table-sm table-responsive">
              <thead>
                <tr>
                    <th scope="col">Nombre:</th>
                    <th scope="col">
                        <form id="form6" method="POST">
                            <input type="text" name="nombre" id="nombre"/>
                        </form>
                    </th>
                </tr>
              </thead>
              <tbody>
                <tr>
                    <th scope="col">Importe ($):</th>
                    <th scope="col">
                        <form id="form7" method="POST">
                            <input type="number" name="importe" id="importe" onblur="calcula()""/>
                        </form>
                    </th>
                </tr>
              </tbody>
              <tbody>
                <tr>
                    <th scope="col">IVA (%):</th>
                    <th scope="col">
                        <form id="form8" method="POST">
                            <input type="number" name="iva" id="iva" onblur="calcula()"/>
                        </form>
                    </th>
                </tr>
              </tbody>
              <tbody>
                <tr>
                    <th scope="col">Total:</th>
                    <th>
                        <form id="form9" />
                           <input type="number" name="iva" id="iva" disabled="true"/>
                        </form>
                    </th>
                </tr>
              </tbody>
            </table>
        </div>
        
        <script>
            <!--
            function calcula() {
                var importe = 0;
                var iva = 0;
                var total = 0;
                importe = document.getElementById("importe").value;
                iva = document.getElementById("iva").value;
                if(importe === '' || iva === '') {
                    return;
                }
                total = importe * (1+(iva/100));
                document.getElementById("total").value = total;
            }
            -->
        </script>
        
        <jsp:include page="footer.jsp"/>
    </body>
</html>
