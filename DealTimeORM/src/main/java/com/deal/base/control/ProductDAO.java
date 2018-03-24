package com.deal.base.control;

/* Marzouk */
import com.deal.base.pojo.Category;
import com.deal.base.pojo.Product;
import com.deal.control.DbHandler;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductDAO {

    SessionFactory sessionFactory = null;
    Session session = null;
    public static final String SUCCESSFUL_INSERT = "product has been added successfully";
    public static final String SUCCESSFUL_UPDATE = "product info has been updated successfully";
    public static final String SUCCESSFUL_DELETE = "product has been deleted successfully";
    public static final String DELETING_PRODUCT_ERROR = "error while deleting product";
    public static final String EXCEPTION = "exception happened";

    public ProductDAO(SessionFactory sessionFactory, Session session) {
        this.session = session;
        this.sessionFactory = sessionFactory;

    }

    public Product retrieveProduct(long productId) {
        session.clear();
        Product product = null;
        try {
            Query q = session.createQuery("from Product p where productId = ?").setInteger(0, (int) productId);
            product = (Product) q.list().get(0);
        } catch (Exception ex) {
            System.out.println("product not found");
        }
        return product;
    }

    public List<Product> retrieveAllProducts() {
        session.clear();
        List<Product> products = new ArrayList<>();
        try {
            System.out.println("retrieveAllProducts() working ...");
            Query q = session.createQuery("from Product p ");
            products = q.list();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return products;
    }

    public List<Product> retrieveCategoryProducts(Category cat) {
        session.clear();
        List<Product> products = new ArrayList<>();
        try {
            Query q = session.createQuery("from Product p where categoryId = ?").setEntity(0, cat);
            products = q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return products;
    }

    public List<Product> retrieveCategoryProducts(Long cat) {
        session.clear();
        List<Product> products = new ArrayList<>();
        try {
            Query q = session.createQuery("from Product p where categoryId.categoryId = ?").setEntity(0, new BigDecimal(cat));
            products = q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return products;
    }

    public String insertProduct(Product product) {
        String result = "";
        try {
            session.beginTransaction();
            session.persist(product);
            session.getTransaction().commit();
            result = String.valueOf(product.getProductId());
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        }

        return result;
    }

    public String updateProduct(Product product) {
        String result;
        try {
            System.out.println(" ^^^^^^^^^ the updateProduct() Working .... : ^^^^^^^^^ ");
            DbHandler.clearSessions();
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            result = SUCCESSFUL_UPDATE;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
            session.getTransaction().rollback();
        }

        return result;
    }

    // find solution for deleting products have orders before deleting them //
    public String deleteProduct(long productId) {
        String result;
        try {
            Query qry = session.createQuery("update Product p set p.availableQuantity =?  where p.productId = ?")
                    .setEntity(0, 0)
                    .setEntity(1, productId);
            int res = qry.executeUpdate();
            System.out.println("the updated Product : " + res);
            result = SUCCESSFUL_DELETE;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        }

        return result;
    }

    public boolean deleteProductOfCat(BigDecimal catId) {
        boolean result = false;
        try {
            Query qry = session.createQuery("update Product p set p.availableQuantity =?  where p.productCategory.categoryId = ?")
                    .setEntity(0, 0)
                    .setEntity(1, catId);
            int res = qry.executeUpdate();
            System.out.println("the deleted Products : " + res);
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        }

        return result;
    }

}
