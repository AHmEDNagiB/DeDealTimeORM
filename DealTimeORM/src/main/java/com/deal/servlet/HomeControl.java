/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deal.servlet;

import com.deal.base.control.CategoryDAO;
import com.deal.base.control.OrderDAO;
import com.deal.base.control.ProductDAO;
import com.deal.base.pojo.Category;
import com.deal.base.pojo.Customer;
import com.deal.base.pojo.Product;
import com.deal.control.DbHandler;
import java.io.IOException;
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
public class HomeControl extends HttpServlet {

    HttpSession session;
    ArrayList<Product> products = null;
    List<Category> categoryList;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        session = request.getSession(true);
        Customer customer = (Customer) session.getAttribute("loggedInUser");
        if (customer != null) {
            OrderDAO orderDAO = DbHandler.getOrderDAO();
            session.setAttribute("CustomerOrderNo", orderDAO.retrieveCustomerOrders(customer).size());
        }
        ProductDAO productDAoObject = DbHandler.getProductDAO();
        CategoryDAO categoryDAOObject = DbHandler.getCategoryDAO();
        products = (ArrayList<Product>) productDAoObject.retrieveAllProducts();
        categoryList = categoryDAOObject.retrieveAllCategories();
        List<Product> subProductsList = null;
        String pageNamber = request.getParameter("page");
        if (pageNamber != null) {
            int pageNamberIntger = 0;
            try {
                pageNamberIntger = Integer.parseInt(pageNamber);
                if (pageNamberIntger == (products.size() / 5) + 1) {
                    subProductsList = products.subList((pageNamberIntger - 1) * 5, products.size());
                } else {
                    subProductsList = products.subList((pageNamberIntger - 1) * 5, (pageNamberIntger - 1) * 5 + 5);
                }
            } catch (Exception e) {
                subProductsList = products.subList(0, 5);
            }

        } else {
            subProductsList = products.subList(0, 5);
        }
        request.setAttribute("productsList", subProductsList);
        request.setAttribute("AllproductsNumber", products.size());
        session.setAttribute("Allcategories", categoryList);
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setDateHeader("Expires", 0);
        request.getRequestDispatcher("index.jsp").forward(request, response);

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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
