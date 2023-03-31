<%-- 
    Document   : jsp5
    Created on : 30 mar 2023, 13:43:17
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form id="form5" method="POST" action="AltaAlumno">
            <input type="text" name="valor" id="valor" value="ho" onblur="holaMundo('aa');"/>
            <input type="submit" name="enviar" value="Enviar"/>
        </form>
        <script>
            <!--
            var x = 0;
            x = x + 16;
            function holaMundo( variable ) {
                document.getElementById("valor").value = "" + x;
                alert (variable);
            }
            -->
        </script>
    </body>
</html>
