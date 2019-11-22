package servlet.sale;

import entities.Customer;
import entities.Product;
import entities.Salesman;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SaleService;

@WebServlet(name = "CreateSaleServlet", urlPatterns = {"/sale/createSale"})
public class CreateSaleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SaleService service = new SaleService();
        List<Salesman> listOfSalesman = service.listOfSalesman();
        List<Customer> listOfCustomer = service.listOfCustomer();
        List<Product> listOfProduct = service.listOfProduct();
        request.setAttribute("listOfSalesman", listOfSalesman);
        request.setAttribute("listOfCustomer", listOfCustomer);
        request.setAttribute("listOfProduct", listOfProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/sale/formSale.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SaleService service = new SaleService();
        service.createSale(request.getParameterMap());
        request.setAttribute("message", "Sale created successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listSale");
        dispatcher.forward(request, response);
    }

}
