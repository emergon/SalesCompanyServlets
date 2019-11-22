/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.salesman;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SalesmanService;

/**
 *
 * @author anastasios
 */
@WebServlet(name = "DeleteSalesmanServlet", urlPatterns = {"/salesman/deleteSalesman"})
public class DeleteSalesmanServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SalesmanService service = new SalesmanService();
        int code = Integer.parseInt(request.getParameter("id"));
        service.deleteSalesmanById(code);
        request.setAttribute("message", "Salesman deleted successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listSalesman");
        dispatcher.forward(request, response);
    }

    

    
}
