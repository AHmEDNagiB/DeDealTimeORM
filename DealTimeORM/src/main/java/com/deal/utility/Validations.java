package com.deal.utility;

import java.util.regex.Pattern;

public class Validations {

    private static final Pattern emailPattern
            = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    private static final Pattern usernamePattern = Pattern.compile("^[a-z][a-z0-9_-]{3,15}$");
    private static final Pattern namePattern = Pattern.compile("^[a-zA-Z\\s]+$");
    private static final Pattern phonePattern = Pattern.compile("01\\d{9}");



    /*
                User Data Validation
            
     */
    public static boolean emailIsValid(String email) {
        return emailPattern.matcher(email).matches();
    }

    public static boolean userNameIsValid(String userName) {
        return usernamePattern.matcher(userName).matches();
    }

    public static boolean passIsValid(String password) {

        if (password.length() < 8) {
            return false;
        }
        return true;
    }

    public static boolean nameIsValid(String name) {
        return namePattern.matcher(name).matches();
    }

    public static boolean phoneIsValid(String phone) {
        return phonePattern.matcher(phone).matches();
    }

    /*
                Category Data Validation
            
     */
    public static boolean categNameIsValid(String name) {
        //(Amazon) Example : Computers, Tablets, & Accessories 
        if (name.length() < 30) {
            return false;
        }
        return true;
    }

    /*
                Product Data Validation
            
     */
    public static boolean productNameIsValid(String name) {
        //(Amazon) Example :Samsung Galaxy S9+ - 6.2" - 64GB Mobile Phone - Titanium Gray + Level U Pro 
        if (name.length() < 70) {
            return false;
        }
        return true;
    }

    public static boolean productQuantityIsValid(double quantity) {
        if (quantity < 0) {
            return false;
        }
        return true;
    }
    public static boolean productPriceIsValid(double price) {
        if (price < 0) {
            return false;
        }
        return true;
    }

}
