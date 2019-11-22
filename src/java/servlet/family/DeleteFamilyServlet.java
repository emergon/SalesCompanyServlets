/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.family;

import servlet.family.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.FamilyService;

/**
 *
 * @author anastasios
 */
@WebServlet(name = "DeleteFamilyServlet", urlPatterns = {"/family/deleteFamily"})
public class DeleteFamilyServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FamilyService service = new FamilyService();
        int code = Integer.parseInt(request.getParameter("id"));
        int salesmanId = Integer.parseInt(request.getParameter("salesman"));
        service.deleteFamilyById(code);
        request.setAttribute("message", "Family member deleted successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/salesman/viewSalesman?id="+salesmanId);
        dispatcher.forward(request, response);
    }

    

    
}
