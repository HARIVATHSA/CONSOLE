
import java.util.*;
import java.sql.SQLException;
import java.util.InputMismatchException;

import Controller.CheckUser;
import Modal.Connect;
import Modal.Customer;
import Resources.ProductDTO;
import View.Admin;
import View.New_user;
import View.User;

public class Index {
    public static void main(String args[]) throws SQLException {
        Scanner in=new Scanner(System.in);
        Connect.getConnection();
        
        while(true){
            System.out.println("+"+"-".repeat(50)+"+");
            System.out.println("|                    Pharm Care                    |");
            System.out.println("+"+"-".repeat(50)+"+");
            System.out.println("|                  Press 1 >> Login                |");
            System.out.println("|                  Press 2 >> New User             |");
            System.out.println("|                  Press 3 >> Exit                 |");
            System.out.println("+"+"-".repeat(50)+"+");
            System.out.print("Enter your choice >>");
            int n=in.nextInt();
            if(n==1){
                in.nextLine();
                System.out.println("User_id : ");
                String user_id=in.nextLine();
                System.out.println("Password");
                String pass=in.nextLine();
                System.out.println("Confirm Password");
                String confirmpass=in.nextLine();
                int check=CheckUser.CheckUser(user_id,pass,confirmpass);
                if(check==1){
                    Admin.Adminview();
                }
                else if(check==2){
                    User.startCustomer(user_id);
                }
                else{
                    System.out.println("**************************<<Register First>>*************************");
                    continue;
                }
            }
            else if(n==2){
                New_user.view();
            }
            else if(n==3){
                
                break;
            }
            else{
                System.out.println("********************Enter valid number********************");
            }

        }



       
        
    }

}
