package Modal;

import java.sql.PreparedStatement;


public class Users extends Connect{
    public static boolean InsertUserdata(String user_id,String name, String email, String contact,String address, String pass){
        try{
            String role="Customer";
           PreparedStatement users = conn.prepareStatement("INSERT INTO USER_TABLE(USER_ID, USER_NAME, EMAIL, CONTACT, ADDRESS, PASSWORD, ROLE) VALUES (?, ?, ?, ?, ?, ?, ?)");
                users.setString(1, user_id);
                users.setString(2, name);
                users.setString(3, email);
                users.setString(4, contact);
                users.setString(5, address);
                users.setString(6, pass);
                users.setString(7, role);
                users.executeUpdate();
                System.out.println("Processing.....");
                try {
                    for (int i = 5; i >= 0; i--) {
                        System.out.print("\r" + i + " ");
                        Thread.sleep(1000); 
                    }
                    System.out.println("\r"+"---------- Account created Succesfully ----------");
                    return true;
                   
                } catch (Exception err) {
                    System.out.println(err);
                }
        }
        catch(Exception err){
            System.out.println(err);
        }
        return false;

    }
    
}
