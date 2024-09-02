/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tms.persistence.utility;

import tms.persistence.dao.DAO;
import tms.persistence.dao.impl.UserDAOImpl;
import tms.persistence.entity.UserEO;

/**
 *
 * @author bhagya.shree
 */
public class Validator {

    public Validator() {
        
    }
    
    public static boolean validatePassword(String password){
        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}";
        return password.length()>=8 && password.length()<16 && password.matches(regex);
    }
    
    public static boolean validateEmail(String email) {
        String regex = "^[a-zA-Z0-9._]+@[a-z]+\\.[a-z]{2,}$";
        return email.matches(regex);
    }
    
    public static boolean validateMobile(String mobileNo) {
        String regex = "^\\+\\d{1,3} \\d{10}$";
        return mobileNo.matches(regex);
    }
    
    public static boolean validateRegNo(String regNo) {
        String regex = "^[A-Z]{2} [0-9]{2} [A-Z]{2} [0-9]{4}$";
        return regNo.matches(regex);
    }
}
