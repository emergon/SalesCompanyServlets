package servlet.salesman;

import entities.Salesman;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SalesmanService;

@WebServlet(name = "ViewSalesmanServlet", urlPatterns = {"/salesman/viewSalesman"})
public class ViewSalesmanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SalesmanService service = new SalesmanService();
        int code = Integer.parseInt(request.getParameter("id"));
        Salesman s = service.getSalesmanWithFamily(code);
        request.setAttribute("salesman", s);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/salesman/viewSalesman.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
