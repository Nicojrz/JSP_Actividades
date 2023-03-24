package source;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Nicojrz
 */

@WebServlet(name = "AgregaCliente", urlPatterns = {"/AgregaCliente"})
public class AgregaCliente extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                String accion = null;
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet AgregaCliente</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    accion = request.getParameter("guardar" );
                    if(accion != null && "Guardar".equals(accion) )
                    {
                        guardaCliente(request);
                        redireccionar(out);
                    }
                    else
                    {
                        imprimirFormulario( out );
                    }
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
    
    public void imprimirFormulario( PrintWriter out ) {
        out.println("<form id=\"form1\">");
        out.println("<table border=\"1\">");
        out.println("<tr>");
        out.println("<td>Nombre</td><td>");
        out.println("<input id=\"nombre\" name=\"nombre\" type=\"text\" />");
        out.println("</td>");
        out.println("<tr>");
        out.println("<td>Apellido Paterno</td><td>");
        out.println("<input id=\"apellidoP\" name=\"apellidoP\" type=\"text\" />");
        out.println("</td>");
        out.println("<tr>");
        out.println("<td>Apellido Materno</td><td>");
        out.println("<input id=\"apellidoM\" name=\"apellidoM\" type=\"text\" />");
        out.println("</td>");
        out.println("<tr>");
        out.println("<td>Edad</td><td>");
        out.println("<input id=\"edad\" name=\"edad\" type=\"number\" />");
        out.println("</td>");
        out.println("<tr>");
        out.println("<td colspan=\"2\"><input id=\"guardar\" name=\"guardar\" value=\"Guardar\"  type=\"submit\" /></td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");           
    }

    private void guardaCliente(HttpServletRequest request) 
    {
        Cliente cliente = new Cliente();
        List<Cliente>list = null;
        cliente.setNombre(request.getParameter("nombre"));
        cliente.setApellidopat(request.getParameter("apellidoP"));
        cliente.setApellidomat(request.getParameter("apellidoM"));
        cliente.setEdad( getCampoInteger( request.getParameter("edad") ) );
        
        if( cliente.getApellidomat( ) == null || cliente.getApellidopat() == null || cliente.getNombre() == null || cliente.getEdad() == null ) {
            return;
        }
        
        list = (List<Cliente>) request.getSession().getAttribute("clientes");

        if( list == null ) {
            list = new ArrayList<>();
            request.getSession().setAttribute("clientes", list);
        }
        
        list.add(cliente);
    }
    
    private Integer getCampoInteger( String parametro ) {
        try {
            return Integer.valueOf(parametro);
        }
        catch(NumberFormatException ex) {
            return  null;
        }
    }
    
    private void redireccionar( PrintWriter out ) {
        out.print("<h3 style=\"margin-left: 20%; margin-top: 4%\">Registro exitoso</h3>");
        out.print("<a href=\"ClienteList\" style=\"margin-left: 20%\">Ir a la lista</a>");
    }
}
