package View;

import java.util.*;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import Controller.CheckUser;
import Controller.User_validation;
import Modal.Users;

public class New_user {
   
    public static void view() {
            Scanner in=new Scanner(System.in);

            while(true){
                
                System.out.print("Enter Your User_id : ");
                String user_id=in.nextLine();
                System.out.print("Enter Your Name : ");
                String name=in.nextLine();
                System.out.print("Enter Your Email : ");
                String email=in.nextLine();
                System.out.print("Enter Your Contact : ");
                String contact=in.nextLine();
                System.out.print("Enter Your Address : ");
                String address=in.nextLine();
                System.out.print("Password : ");
                String pass=in.nextLine();
                System.out.print("Confirm Password : ");
                String confirmpass=in.nextLine();
                
                boolean valid=User_validation.validate_user(name,email,contact,pass,confirmpass);
                boolean check=CheckUser.CheckUserID(user_id);
                if(valid && check){
                    if(Users.InsertUserdata(user_id,name,email,contact,address,pass)){
                        return;
                    }
                }
            }
    }

}
