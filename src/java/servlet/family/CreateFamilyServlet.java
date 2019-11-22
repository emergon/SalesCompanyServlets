package servlet.family;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.FamilyService;

@WebServlet(name = "CreateFamilyServlet", urlPatterns = {"/family/createFamily"})
public class CreateFamilyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int salesmanId = Integer.parseInt(request.getParameter("salesman"));
        HttpSession session = request.getSession();
        session.setAttribute("salesmanId", salesmanId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/family/formFamily.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FamilyService service = new FamilyService();
        String name = request.getParameter("name");
        String relationship = request.getParameter("relation");
        String dob = request.getParameter("dob");
        HttpSession session = request.getSession();
        int salesmanId = (Integer)session.getAttribute("salesmanId");
        session.removeAttribute("salesmanId");
        service.createFamily(name, relationship, dob, salesmanId);
        request.setAttribute("message", "Family created successfully");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/salesman/viewSalesman?id="+salesmanId);
        dispatcher.forward(request, response);
    }

    
}
