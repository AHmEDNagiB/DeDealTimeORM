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
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahmoud.Marzouk
 */
@WebFilter(filterName = "AdminHomeFilter", urlPatterns = {"/dealTime"})
public class AdminHomeFilter implements Filter {
    
    private FilterConfig filterConfig = null;
    
    public AdminHomeFilter() {
    }    

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        String userType = null;
        if (((HttpServletRequest)request).getSession(false) != null) {
            userType = (String) ((HttpServletRequest)request).getSession(false).getAttribute("userType");
        }
        if (userType != null && userType.equals("a")) {
//            System.out.println("hello 1");
            ((HttpServletResponse)response).sendRedirect("administration");
        } else {
            request.getRequestDispatcher("dealTime").forward(request, response);
        }
        
    }

    public void destroy() {
    }
    
}
