package com.deal.base.control;

import com.deal.base.pojo.Category;
import com.deal.control.DbHandler;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CategoryDAO {

    SessionFactory sessionFactory = null;
    Session session = null;
    public static final String SUCCESSFUL_INSERT = "new category has been created successfully";
    public static final String SUCCESSFUL_UPDATE = "category has been updated successfully";
    public static final String SUCCESSFUL_DELETE = "category has been deleted successfully";
    public static final String EXISTING_CATEGORY = "This category already exists";
    public static final String DELETING_CATEGORY_ERROR = "error while deleting category";
    public static final String EXCEPTION = "exception happened";

    public CategoryDAO(SessionFactory sessionFactory, Session session) {
        this.session = session;
        this.sessionFactory = sessionFactory;

    }

    public Category retrieveCategory(long categoryId) {
        Category category = null;
        try {
            Query q = session.createQuery("from Category cat where cat.categoryId = ?").setBigDecimal(0, new BigDecimal(categoryId));
            category = (Category) q.list().get(0);

        } catch (Exception ex) {
            System.out.println("category not found");
        }

        return category;
    }

    public List<Category> retrieveAllCategories() {
        List<Category> categories = new ArrayList();
        try {
            Query q = session.createQuery("from Category cat where cat.categoryId > ?").setBigDecimal(0, new BigDecimal(0));
            categories = q.list();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return categories;
    }

    private boolean checkCategoryExistance(String categoryName) {
        boolean result = true;
        try {
            Query q = session.createQuery("from Category cat where cat.categoryName = ?").setString(0, categoryName);
            List categories = q.list();
            if (categories.size() > 0) {
                result = true;
            }
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public String insertCategory(Category category) {
        String result;
        boolean isCategoryExisting = checkCategoryExistance(category.getCategoryName());
        try {
            if (isCategoryExisting) {
                result = EXISTING_CATEGORY;
            } else {
                session.beginTransaction();
                session.persist(category);
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
//    public String updateCategory(Category category) {
//        String result;
//        boolean isCategoryExisting = checkCategoryExistance(category.getCategoryName());
//        try {
//            if (isCategoryExisting) {
//                result = EXISTING_CATEGORY;
//            } else {
//                Query qry = session.createQuery("update Category cat set cat.categoryName = ?   where cat.categoryId = ?")
//                        .setEntity(0, category.getCategoryName())
//                        .setEntity(1, category.getCategoryId());
//                int res = qry.executeUpdate();
//                System.out.println("cat updated : " + res);
//                result = SUCCESSFUL_UPDATE;
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            result = EXCEPTION;
//        }
//        return result;
//    }
//

    public String updateCategory(Category category) {
        String result;
        boolean isCategoryExisting = checkCategoryExistance(category.getCategoryName());
        try {
            if (isCategoryExisting) {
                result = EXISTING_CATEGORY;
            } else {
                System.out.println(" ^^^^^^^^^ the updateOrder() Working .... : ^^^^^^^^^ ");
                session.beginTransaction();
                session.saveOrUpdate(category);
                session.getTransaction().commit();
                result = SUCCESSFUL_UPDATE;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        }
        
        return result;
    }

    private boolean deleteCategoryProducts(Category category) {
        boolean result = false;
        try {
            ProductDAO productDAoObject = DbHandler.getProductDAO();
            productDAoObject.deleteProductOfCat(category.getCategoryId());
            result = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return result;
    }

    public String deleteCategory(Category category) {
        String result;
        boolean isCategoryProductsDeleted = deleteCategoryProducts(category);
//        try {
//            if (isCategoryProductsDeleted) {
//                PreparedStatement stmt = mConn.prepareStatement("DELETE DEALTIME.CATEGORIES WHERE CATEGORY_ID = "
//                        + category.getCategoryId());
//                stmt.execute();
//                result = SUCCESSFUL_DELETE;
//            } else {
//                result = DELETING_CATEGORY_ERROR;
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
        return "No Category deletion";
    }
}
