package com.deal.base.control;

import com.deal.base.pojo.Admin;
import com.deal.control.DbHandler;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AdminDAO {

    SessionFactory sessionFactory = null;
    Session mSession = null;
    public static final String SUCCESSFUL_INSERT = "new admin has been registered successfully";
    public static final String SUCCESSFUL_UPDATE = "admin info has been updated successfully";
    public static final String SUCCESSFUL_DELETE = "admin has been deleted successfully";
    public static final String EXISTING_EMAIL = "This email already exists";
    public static final String EXCEPTION = "exception happened";

    public AdminDAO(SessionFactory sessionFactory, Session session) {
        this.mSession = session;
        this.sessionFactory = sessionFactory;

    }

    public Admin retrieveAdmin(String email, String password) {
        Admin admin = null;
        try {
            Query q = mSession.createQuery("SELECT A FROM Admin AS A where "
                    + "A.email = ? and A.password = ?")
                    .setString(0, email)
                    .setString(1, password);
            admin = (Admin) q.list().get(0);
        } catch (Exception ex) {
            System.out.println("Admin not found");
        }
        return admin;
    }

    private boolean checkEmailExistance(String email) {
        boolean result = false;
        List<Admin> admins = new ArrayList();
        try {
            Query q = mSession.createQuery("SELECT A FROM Admin AS A where "
                    + " upper(A.email) = ? ")
                    .setString(0, email.toUpperCase());
            admins = q.list();
            if (admins.size() > 0) {
                result = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }

    public String insertAdmin(Admin admin) {
        String result;
        boolean isAdminExisting = checkEmailExistance(admin.getEmail());
        try {
            if (isAdminExisting) {
                result = EXISTING_EMAIL;
            } else {
                mSession.beginTransaction();
                mSession.persist(admin);
                mSession.getTransaction().commit();
                result = SUCCESSFUL_INSERT;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        }
        return result;
    }

    private boolean checkEmailRepetition(Admin admin) {
        boolean result = false;
        List<Admin> admins = new ArrayList();
        try {
            Query q = mSession.createQuery("SELECT A FROM Admin AS A where "
                    + " upper(A.email) = ? "
                    + " and A.adminId = ? ")
                    .setString(0, admin.getEmail().toUpperCase())
                    .setBigDecimal(1, admin.getAdminId());
            admins = q.list();
            if (admins.size() > 0) {
                result = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }

    public String updateAdmin(Admin admin) {
        String result;
        boolean isAdminExisting = checkEmailRepetition(admin);
        try {
            if (isAdminExisting) {
                result = EXISTING_EMAIL;
            } else {
                DbHandler.evictObject(admin);
                mSession.beginTransaction();
                mSession.saveOrUpdate(admin);
                mSession.getTransaction().commit();
                result = SUCCESSFUL_UPDATE;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        }
        return result;
    }

    public String deleteAdmin(Admin admin) {
        String result;
        try {
            mSession.delete(admin);
            result = SUCCESSFUL_DELETE;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        }
        return result;
    }

}
