/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deal.servlet;

import com.deal.base.control.OrderDAO;
import com.deal.base.pojo.Customer;
import com.deal.base.pojo.Order;
import com.deal.control.DbHandler;
import java.io.IOException;
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
public class CustomerHistory extends HttpServlet {

    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("loggedInUser");
        OrderDAO OrderDAOObject = DbHandler.getOrderDAO();
        List<Order> HistoryLines = OrderDAOObject.retrieveCustomerHistory(customer);
        session.setAttribute("HistoryLines", HistoryLines);
        request.getRequestDispatcher("WEB-INF/view/userHistoryControlPane.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
