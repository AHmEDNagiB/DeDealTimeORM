package com.deal.servlet;

import com.deal.base.pojo.Category;
import com.deal.base.pojo.Product;
import com.deal.control.DbHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahmoud.Marzouk
 */
public class ProductsPanelControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Product> allProducts = (ArrayList<Product>) DbHandler.getProductDAO().retrieveAllProducts();
        request.setAttribute("products", allProducts);
        ArrayList<Category> allCategories = (ArrayList<Category>) DbHandler.getCategoryDAO().retrieveAllCategories();
        request.setAttribute("categories", allCategories);
        request.getRequestDispatcher("/WEB-INF/view/productsAdministration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operationType = request.getParameter("oper");
        switch (operationType) {
            case "delete" :
                long productId = Long.parseLong(request.getParameter("pId"));
                String result = DbHandler.getProductDAO().deleteProduct(productId);
                response.getWriter().write(result);
                break;
            case "categories" :
                long categoryId = Long.parseLong(request.getParameter("catId"));
                List<Product> categoryProducts = DbHandler.getProductDAO().retrieveCategoryProducts(categoryId);
                request.setAttribute("products", categoryProducts);
                ArrayList<Category> allCategories = (ArrayList<Category>) DbHandler.getCategoryDAO().retrieveAllCategories();
                request.setAttribute("categories", allCategories);
                request.getRequestDispatcher("/WEB-INF/view/productsAdministration.jsp").forward(request, response);
                break;
        }
    }
    
}
