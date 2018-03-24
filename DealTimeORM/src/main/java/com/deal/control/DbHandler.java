package com.deal.control;

import com.deal.base.control.AdminDAO;
import com.deal.base.control.CategoryDAO;
import com.deal.base.control.CustomerDAO;
import com.deal.base.control.DbConn;
import com.deal.base.control.OrderDAO;
import com.deal.base.control.ProductDAO;
import java.sql.Connection;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;

public class DbHandler {

    static SessionFactory sessionFactory = null;
    static Session orderDAOSession = null;
    static Session productDAOSession = null;
    static Session categoryDAOSession = null;
    static Session customerDAOSession = null;
    static Session adminDAOSession = null;
    static AdminDAO adminDAO = null;
    static CustomerDAO customerDAO = null;
    static CategoryDAO categoryDAO = null;
    static ProductDAO productDAO = null;
    static OrderDAO orderDAO = null;
    static Statistics stats = null;

    private DbHandler() {
    }

    private static Connection getDbConnection() {
        Connection mConn = null;
        System.out.println("calling getDbConnection() ...");
        try {
            if (sessionFactory == null) {
                System.out.println("************** loading hibernate.cfg.xml **************");
                sessionFactory = new Configuration()
                        .configure("/hibernate.cfg.xml").buildSessionFactory();
                orderDAOSession = sessionFactory.openSession();
                productDAOSession = sessionFactory.openSession();
                categoryDAOSession = sessionFactory.openSession();
                customerDAOSession = sessionFactory.openSession();
                adminDAOSession = sessionFactory.openSession();
                stats = sessionFactory.getStatistics();
                stats.setStatisticsEnabled(true);

            }
            
            System.out.println("stats.getSessionOpenCount() : " + stats.getSessionOpenCount());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return mConn;
    }

    public static AdminDAO getAdminDAO() {
        Connection conn = getDbConnection();
//        if (adminDAO == null) {
//            adminDAO = new AdminDAO(sessionFactory, categoryDAOSession);
//        }
        return adminDAO;
    }

    public static CustomerDAO getCustomerDAO() {
        Connection conn = getDbConnection();
        if (customerDAO == null) {
            customerDAO = new CustomerDAO(sessionFactory, categoryDAOSession);
        }
        return customerDAO;
    }

    public static CategoryDAO getCategoryDAO() {
        Connection conn = getDbConnection();
        if (categoryDAO == null) {
            categoryDAO = new CategoryDAO(sessionFactory, categoryDAOSession);
        }
        return categoryDAO;
    }

    public static ProductDAO getProductDAO() {
        Connection conn = getDbConnection();

        if (productDAO == null) {
            productDAO = new ProductDAO(sessionFactory, productDAOSession);
        }
        return productDAO;
    }

    public static OrderDAO getOrderDAO() {
        Connection conn = getDbConnection();
        if (orderDAO == null) {
            orderDAO = new OrderDAO(sessionFactory, orderDAOSession);
        }
        return orderDAO;
    }

    public static void evictObject(Object o) {
        if (orderDAOSession != null) {
            orderDAOSession.evict(o);
        }
        if (productDAOSession != null) {
            productDAOSession.evict(o);
        }
        if (categoryDAOSession != null) {
            categoryDAOSession.evict(o);
        }
        if (customerDAOSession != null) {
            customerDAOSession.evict(o);
        }
        if (adminDAOSession != null) {
            adminDAOSession.evict(o);
        }
    }
    public static void clearSessions() {
        if (orderDAOSession != null) {
            orderDAOSession.clear();
        }
        if (productDAOSession != null) {
            productDAOSession.clear();
        }
        if (categoryDAOSession != null) {
            categoryDAOSession.clear();
        }
        if (customerDAOSession != null) {
            customerDAOSession.clear();
        }
        if (adminDAOSession != null) {
            adminDAOSession.clear();
        }
    }

}
