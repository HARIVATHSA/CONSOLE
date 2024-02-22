package Controller;

import java.util.ArrayList;

import View.New_user;

public class User_validation {

    public static boolean validate_user(String name, String email, String contact, String pass, String confirmpass){
        String vemail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        if(!name.matches("^[a-zA-Z]+$")){
            System.out.println("Invalid Name");
            New_user.view();
        }
        else if(!email.matches(vemail)){
            System.out.println("Invalid email");
            New_user.view();
        }
        else if(!contact.matches("^[0-9]{10}")){
            System.out.println("Invalid Contact");
            New_user.view();
        }
        else if(!pass.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()-_+=])[A-Za-z0-9!@#$%^&*()-_+=]{8,}$")){
            System.out.println("Invalid Password");
            New_user.view();
        }
        else{
            return true;
        }
        return false;
        
    }
    public static String checkemail(String email){
        String vemail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if(!email.matches(vemail)){
            return "Invalid email";
            
        }
        return "1";

    }
    public static String checkname(String name){
        if(!name.matches("^[a-zA-Z]+$")){
            return "Invalid Name";
            
        }
        return "1";

    }
    public static String checkcontac(String name){
        if(!name.matches("^[a-zA-Z]+$")){
            return "Invalid Name";
        
        }
        return "1";

    }
    public static String checkpass(String name){
        if(!name.matches("^[a-zA-Z]+$")){
            return "Invalid Name";
            
        }
        return "1";

    }
    
}
