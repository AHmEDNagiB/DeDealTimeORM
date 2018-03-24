package com.deal.base.control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

public class DbConn {
    // JDBC Driver Name & Database URL
    private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
    private final String JDBC_DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    
    // JDBC Database Credentials
    private final String JDBC_USER = "dealtime";
    private final String JDBC_PASS = "dealtime";
    
    private GenericObjectPool pool;
    private DataSource dataSource;
    private static volatile DbConn dbConn = null;

    private DbConn() {
        try {
            dataSource = setUpPool();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static DbConn getDbConn() {
        if (dbConn == null) {
            dbConn = new DbConn();
        }
        
        dbConn.printDbStatus();
        
        return dbConn;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
    
    private DataSource setUpPool() throws Exception {
        Class.forName(JDBC_DRIVER);

        // Creates an Instance of GenericObjectPool That Holds Our Pool of Connections Object!
        pool = new GenericObjectPool();
        pool.setMaxActive(50);
        
        // Creates a ConnectionFactory Object Which Will Be Use by the Pool to Create the Connection Object!
        ConnectionFactory factory = new DriverManagerConnectionFactory(JDBC_DB_URL, JDBC_USER, JDBC_PASS);
        
        // Creates a PoolableConnectionFactory That Will Wraps the Connection Object Created by the ConnectionFactory to Add Object Pooling Functionality!
        PoolableConnectionFactory poolConnFactory = new PoolableConnectionFactory(factory, pool, null, null, false, true);
        DataSource poolSource = new PoolingDataSource(pool);
        
        return poolSource;
    }
    
    // This Method Is Used To Print The Connection Pool Status
    public void printDbStatus() {
        System.out.println("Max: " + pool.getMaxActive() + "; Active: " + pool.getNumActive() + "; Idle: " + pool.getNumIdle());
    }
    
}
