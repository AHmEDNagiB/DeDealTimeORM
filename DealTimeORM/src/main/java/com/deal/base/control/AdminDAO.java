package com.deal.base.control;

/* Marzouk */
import com.deal.base.model.Admin;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminDAO {

    private Connection mConn;
    public static final String SUCCESSFUL_INSERT = "new admin has been registered successfully";
    public static final String SUCCESSFUL_UPDATE = "admin info has been updated successfully";
    public static final String SUCCESSFUL_DELETE = "admin has been deleted successfully";
    public static final String EXISTING_EMAIL = "This email already exists";
    public static final String EXCEPTION = "exception happened";

    public AdminDAO(Connection c) {
        mConn = c;
    }

    public Admin retrieveAdmin(String email, String password) {
        Admin admin = null;
        try {
            ResultSet results = mConn.createStatement().executeQuery("SELECT ADMIN_ID, FIRST_NAME, LAST_NAME,\n"
                    + "ADDRESS, JOB, PHONE_NUMBER, DATE_OF_BIRTH\n"
                    + "FROM DEALTIME.ADMINS\n"
                    + "WHERE UPPER(EMAIL) = UPPER('" + email + "')\n"
                    + "AND PASSWORD = '" + password + "'");
            while (results.next()) {
                admin = new Admin();
                admin.setAdminEmail(email);
                admin.setAdminPassword(password);
                admin.setAdminId(results.getLong("ADMIN_ID"));
                admin.setAdminFirstName(results.getString("FIRST_NAME"));
                admin.setAdminLastName(results.getString("LAST_NAME"));
                admin.setAdminAddress(results.getString("ADDRESS"));
                admin.setAdminJob(results.getString("JOB"));
                admin.setAdminPhoneNo(results.getString("PHONE_NUMBER"));
                if (results.getDate("DATE_OF_BIRTH") == null) {
                    admin.setAdminDateOfBirth(null);
                } else {
                    admin.setAdminDateOfBirth(results.getDate("DATE_OF_BIRTH").toLocalDate());
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                mConn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return admin;
    }

    private boolean checkEmailExistance(String email) {
        boolean result = false;
        try {
            ResultSet rSet = mConn.createStatement().executeQuery("SELECT COUNT(*) FROM DEALTIME.ADMINS\n"
                    + "WHERE UPPER(EMAIL) = UPPER('" + email + "')");
            while (rSet.next()) {
                if (rSet.getInt(1) > 0) {
                    result = true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = false;
        }
        return result;
    }

    public String insertAdmin(Admin admin) {
        String result;
        boolean isAdminExisting = checkEmailExistance(admin.getAdminEmail());
        try {
            if (isAdminExisting) {
                result = EXISTING_EMAIL;
            } else {
                PreparedStatement stmt = mConn.prepareStatement("INSERT INTO DEALTIME.ADMINS (ADMIN_ID, EMAIL, PASSWORD,\n"
                        + "FIRST_NAME, LAST_NAME, ADDRESS, JOB, PHONE_NUMBER, DATE_OF_BIRTH)\n"
                        + "VALUES ( ADMINS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)");
                stmt.setString(1, admin.getAdminEmail());
                stmt.setString(2, admin.getAdminPassword());
                stmt.setString(3, admin.getAdminFirstName());
                stmt.setString(4, admin.getAdminLastName());
                stmt.setString(5, admin.getAdminAddress());
                stmt.setString(6, admin.getAdminJob());
                stmt.setString(7, admin.getAdminPhoneNo());
                if (admin.getAdminDateOfBirth() != null) {
                    stmt.setDate(8, Date.valueOf(admin.getAdminDateOfBirth()));
                } else {
                    stmt.setNull(8, java.sql.Types.DATE);
                }
                stmt.execute();
                result = SUCCESSFUL_INSERT;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        } finally {
            try {
                mConn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    private boolean checkEmailRepetition(Admin admin) {
        boolean result = false;
        try {
            ResultSet rSet = mConn.createStatement().executeQuery("SELECT COUNT(*) FROM DEALTIME.ADMINS\n"
                    + "WHERE UPPER(EMAIL) = UPPER('" + admin.getAdminEmail()+ "')\n"
                    + "AND ADMIN_ID != " + admin.getAdminId());
            if (rSet.next()) {
                if (rSet.getInt(1) > 0) {
                    result = true;
                }
            }
        } catch (SQLException ex) {
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
                PreparedStatement stmt = mConn.prepareStatement("UPDATE DEALTIME.ADMINS\n"
                        + "SET EMAIL = ?, PASSWORD = ?, FIRST_NAME = ?,  LAST_NAME = ?, ADDRESS = ?,  JOB = ?,\n"
                        + "PHONE_NUMBER = ?, DATE_OF_BIRTH = ?\n"
                        + "WHERE ADMIN_ID = " + admin.getAdminId());
                stmt.setString(1, admin.getAdminEmail());
                stmt.setString(2, admin.getAdminPassword());
                stmt.setString(3, admin.getAdminFirstName());
                stmt.setString(4, admin.getAdminLastName());
                stmt.setString(5, admin.getAdminAddress());
                stmt.setString(6, admin.getAdminJob());
                stmt.setString(7, admin.getAdminPhoneNo());
                if (admin.getAdminDateOfBirth() != null) {
                    stmt.setDate(8, Date.valueOf(admin.getAdminDateOfBirth()));
                } else {
                    stmt.setNull(8, java.sql.Types.DATE);
                }
                stmt.execute();
                result = SUCCESSFUL_UPDATE;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        } finally {
            try {
                mConn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public String deleteAdmin(Admin admin) {
        String result;
        try {
            PreparedStatement stmt = mConn.prepareStatement("DELETE DEALTIME.ADMINS WHERE ADMIN_ID = " + admin.getAdminId());
            stmt.execute();
            result = SUCCESSFUL_DELETE;
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = EXCEPTION;
        } finally {
            try {
                mConn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
 
}
