/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deal.servlet;

import com.deal.base.control.OrderDAO;
import com.deal.base.pojo.Customer;
import com.deal.base.pojo.Product;
import com.deal.control.DbHandler;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ElsOoObkey
 */
public class ProductDetails extends HttpServlet {

    HttpSession session;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  response.setContentType("text/html;charset=UTF-8");

        Product product = null;
        session = request.getSession(true);
        Customer customer = (Customer) session.getAttribute("loggedInUser");
        if (customer != null) {
            OrderDAO orderDAO = DbHandler.getOrderDAO();
            session.setAttribute("CustomerOrderNo", orderDAO.retrieveCustomerOrders(customer).size());
        }
        if (request.getParameter("productId") != null) {
            try {
                product = DbHandler.getProductDAO().retrieveProduct(Long.parseLong(request.getParameter("productId")));
                if (product != null) {
                    request.setAttribute("product", product);
                    request.getRequestDispatcher("WEB-INF/view/productDetailsPanel.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("dealTime").forward(request, response);
                }

            } catch (Exception e) {
                request.getRequestDispatcher("dealTime").forward(request, response);
            }

        } else {
            request.getRequestDispatcher("dealTime").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
