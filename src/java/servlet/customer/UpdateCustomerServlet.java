/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.customer;

import entities.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CustomerService;

/**
 *
 * @author anastasios
 */
@WebServlet(name = "UpdateCustomerServlet", urlPatterns = {"/customer/update"})
public class UpdateCustomerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateCustomerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCustomerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ccode = Integer.parseInt(request.getParameter("id"));
        CustomerService service = new CustomerService();
        Customer customer = service.getCustomerById(ccode);
        StringBuilder builder = new StringBuilder();
        String contextPath = request.getContextPath();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Update Customer</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>Update Customer</h1>")
                .append("<form action= \"").append(contextPath).append("/customer/update\" method= \"post\">")
                .append("Ccode:").append("<input type=\"text\" name=\"ccode\" value=\"").append(customer.getCcode()).append("\" readonly>")
                .append("<br/>")
                .append("Cname:").append("<input type=\"text\" name=\"cname\" value=\"").append(customer.getCname()).append("\">")
                .append("<br/>")
                .append("<input type=\"submit\" value=\"Submit\">")
                .append("</form>")
                .append("</body>")
                .append("</html>");

        PrintWriter out = response.getWriter();
        out.println(builder);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerService service = new CustomerService();
        String name = request.getParameter("cname");
        int ccode = Integer.parseInt(request.getParameter("ccode"));
        service.update(ccode, name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../customers");
        dispatcher.forward(request, response);
    }

}
