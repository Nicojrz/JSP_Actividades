<%-- 
    Document   : jsp4
    Created on : 28 mar 2023, 13:14:49
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>includes</title>
    </head>
    <body>
        <%
            int i = (int)(Math.random()*10);
            if(i < 5) {
        %>
        <jsp:include page="menu.jsp"/>
        <%
            }
            else {
        %>
        <jsp:include page="menu_1.jsp"/>
        <%
            }
        %>
        <h2>Contenido i=<%=i%></h2>
        <form id="form1" action="AltaAlumno" method="POST">
            <table border="10">
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" id="nombre" name="nombre"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" id="enviar" value="enviar"/></td>
                </tr>
            </table>    
        </form>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
