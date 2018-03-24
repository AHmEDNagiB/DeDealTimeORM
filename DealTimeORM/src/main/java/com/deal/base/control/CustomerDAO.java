package com.deal.base.control;

import com.deal.base.pojo.Customer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CustomerDAO {

    SessionFactory sessionFactory = null;
    Session session = null;
    public static final String SUCCESSFUL_INSERT = "registeration has been done successfully";
    public static final String SUCCESSFUL_UPDATE = "user info has been updated successfully";
    public static final String SUCCESSFUL_DELETE = "user has been deleted successfully";
    public static final String EXISTING_EMAIL = "This email already exists";
    public static final String DELETING_CUSTOMER_ERROR = "error while deleting customer";
    public static final String EXCEPTION = "exception happened";

    public CustomerDAO(SessionFactory sessionFactory, Session session) {
        this.session = session;
        this.sessionFactory = sessionFactory;

    }

    public Customer retrieveCustomer(long custId) {
        Customer customer = null;
        try {
            Query q = session.createQuery("SELECT C FROM Customer AS C where C.custId = ?").setBigDecimal(0, new BigDecimal(custId));
            customer = (Customer) q.list().get(0);
        } catch (Exception ex) {
            System.out.println("Customer not found");
        }
      
        return customer;
    }

    public Customer retrieveCustomer(String email, String password) {
        Customer customer = null;
        try {
            Query q = session.createQuery("SELECT C FROM Customer AS C where "
                    + "C.email = ? and C.password = ?")
                    .setString(0, email)
                    .setString(1, password);
            customer = (Customer) q.list().get(0);
        } catch (Exception ex) {
            System.out.println("Customer not found");
        }
       
        return customer;
    }

    public List<Customer> retrieveAllCustomers() {
        List<Customer> customers = new ArrayList();
        try {
            Query q = session.createQuery("SELECT C FROM Customer AS C where C.custId > 0 ");
            customers = q.list();
        } catch (Exception ex) {
            System.out.println("Customer not found");
        }
       
        return customers;
    }

    private boolean checkEmailExistance(String email) {
        boolean result = false;
        List<Customer> customers = new ArrayList();
        try {
            Query q = session.createQuery("SELECT C FROM Customer AS C where "
                    + " upper(C.email) = ? ")
                    .setString(0, email.toUpperCase());
            customers = q.list();
            if (customers.size() > 0) {
                result = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        }
    
        return result;
    }

    public String insertCustomer(Customer cust) {
        String result;
        boolean isCustomerExisting = checkEmailExistance(cust.getEmail());
        try {
            if (isCustomerExisting) {
                result = EXISTING_EMAIL;
            } else {
                session.beginTransaction();
                session.persist(cust);
                session.getTransaction().commit();
                result = SUCCESSFUL_INSERT;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        }
       
        return result;
    }
// ****************** old method not working ******************

//    public String updateCustomer(Customer cust) {
//        String result;
//
//        try {
//            Query qry = session.createQuery("UPDATE Customer AS C SET "
//                    + "C.creditLimit = :creditLimit, "
//                    + "C.address = :address ,"
//                    + "C.phoneNumber=:phoneNumber , "
//                    + "C.firstName:firstName, "
//                    + "C.lastName:lastName where  C.custId = : custId")
//                    .setBigDecimal("creditLimit", cust.getCreditLimit())
//                    .setString("address", cust.getAddress())
//                    .setString("phoneNumber", cust.getPhoneNumber())
//                    .setString("firstName", cust.getFirstName())
//                    .setString("lastName", cust.getLastName())
//                    .setBigDecimal("custId", cust.getCustId());
//            int res = qry.executeUpdate();
//            System.out.println("the Customer Order : " + res);
//            result = SUCCESSFUL_UPDATE;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            result = EXCEPTION;
//        }
//        return result;
//    }
    public String updateCustomer(Customer cust) {
        String result;

        try {
            System.out.println(" ^^^^^^^^^ the updateCustomer() Working .... : ^^^^^^^^^ ");
            session.beginTransaction();
            session.saveOrUpdate(cust);
            session.getTransaction().commit();
            result = SUCCESSFUL_UPDATE;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        }
      
        return result;
    }

    public String deleteCustomer(Customer customer) {
//        String result  ;
//        boolean isCustomerOrdersDeleted = deleteCustomerOrders(customer);
//        try {
//            if (isCustomerOrdersDeleted) {
//                PreparedStatement stmt = mConn.prepareStatement("DELETE DEALTIME.CUSTOMERS WHERE CUSTOMER_ID = " + customer.getCustId());
//                stmt.execute();
//                result = SUCCESSFUL_DELETE;
//            } else {
//                result = DELETING_CUSTOMER_ERROR;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            result = EXCEPTION;
//        } finally {
//            try {
//                mConn.close();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
        return EXCEPTION;
    }

}
