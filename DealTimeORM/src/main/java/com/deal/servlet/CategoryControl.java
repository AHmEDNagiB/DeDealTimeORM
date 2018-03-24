package com.deal.servlet;

import com.deal.base.pojo.Category;
import com.deal.control.DbHandler;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahmoud.Marzouk
 */
public class CategoryControl extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DbHandler.getCategoryDAO().insertCategory(new Category(request.getParameter("categoryName")));
        response.sendRedirect("/DealTime/administration");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("categoryId"));
        String result = DbHandler.getCategoryDAO().deleteCategory(new Category(request.getParameter("categoryName")));
        response.getWriter().write(result);
    }
    
}
