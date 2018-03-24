package com.deal.base.control;

/* Marzouk */
import com.deal.base.pojo.Customer;
import com.deal.base.pojo.Order;
import com.deal.control.DbHandler;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDAO {

    SessionFactory sessionFactory = null;
    Session session = null;
    public static final String SUCCESSFUL_INSERT = "order has been created successfully";
    public static final String SUCCESSFUL_UPDATE = "order has been updated successfully";
    public static final String SUCCESSFUL_DELETE = "order has been deleted successfully";
    public static final String EXCEPTION = "exception happened";

    public OrderDAO(SessionFactory sessionFactory, Session session) {
        this.session = session;
        this.sessionFactory = sessionFactory;

    }

    public Order retrieveOrder(long orderId) {
        Order order = null;
        try {
            Query q = session.createQuery("from Order o where orderId = ?").setBigDecimal(0, new BigDecimal(orderId));
            order = (Order) q.list().get(0);
        } catch (Exception ex) {
            System.out.println("order not found");
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

        return result;
    }

    public String updateOrder(Order order) {
        String result;
        try {
            System.out.println(" ^^^^^^^^^ the updateOrder() Working .... : ^^^^^^^^^ ");
//            Session tempSession = sessionFactory.openSession();
            DbHandler.evictObject(order);
            session.beginTransaction();
            session.saveOrUpdate(order);
            session.getTransaction().commit();

            result = SUCCESSFUL_UPDATE;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
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

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return customerOrders;
    }

    public String updateCustomerOrders(BigDecimal id) {
        String result;
        try {
            List<Order> customerOrders = new ArrayList();
            Query q = session.createQuery("from Order o where o.customer.custId = ? and o.quantity > 0 and o.status ='c'").setBigDecimal(0, id);
            customerOrders = q.list();
            customerOrders.forEach((t) -> {
                t.setStatus("d");
                updateOrder(t);
            });

            result = SUCCESSFUL_UPDATE;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        }

        return result;
    }

}
