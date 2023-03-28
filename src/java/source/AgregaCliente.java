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
import javax.servlet.http.HttpSession;

/**
 * @author Nicojrz
 */

@WebServlet(name = "AgregaCliente", urlPatterns = {"/AgregaCliente"})
public class AgregaCliente extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
                String nombre = null;
                String apellidopat = null;
                String apellidomat = null;
                String edad = null;
                String guardar = null;
                String id = null;
                String editar = null;
                String accion = "guardar";
                String actualizar = "guardar";
                Cliente cliente = null;
                List<Cliente>lista = null;
                HttpSession session = request.getSession();
                
                if(session != null)
                {
                    if(session.getAttribute("lista") == null)
                    {
                        session.setAttribute("lista", new ArrayList<Cliente>());
                    }
                    lista = (List)session.getAttribute("lista");
                }
                
                nombre = request.getParameter("nombre");
                apellidopat = request.getParameter("apellidopat");
                apellidomat = request.getParameter("apellidomat");
                edad = request.getParameter("edad");
                guardar = request.getParameter("guardar");
                id = request.getParameter("id");
                editar = request.getParameter("editar");
                actualizar = request.getParameter("actualizar");
                
                if("submit".equals(editar)) {
                    if(Integer.parseInt(id) < lista.size()) {
                        cliente = lista.get(Integer.parseInt(id));
                    }
                }
                
                if("submit".equals(guardar) || "submit".equals(actualizar)) {
                    if("submit".equals(guardar)) {
                        cliente = new Cliente();
                    }
                    else {
                        cliente = lista.get(Integer.parseInt(id));
                    }
                    cliente.setNombre(nombre);
                    cliente.setApellidopat(actualizar);
                    cliente.setApellidomat(actualizar);
                    cliente.setEdad(Integer.parseInt(edad));
                    if("submit".equals(guardar)) {
                        lista.add(cliente);
                    }
                }
                
                if(cliente == null) {
                    cliente = new Cliente();
                    cliente.setNombre("");
                    cliente.setApellidopat("");
                    cliente.setApellidomat("");
                    cliente.setEdad(0);
                }
                
                if(!"submit".equals(guardar) && !"submit".equals(actualizar)) {
                    try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet AgregaCliente</title>");            
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<form id=\"form1\">");
                        out.println("<table border=\"1\">");
                        out.println("<tr>");
                        out.println("<td>Nombre</td><td>");
                        out.println("<input id=\"nombre\" name=\"nombre\" type=\"text\" value=\""+cliente.getNombre()+"\"/>");
                        out.println("</td>");
                        out.println("<tr>");
                        out.println("<td>Apellido Paterno</td><td>");
                        out.println("<input id=\"apellidoP\" name=\"apellidoP\" type=\"text\" value=\""+cliente.getApellidopat()+"\"/>");
                        out.println("</td>");
                        out.println("<tr>");
                        out.println("<td>Apellido Materno</td><td>");
                        out.println("<input id=\"apellidoM\" name=\"apellidoM\" type=\"text\" value=\""+cliente.getApellidomat()+"\"/>");
                        out.println("</td>");
                        out.println("<tr>");
                        out.println("<td>Edad</td><td>");
                        out.println("<input id=\"edad\" name=\"edad\" type=\"number\" value=\""+cliente.getEdad()+"\"/>");
                        out.println("</td>");
                        out.println("<tr>");
                        out.println("<td colspan=\"2\"><input id=\"guardar\" name=\""+accion+"\" value=\"Guardar\"  type=\"submit\" /></td>");
                        out.println("</tr>");
                        out.println("</table>");
                        out.println("</form>");           
                        out.println("</body>");
                        out.println("</html>");
                    }
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
