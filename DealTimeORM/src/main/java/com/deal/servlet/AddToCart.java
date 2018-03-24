package com.deal.servlet;

import com.deal.base.control.OrderDAO;
import com.deal.base.control.ProductDAO;
import com.deal.base.pojo.Customer;
import com.deal.base.pojo.Order;
import com.deal.base.pojo.Product;
import com.deal.control.DbHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("dealTime");

        } else {
            Customer customer = (Customer) session.getAttribute("loggedInUser");
            String productId = request.getParameter("productDetailsId");
            if (customer != null || productId != null) {
                OrderDAO orderDAO = DbHandler.getOrderDAO();
                ProductDAO productDAO = DbHandler.getProductDAO();
                List<Order> existOrders = orderDAO.getOrderByProduct(customer, Integer.parseInt(productId));
                System.out.println("the list size is " + existOrders.size());
                if (existOrders.size() == 0) {
                    Product product = productDAO.retrieveProduct(Long.parseLong(productId));
                    Order newOrder = new Order(customer, product, BigDecimal.ONE, "c");
                    orderDAO.insertOrder(newOrder);
                } else {
                    response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
                }
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);

            }

        }
    }

}
