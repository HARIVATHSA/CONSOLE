package Modal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Customer extends Connect {
    public static void viewCustomer(){
        try {
            PreparedStatement customers = conn.prepareStatement("SELECT * FROM USER_TABLE WHERE ROLE LIKE '%CUSTOMER%'");

            ResultSet viewcustomers = customers.executeQuery();
            System.out.println("+------------+----------------------+----------------------+----------------------+----------------------+----------------------+---------------+");
            System.out.printf("| %-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-13s |%n",
                    "USER_ID", "USER_NAME", "EMAIL", "CONTACT", "ADDRESS", "PASSWORD", "ROLE");
            System.out.println("+------------+----------------------+----------------------+----------------------+----------------------+----------------------+---------------+");

            while (viewcustomers.next()) {
                System.out.printf("| %-10s | %-20s | %-20s | %-20s | %-20s | %-20s | %-13s |%n",
                        viewcustomers.getString("USER_ID"),
                        viewcustomers.getString("USER_NAME"),
                        viewcustomers.getString("EMAIL"),
                        viewcustomers.getString("CONTACT"),
                        viewcustomers.getString("ADDRESS"),
                        viewcustomers.getString("PASSWORD"),
                        viewcustomers.getString("ROLE"));
            }

            System.out.println("+------------+----------------------+----------------------+----------------------+----------------------+----------------------+---------------+");




        } catch (Exception err) {
            System.out.print(err);
        }


    }       
        

}
