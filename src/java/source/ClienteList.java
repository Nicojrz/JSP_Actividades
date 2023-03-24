package source;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Nicojrz
 */

@WebServlet(name = "ClienteList", urlPatterns = {"/ClienteList"})
public class ClienteList extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int i = 0;
            List<Cliente> clientes = null;
            HttpSession session = null;
            
            session = request.getSession( );
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteList</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>Nombre</td>");
            out.println("<td>Apellido Paterno</td>");
            out.println("<td>Apellido Materno</td>");
            out.println("<td>Edad</td>");
            out.println("<td>Acciones</td>");
            out.println("</tr>");
            clientes = (List<Cliente>) session.getAttribute("clientes" );
            if( clientes != null && !clientes.isEmpty() )
            {
                for( Cliente cliente : clientes )
                {
                    out.println("<tr>");
                    out.println( String.format( "<td>%s</td>" , cliente.getNombre() ) );
                    out.println( String.format( "<td>%s</td>" , cliente.getApellidopat() ) );
                    out.println( String.format( "<td>%s</td>" , cliente.getApellidomat() ) );
                    out.println( String.format( "<td>%d</td>" , cliente.getEdad() ) );
                    out.println( String.format( "<td><a href=\"#\">Borrar</a> <a href=\"#\">Editar</a></td>"  ) );
                    out.println("</tr>");
                }
            }
            out.println("</table>");
            out.println("<a href=\"AgregaCliente\">Nuevo cliente</a> ");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
