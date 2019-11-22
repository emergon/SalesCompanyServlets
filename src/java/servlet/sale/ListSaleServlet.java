/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.sale;

import entities.Sale;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SaleService;

/**
 *
 * @author anastasios
 */
@WebServlet(name = "ListSaleServlet", urlPatterns = {"/listSale"})
public class ListSaleServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SaleService service = new SaleService();
        List<Sale> listOfSales = service.getSales();
        request.setAttribute("listOfSales", listOfSales);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sale/listSale.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
}
