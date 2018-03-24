/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deal.servlet;

import com.deal.base.control.CustomerDAO;
import com.deal.base.control.OrderDAO;
import com.deal.base.control.ProductDAO;
import com.deal.base.pojo.Customer;
import com.deal.base.pojo.Order;
import com.deal.base.pojo.Product;
import com.deal.control.DbHandler;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nagib
 */
public class CheckOutCart extends HttpServlet {

    HttpSession session;
    ArrayList<Product> productsList = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderDAO orderDAO = DbHandler.getOrderDAO();
        session = request.getSession(true);
        Customer customer = (Customer) session.getAttribute("loggedInUser");
        if (customer != null) {
            boolean flag1 = true;

            List<Order> customerOrderList = orderDAO.retrieveCustomerOrders(customer);
            for (Order order : customerOrderList) {
                if (order.getOrderProduct().getAvailableQuantity().longValue() < order.getQuantity().longValue()) {
                    System.out.println("there is one");
                    flag1 = false;
                    break;
                }
            }
            if (!flag1) {
                response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);

            } else {
                orderDAO.updateCustomerOrders(customer.getCustId());
                CustomerDAO CustomerDAOObj = DbHandler.getCustomerDAO();
                customer.setCreditLimit(new BigDecimal(request.getParameter("newCridet")));
                CustomerDAOObj.updateCustomer(customer);
                session.setAttribute("loggedInUser", customer);
                session.setAttribute("CustomerOrderNo", 0);
                for (Order order : customerOrderList) {
                    ProductDAO productDAOobject = DbHandler.getProductDAO();
                    Product p = order.getOrderProduct();
                    System.out.println("p.getAvailableQuantity() " + p.getAvailableQuantity());
                    System.out.println("order.getQuantity() " + order.getQuantity());
                    p.setAvailableQuantity(p.getAvailableQuantity().subtract(order.getQuantity()));
                    productDAOobject.updateProduct(p);

                }
            }

        }
    }

}
