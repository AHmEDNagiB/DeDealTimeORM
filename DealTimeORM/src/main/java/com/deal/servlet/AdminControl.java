package com.deal.servlet;

import com.deal.base.model.Admin;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminControl extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Admin mAdmin = null;
        if (request.getSession(false) != null) {
            mAdmin = (Admin) request.getSession(false).getAttribute("loggedInUser");
        }
        request.setAttribute("admin", mAdmin);
        
        request.getRequestDispatcher("WEB-INF/view/adminControlPanel.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // post action
    }
    
    @Override
    public String getServletInfo() {
        return "Administration";
    }
    
}
