package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Modal.Connect;
import View.New_user;

public class CheckUser extends Connect {

    public static boolean CheckUserID(String user_id){
        try{
            PreparedStatement p = conn.prepareStatement("SELECT * FROM USER_TABLE WHERE USER_ID = ?");
            p.setString(1, user_id);
            ResultSet rs = p.executeQuery();
            if(rs.next()) {
                System.out.println("User Already Exist");
                New_user.view();
            }   
            else{
                return true;
            }
        }
        catch(Exception err){
            System.out.println(err);
        }
        return false;
    }
    public static int CheckUser(String user_id, String pass, String confirmpass){
        try{
            PreparedStatement p = conn.prepareStatement("SELECT ROLE FROM USER_TABLE WHERE USER_ID = ? AND PASSWORD = ?");
            p.setString(1, user_id);
            p.setString(2, pass);
            ResultSet rs = p.executeQuery();
            String s="";
            if(rs.next()){
                s=rs.getString(1).toLowerCase();

            }
            if(s.equals("customer")){
                return 2;
            }
            else if(s.equals("admin")){
                return 1;
            }
            else {
                return 3;

            }
        }
        catch(Exception err){
            System.out.println(err);
        }
        return 3;

    }
}