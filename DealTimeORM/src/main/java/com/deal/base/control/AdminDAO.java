package com.deal.base.control;

/* Marzouk */
import com.deal.base.pojo.Admins;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AdminDAO {

    private Session mSession;

    // private Connection mConn;
    public static final String SUCCESSFUL_INSERT = "new admin has been registered successfully";
    public static final String SUCCESSFUL_UPDATE = "admin info has been updated successfully";
    public static final String SUCCESSFUL_DELETE = "admin has been deleted successfully";
    public static final String EXISTING_EMAIL = "This email already exists";
    public static final String EXCEPTION = "exception happened";

    public AdminDAO(SessionFactory sessionFactory) {
        // mConn = c;
        mSession = sessionFactory.openSession();
    }

    public Admins retrieveAdmin(String email, String password) {
        Admins admin = null;
        try {
            Query q = mSession.createQuery("SELECT A FROM Admins AS A where "
                    + "A.email = ? and A.password = ?")
                    .setString(0, email)
                    .setString(1, password);
            admin = (Admins) q.list().get(0);
        } catch (Exception ex) {
            System.out.println("Admin not found");
        } finally {
            //close session
            if (mSession.isOpen()) {
                mSession.close();
            }
        }
        return admin;
    }

    private boolean checkEmailExistance(String email) {
        boolean result = false;
        List<Admins> admins = new ArrayList();
        try {
            Query q = mSession.createQuery("SELECT A FROM Admins AS A where "
                    + " upper(A.email) = ? ")
                    .setString(0, email.toUpperCase());
            admins = q.list();
            if (admins.size() > 0) {
                result = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = false;
        } finally {
            //close session
            if (mSession.isOpen()) {
                mSession.close();
            }
        }
        return result;
    }

    public String insertAdmin(Admins admin) {
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
        } finally {
            //close session
            if (mSession.isOpen()) {
                mSession.close();
            }
        }
        return result;
    }

    private boolean checkEmailRepetition(Admins admin) {
        boolean result = false;
        List<Admins> admins = new ArrayList();
        try {
            Query q = mSession.createQuery("SELECT A FROM Admins AS A where "
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
        } finally {
            //close session
            if (mSession.isOpen()) {
                mSession.close();
            }
        }
        return result;
    }

    public String updateAdmin(Admins admin) {
        String result;
        boolean isAdminExisting = checkEmailRepetition(admin);
        try {
            if (isAdminExisting) {
                result = EXISTING_EMAIL;
            } else {
                mSession.beginTransaction();
                mSession.saveOrUpdate(admin);
                mSession.getTransaction().commit();
                result = SUCCESSFUL_UPDATE;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        } finally {
            //close session
            if (mSession.isOpen()) {
                mSession.close();
            }
        }
        return result;
    }

    public String deleteAdmin(Admins admin) {
        String result;
        try {
            mSession.delete(admin);
            result = SUCCESSFUL_DELETE;
        } catch (Exception ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        } finally {
            //close session
            if (mSession.isOpen()) {
                mSession.close();
            }
        }
        return result;
    }

}
