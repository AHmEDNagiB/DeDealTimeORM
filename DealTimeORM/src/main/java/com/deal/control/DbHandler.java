package com.deal.control;

import com.deal.base.control.AdminDAO;
import com.deal.base.control.CategoryDAO;
import com.deal.base.control.CustomerDAO;
import com.deal.base.control.DbConn;
import com.deal.base.control.OrderDAO;
import com.deal.base.control.ProductDAO;
import java.sql.Connection;
import java.sql.SQLException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbHandler {

    static SessionFactory sessionFactory = null;

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
            } else {
                System.out.println("**************  hibernate.cfg.xml Already loaded**************");
            }
            mConn = DbConn.getDbConn().getDataSource().getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mConn;
    }

    public static AdminDAO getAdminDAO() {
        Connection conn = getDbConnection();
        return new AdminDAO(conn);
    }

    public static CustomerDAO getCustomerDAO() {
        Connection conn = getDbConnection();
        return new CustomerDAO(sessionFactory);
    }

    public static CategoryDAO getCategoryDAO() {
        Connection conn = getDbConnection();
        return new CategoryDAO(sessionFactory);
    }

    public static ProductDAO getProductDAO() {
        Connection conn = getDbConnection();

        return new ProductDAO(sessionFactory);
    }

    public static OrderDAO getOrderDAO() {
        Connection conn = getDbConnection();

        return new OrderDAO(sessionFactory);
    }

}
