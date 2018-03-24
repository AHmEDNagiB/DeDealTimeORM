/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deal.servlet;

import com.deal.base.control.OrderDAO;
import com.deal.base.control.ProductDAO;
import com.deal.base.pojo.Customer;
import com.deal.base.pojo.Product;
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
 * @author nagib
 */
public class ProductByCategory extends HttpServlet {

    HttpSession session;
    ArrayList<Product> productsList = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(true);
        Customer customer = (Customer) session.getAttribute("loggedInUser");
        if (customer != null) {
            OrderDAO orderDAO = DbHandler.getOrderDAO();
                session.setAttribute("CustomerOrderNo", orderDAO.retrieveCustomerOrders(customer).size());
        }
        String searchInput = request.getParameter("cat");
        System.out.println("searchInput is : " + searchInput);
        ProductDAO productDAoObject = DbHandler.getProductDAO();
        if (productsList == null) {

            productsList = (ArrayList<Product>) productDAoObject.retrieveAllProducts();
        }
        ArrayList<Product> subProductsList = new ArrayList<>();
        productsList.stream().filter(p -> p.getProductCategory().getCategoryName().equalsIgnoreCase(searchInput))
                .forEach((t) -> {
                    subProductsList.add(t);
                });// filtering by name  

        request.setAttribute("ResultproductsList", subProductsList);
        request.setAttribute("ResultAllproductsNumber", subProductsList.size());
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setDateHeader("Expires", 0);
        request.getRequestDispatcher("WEB-INF/view/result.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
