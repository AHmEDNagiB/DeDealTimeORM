package com.deal.base.control;

/* Marzouk */
import com.deal.base.pojo.Customer;
import com.deal.base.pojo.Order;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDAO {

    Session session;
    public static final String SUCCESSFUL_INSERT = "order has been created successfully";
    public static final String SUCCESSFUL_UPDATE = "order has been updated successfully";
    public static final String SUCCESSFUL_DELETE = "order has been deleted successfully";
    public static final String EXCEPTION = "exception happened";

    public OrderDAO(SessionFactory sessionFactory) {

        session = sessionFactory.openSession();
    }

    public Order retrieveOrder(long orderId) {
        Order order = null;
        try {
            Query q = session.createQuery("from Order o where orderId = ?").setBigDecimal(0, new BigDecimal(orderId));
            order = (Order) q.list().get(0);
        } catch (Exception ex) {
            System.out.println("order not found");
        }
        //close session
        if (session.isOpen()) {
            session.close();
        }
        return order;
    }

    public List<Order> retrieveCustomerOrders(Customer customer) {
        List<Order> customerOrders = new ArrayList();
        try {
            System.out.println("retrieveCustomerOrders() working ...");
            Query q = session.createQuery("from Order o where customer = ? and o.quantity > 0 and o.status ='c'").setEntity(0, customer);
            customerOrders = q.list();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
         //close session
        if (session.isOpen()) {
            session.close();
        }
        return customerOrders;
    }

    public List<Order> retrieveCustomerHistory(Customer customer) {
        List<Order> customerOrders = new ArrayList();
        try {
            System.out.println("retrieveCustomerHistory() working ...");
            Query q = session.createQuery("from Order o where o.customer = ? and o.quantity > 0 and o.status ='d'").setEntity(0, customer);
            customerOrders = q.list();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
         //close session
        if (session.isOpen()) {
            session.close();
        }
        return customerOrders;
    }

    public String insertOrder(Order order) {
        String result;
        try {
            session.beginTransaction();
            session.persist(order);
            session.getTransaction().commit();
            result = SUCCESSFUL_INSERT;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;

        }
         //close session
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }

    public String updateOrder(Order order) {
        String result;
        try {
            System.out.println(" ^^^^^^^^^ the updateOrder() Working .... : ^^^^^^^^^ ");
            session.beginTransaction();
            session.saveOrUpdate(order);
            session.getTransaction().commit();

            result = SUCCESSFUL_UPDATE;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        }
         //close session
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }

    public String deleteOrder(Order order) {
        String result;
        try {
            Query query = session.createQuery("delete Order o where o.orderId = :orderId");
            query.setBigDecimal("orderId", order.getOrderId());
            int res = query.executeUpdate();
            result = SUCCESSFUL_DELETE;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        }
         //close session
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }

    public String deleteCustomerOrders(Customer customer) {
        String result;
        try {
            Query query = session.createQuery("delete Order o where o.customer.customerId = :customerId");
            query.setBigDecimal("customerId", customer.getCustId());
            int res = query.executeUpdate();
            result = SUCCESSFUL_DELETE;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        }
         //close session
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }

    public String updateOrder(int orderID, int qnt) {
        String result;
        System.out.println("orderID : " + orderID);
        System.out.println("qnt : " + qnt);
        try {
            Query qry = session.createQuery("update Order o set o.quantity = :quantity   where o.orderId = :orderId")
                    .setBigDecimal("quantity", new BigDecimal(qnt))
                    .setBigDecimal("orderId", new BigDecimal(orderID));
            int res = qry.executeUpdate();
            System.out.println(" ^^^^^^^^^ the updated Order : ^^^^^^^^^ " + res);
            result = SUCCESSFUL_UPDATE;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        }
         //close session
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }

    public List<Order> getOrderByProduct(Customer customer, int productId) {
        List<Order> customerOrders = new ArrayList();
        try {
            Query q = session.createQuery("SELECT O  FROM Order AS O WHERE "
                    + "O.customer.custId = :custId AND "
                    + "O.orderProduct.productId = :productId AND "
                    + "O.quantity > 0 AND O.status = 'c' ")
                    .setBigDecimal("custId", customer.getCustId())
                    .setBigDecimal("productId", new BigDecimal(productId));
            customerOrders = q.list();
            System.out.println("custId");
            System.out.println("custId");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
         //close session
        if (session.isOpen()) {
            session.close();
        }
        return customerOrders;
    }

    public String updateCustomerOrders(BigDecimal id) {
        String result;
        try {
            Query qry = session.createQuery("update Order o set o.status  'd'  where o.orderId = ?")
                    .setEntity(0, id);
            int res = qry.executeUpdate();
            System.out.println("the updated Order : " + res);
            result = SUCCESSFUL_UPDATE;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        }
         //close session
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }

}
