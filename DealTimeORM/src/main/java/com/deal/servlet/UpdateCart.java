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
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nagib
 */
public class UpdateCart extends HttpServlet {

    HttpSession session;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("loggedInUser");
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String productId = request.getParameter("changedOrders[" + i + "][orderId]");
            String quantity = request.getParameter("changedOrders[" + i + "][quantity]");
            System.out.println("productId : " + productId + " && quantity : " + quantity);
            if (productId == null) {
                break;
            } else {
                OrderDAO orderDAOObject = DbHandler.getOrderDAO();
                Order order =orderDAOObject.retrieveOrder(Long.parseLong(productId));
                order.setQuantity(new BigDecimal(quantity));
                orderDAOObject.updateOrder(order);
//                String res = OrderDAOObject.updateOrder(Integer.parseInt(productId), Integer.parseInt(quantity));
//                System.out.println(res);
            }

        }
//        session = request.getSession(true);
//        OrderDAO OrderDAOObject = DbHandler.getOrderDAO();
//        ArrayList<Order> chartLines = OrderDAOObject.retrieveCustomerOrders(new Customer(1));
//        for (Order chartLine : chartLines) {
//            System.out.println(chartLine.getOrderProduct().getProductName());
//
//        }
//        chartLines.remove(0);
//        session.setAttribute("Items", chartLines);
//        request.getRequestDispatcher("WEB-INF/view/productControlPanel.jsp").forward(request, response);
//            Gson gsonUser = request.getParameter(name);
//        processRequest(request, response);
    }

}
