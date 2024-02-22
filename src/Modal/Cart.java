package Modal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cart extends Connect{

    public static void InserttoCart(String user_id, String prdt_id, int quantinty) {
        try{


            PreparedStatement cart = conn.prepareStatement("SELECT PRICEPERUNIT FROM PRODUCT_TABLE where prdt_id= ? "); 
            cart.setString(1, prdt_id);
            ResultSet price=cart.executeQuery();
            int ppu=0;
            while(price.next()){
                ppu=price.getInt(1);
            }
            cart=conn.prepareStatement("SELECT PRDT_ID FROM CART WHERE PRDT_ID=?");
            cart.setString(1, prdt_id);
            ResultSet c=cart.executeQuery();
            if(c.next()){

                cart = conn.prepareStatement("UPDATE CART SET QUANTITY = QUANTITY + ?, MRP = MRP + ? WHERE PRDT_ID= ?;");
                
                cart.setInt(1, quantinty);
                cart.setDouble(2, ppu);
                cart.setString(3, prdt_id);
                cart.executeUpdate();
                return;
            }

            cart = conn.prepareStatement("INSERT INTO CART( USER_ID,PRDT_ID,QUANTITY,PRICE_PER_UNIT,MRP) VALUES ( ?, ?, ?, ?, ?)");
            
            cart.setString(1, user_id);
            cart.setString(2, prdt_id);
            cart.setInt(3, quantinty);
            cart.setInt(4, ppu);
            cart.setInt(5, (ppu*quantinty));
            cart.executeUpdate();
        
        }
        catch(Exception err){
            System.out.println(err);

        }  
    }

   
    public static boolean displayCart(String user_id) {
        try{
            PreparedStatement cart = conn.prepareStatement("SELECT * FROM CART WHERE  USER_ID=?");
            cart.setString(1, user_id);
            ResultSet viewcart=cart.executeQuery();
            if(viewcart.next()){
            cart = conn.prepareStatement("SELECT * FROM CART WHERE  USER_ID=?");
            cart.setString(1, user_id);
            viewcart=cart.executeQuery();
            System.out.println("+------------+----------------------+-----------------+------------+------------+------------+");
            System.out.printf("| %10s | %-20s | %-15s | %-10s | %10s | %10s |%n",
            "C_ID", "USER_ID", "PRODUCT_ID" ,  "QUANTITY" , "PRICE/UNIT","TOTAL COST");
            System.out.println("+------------+----------------------+-----------------+------------+------------+------------+");
            
            while (viewcart.next()) {
                System.out.printf("| %10s | %-20s | %-15s | %-10s | %-10s | %-10s |%n",
                viewcart.getString(1),
                viewcart.getString(2),
                viewcart.getString(3),
                viewcart.getString(4),
                viewcart.getString(5),
                viewcart.getString(6)
                );
                
            }
            cart = conn.prepareStatement("SELECT SUM(MRP) FROM CART WHERE USER_ID= ?");
            cart.setString(1, user_id);
            ResultSet total=cart.executeQuery();
            double TOTAL=0;
            while(total.next()){
                TOTAL=total.getDouble(1);
            }
                System.out.println("+------------+----------------------+-----------------+------------+------------+------------+");
                System.out.printf("|%-30s << AMOUNT TO PAY >>  %26s |  %-9s |%n ", "", "",TOTAL);
                System.out.println("\r+------------+----------------------+-----------------+------------+------------+------------+");
            return true;
        }
        else{
            System.out.println("******************** CART IS EMPTY ********************");
            return false;
        }

        }
        catch(Exception err){
            System.out.println(err);
            return false;
    }

    }
    public static double gettotalamt(String user_id) {
        try {
            PreparedStatement cart = conn.prepareStatement("SELECT SUM(MRP) FROM CART WHERE USER_ID= ?");
            cart.setString(1, user_id);
            ResultSet total=cart.executeQuery();
            double TOTAL=0;
            while(total.next()){
                TOTAL=total.getDouble(1);
            }
            return TOTAL;

        } catch (Exception err) {
            System.out.println(err);
        }
        
        
        
        return 0;
    }


    public static void purchase(String user_id) {
        try {
            PreparedStatement cart = conn.prepareStatement("DELETE FROM CART WHERE USER_ID= ?");
            cart.setString(1, user_id);
            cart.executeUpdate();
           
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void updatequantity(String user_id) {
        try {
            PreparedStatement cart = conn.prepareStatement("SELECT PRDT_ID,QUANTITY FROM CART WHERE USER_ID = ?");
            cart.setString(1, user_id);
            ResultSet rs=cart.executeQuery();
            while(rs.next()){
                String id=rs.getString(1);
                int quantinty=rs.getInt(2);
                PreparedStatement product=conn.prepareStatement("UPDATE PRODUCT_TABLE SET PRDT_COUNT = PRDT_COUNT - ? WHERE prdt_id = ?;");
                product.setInt(1, quantinty);
                product.setString(2, id);
                product.executeUpdate();
            }
           
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public static int checkavail(String prdt_id, int quantinty) {
        try {
            PreparedStatement cart=conn.prepareStatement("SELECT PRDT_COUNT FROM PRODUCT_TABLE WHERE PRDT_ID=?");
            cart.setString(1, prdt_id);
            ResultSet rs=cart.executeQuery();
            int q=0;
            if(rs.next()){
                q=rs.getInt("prdt_count");
            }
            else{
                q=-1;
            }
            return q;
        } catch (Exception e) {
            System.out.println(e);

        }
        return -1;
    }
    
}
