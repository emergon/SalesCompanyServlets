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
@WebServlet(name = "CreateCustomerServlet", urlPatterns = {"/customer/insert"})
public class CreateCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        String contextPath = request.getContextPath();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>Insert Customer</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>New Customer</h1>")
                .append("<form action= \"").append(contextPath).append("/customer/insert\" method= \"post\">")
                .append("Cname:").append("<input type=\"text\" name=\"cname\">")
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
        service.create(name);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../customers");
        dispatcher.forward(request, response);
    }

    
}
