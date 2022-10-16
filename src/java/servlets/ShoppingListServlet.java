package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paulh
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = (String) session.getAttribute("username");

        if (action != null && action.equals("logout")) {
            session.invalidate();
            session = request.getSession();
            request.setAttribute("message", "Successfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }

        else if (username != null && action == null) {
            session.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("shoppingaction");
        String username = request.getParameter("username");
        String item = request.getParameter("item");
        
        ArrayList<String> itemList;
     
        if (session.getAttribute("itemList") == null) {
            itemList = new ArrayList();
        } 
        
        else {
            itemList = (ArrayList) session.getAttribute("itemList");
        }

        switch (action) {
            case "add":
            itemList.add(item);
            session.setAttribute("itemList", itemList);
            response.sendRedirect("ShoppingList");
            break;
            
            case "delete":
            itemList.remove(item);
            session.setAttribute("itemList", itemList);
            response.sendRedirect("ShoppingList");
            break;
        }
    }
}