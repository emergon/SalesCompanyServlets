package servlet.customer;

import entities.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CustomerService;

/**
 *
 * @author anastasios
 */
public class ListCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getContextPath();
        CustomerService service = new CustomerService();
        List<Customer> listOfCustomers = service.getCustomers();
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>List of Customers</title>")
                .append("</head>")
                .append("<body>")
                .append("<h1>Customers</h1>")
                .append("<a href=\"").append(contextPath).append("/customer/insert\">New Customer</a>")
                .append("<table border=\"1\">");
        for (Customer c : listOfCustomers) {
            builder.append("<tr>")
                    .append("<td>").append(c.getCcode()).append("</td>")
                    .append("<td>").append(c.getCname()).append("</td>")
                    .append("<td>").append("<a href=\"").append(contextPath).append("/customer/update?id=").append(c.getCcode()).append("\">update</a>").append("</td>")
                    .append("<td>").append("<a href=\"").append(contextPath).append("/customer/delete?id=").append(c.getCcode()).append("\">delete</a>").append("</td>")
                    .append("</tr>");
        }
        builder.append("</table>")
                .append("</body>")
                .append("</html>");

        PrintWriter out = response.getWriter();
        out.println(builder);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
