package servlet.salesman;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SalesmanService;

@WebServlet(name = "CreateSalesmanServlet", urlPatterns = {"/salesman/createSalesman"})
public class CreateSalesmanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/salesman/formSalesman.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SalesmanService service = new SalesmanService();
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        double commission = Double.parseDouble(request.getParameter("commission"));
        service.createSalesman(name, city, commission);
        request.setAttribute("message", "Salesman created successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listSalesman");
        dispatcher.forward(request, response);
    }

    
}
