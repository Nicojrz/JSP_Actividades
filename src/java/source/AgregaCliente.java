package source;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicojrz
 */

@WebServlet(name = "AgregaCliente", urlPatterns = {"/AgregaCliente"})
public class AgregaCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
            out.println("<td> Nombre </td>");
            out.println("<td><input id=\"form1\" name=\"nombre\" type=\"text\"></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td> Apellido Pat </td>");
            out.println("<td><input id=\"form1\" name=\"apellidopat\" type=\"text\"></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td> Apellido Mat </td>");
            out.println("<td><input id=\"form1\" name=\"apellidomat\" type=\"text\"></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td> Edad </td>");
            out.println("<td><input id=\"form1\" name=\"edad\" type=\"number\"></td>");
            out.println("</tr>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan=\"2\"><input id=\"form1\" name=\"edad\" type=\"number\"></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
