/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deal.filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahmoud.Marzouk
 */
public class CustomerFilter implements Filter {

    private FilterConfig filterConfig = null;

    public CustomerFilter() {
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String userType = null;
        if (((HttpServletRequest)request).getSession(false) != null) {
            userType = (String) ((HttpServletRequest)request).getSession(false).getAttribute("userType");
        }
        if (userType != null && userType.equals("c")) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/DealTime");
        }
    }

    public void destroy() {
        
    }

}
