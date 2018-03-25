/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deal.servlet;

import com.deal.base.control.CustomerDAO;
import com.deal.base.pojo.Customer;
import com.deal.control.DbHandler;
import com.deal.utility.Validations;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ahmed_Mokhtar
 */
public class UserProfileControl extends HttpServlet {

    HttpSession session;
    Customer customer;
    Customer newCustomer = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("loggedInUser");
        if (newCustomer != null) {
            request.setAttribute("currentCustomer", newCustomer);
        } else {
            request.setAttribute("currentCustomer", customer);
        }
        request.getRequestDispatcher("WEB-INF/view/userProfileControlPanel.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(false);
        Customer customer = (Customer) session.getAttribute("loggedInUser");
        String firstNmae = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
//        String email = request.getParameter("email");
        LocalDate dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"));
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String job = request.getParameter("job");
        String address = request.getParameter("address");
        double credit = Double.parseDouble(request.getParameter("credit"));
        String mobileNumber = request.getParameter("mobileNumber");

        boolean isValid = isAllDataValid(password, confirmPassword, firstNmae, lastName, job, mobileNumber, credit);

        if (isValid) {
            CustomerDAO updatedCustomer = DbHandler.getCustomerDAO();
            customer.setCreditLimit(new BigDecimal(credit));
            customer.setJob(job);
            customer.setAddress(address);
            customer.setPhoneNumber(mobileNumber);
            customer.setFirstName(firstNmae);
            updatedCustomer.updateCustomer(customer);
            
        }

        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "User Profile";
    }

    private boolean isAllDataValid(String password, String confirmPassword, String firstName, String lastName,
            String job, String mobileNumber, double creditLimit) {

        boolean isValid = true;
        //testing

        boolean a2 = password.matches(confirmPassword);

        boolean a3 = Validations.passIsValid(password);

        boolean a4 = Validations.nameIsValid(firstName);

        boolean a5 = Validations.nameIsValid(lastName);

        boolean a6 = Validations.nameIsValid(job);

        boolean a7 = Validations.phoneIsValid(mobileNumber);

        boolean a8 = !(String.valueOf(creditLimit)).matches("[+]?([0-9]*\\.[0-9]+|[0-9]+)");
        a8 = true;

        if ((password.matches(confirmPassword)) != true || (Validations.passIsValid(password)) != true) {
            isValid = false;

        } else if ((Validations.nameIsValid(firstName)) != true) {
            isValid = false;

        } else if ((Validations.nameIsValid(lastName)) != true) {
            isValid = false;

        } else if ((Validations.nameIsValid(job)) != true) {
            isValid = false;

        } else if ((Validations.phoneIsValid(mobileNumber)) != true) {
            isValid = false;

        } else if (((String.valueOf(creditLimit)).matches("[+]?([0-9]*\\.[0-9]+|[0-9]+)")) != true) {
            isValid = true;
        }

        return isValid;
    }
}
