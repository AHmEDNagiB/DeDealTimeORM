package com.deal.servlet;


import com.deal.base.pojo.Customer;
import com.deal.control.DbHandler;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mahmoud.Marzouk
 */
public class CustomersPanelControl extends HttpServlet {
    HttpSession session =null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Customer> customers = (ArrayList<Customer>) DbHandler.getCustomerDAO().retrieveAllCustomers();
        /*
        session = request.getSession(true);
        Customer customer = (Customer) session.getAttribute("loggedInUser");
        if (customer != null) {
            OrderDAO orderDAO = DbHandler.getOrderDAO();
            session.setAttribute("CustomerOrderNo", orderDAO.retrieveCustomerOrders(customer).size());
        }
        */
        request.setAttribute("allCustomers", customers);
        request.getRequestDispatcher("/WEB-INF/view/customers.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
}
