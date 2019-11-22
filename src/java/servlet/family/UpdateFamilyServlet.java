/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.family;

import entities.Salesman;
import java.io.IOException;
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
@WebServlet(name = "UpdateSalesmanServlet", urlPatterns = {"/salesman/updateSalesman"})
public class UpdateFamilyServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SalesmanService service = new SalesmanService();
        int code = Integer.parseInt(request.getParameter("id"));
        Salesman salesman = service.getSalesmanById(code);
        request.setAttribute("salesman", salesman);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/salesman/formSalesman.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SalesmanService service = new SalesmanService();
        int code = Integer.parseInt(request.getParameter("scode"));
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        double commission = Double.parseDouble(request.getParameter("commission"));
        service.updateSalesman(code, name, city, commission);
        request.setAttribute("message", "Salesman updated successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listSalesman");
        dispatcher.forward(request, response);
        
    }

    
}
