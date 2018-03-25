package com.deal.servlet;

import com.deal.base.pojo.Admin;
import com.deal.base.pojo.Admin;
import com.deal.control.DbHandler;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminProfile extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Admin mAdmin = null;
        if (request.getSession(false) != null) {
            mAdmin = (Admin) request.getSession(false).getAttribute("loggedInUser");
        }
        request.setAttribute("admin", mAdmin);
        request.getRequestDispatcher("WEB-INF/view/adminProfile.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String adminEmail = request.getParameter("email");
        String adminPassword = request.getParameter("password");
        String adminFirstName = request.getParameter("firstname");
        String adminLastName = request.getParameter("lastname");
        String adminAddress = request.getParameter("address");
        String adminJob = request.getParameter("job");
        String adminPhoneNo = request.getParameter("phoneNo");
        LocalDate adminDOB = LocalDate.parse(request.getParameter("dateOfBirth"));
        
        Admin admin = (Admin) request.getSession(false).getAttribute("loggedInUser");
        admin.setEmail(adminEmail);
        admin.setPassword(adminPassword);
        admin.setFirstName(adminFirstName);
        admin.setLastName(adminLastName);
        admin.setAddress(adminAddress);
        admin.setJob(adminJob);
        admin.setPhoneNumber(adminPhoneNo);
        admin.setDateOfBirth(Date.valueOf(adminDOB));
        String updateResult = DbHandler.getAdminDAO().updateAdmin(admin);
        response.getWriter().write(updateResult);
    }

}
