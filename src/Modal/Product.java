package Modal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import View.User;

public class Product extends Connect {
    public static boolean addProduct(String type, String prdt_name, int uom, String mnfdate, String expdate, double price, String manufacturer, int prdt_count){
    try{
        PreparedStatement products = conn.prepareStatement("INSERT INTO PRODUCT_TABLE(PRDT_ID,PRDT_NAME,UNIT_OF_MSMT,PRICE,MANUFACTER,MNF_DATE,EXPIRY_DATE,PRDT_COUNT,PRICEPERUNIT,type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,? )");

       String prdt_id=""+type.charAt(0)+prdt_name;
        double price_unit=price/uom;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date mnfDate = dateFormat.parse(mnfdate);
        Date expDate = dateFormat.parse(expdate);

        products.setString(1, prdt_id);
        products.setString(2, prdt_name);
        products.setInt(3, uom);
        products.setDouble(4, price);
        products.setString(5, manufacturer);
        products.setDate(6, new java.sql.Date(mnfDate.getTime()));        
        products.setDate(7, new java.sql.Date(expDate.getTime()));
        products.setInt(8, prdt_count);
        products.setDouble(9, price_unit);
        products.setString(10, type);
        products.executeUpdate();
        try {
            for (int i = 5; i >= 0; i--) {
                System.out.print("\r" + i + " ");
                Thread.sleep(1000); 
            }
            System.out.println("\r"+"---------- Product Added Succesfully ----------");
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

    public static void viewProducts() {
        try {
            PreparedStatement products = conn.prepareStatement("SELECT * FROM PRODUCT_TABLE");

            ResultSet viewprodcuts = products.executeQuery();

            System.out.println("+---------------+--------------------+---------------+---------------+--------------------+---------------+---------------+---------------+---------------+---------------+");
            System.out.printf("| %-13s | %-18s | %-13s | %-13s | %-18s | %-13s | %-13s | %-13s | %-13s | %-13s |%n",
                    "PRDT_ID", "PRDT_NAME", "UNIT_OF_MSMT", "PRICE", "MANUFACTER", "MNF_DATE", "EXPIRY_DATE", "PRDT_COUNT", "PRICEPERUNIT", "TYPE");
            System.out.println("+---------------+--------------------+---------------+---------------+--------------------+---------------+---------------+---------------+---------------+---------------+");

            while (viewprodcuts.next()) {
                System.out.printf("| %-13s | %-18s | %-13s | %-13s | %-18s | %-13s | %-13s | %-13s | %-13s | %-13s |%n",
                        viewprodcuts.getString("PRDT_ID"),
                        viewprodcuts.getString("PRDT_NAME"),
                        viewprodcuts.getInt("UNIT_OF_MSMT"),
                        viewprodcuts.getDouble("PRICE"),
                        viewprodcuts.getString("MANUFACTER"),
                        viewprodcuts.getDate("MNF_DATE"),
                        viewprodcuts.getDate("EXPIRY_DATE"),
                        viewprodcuts.getInt("PRDT_COUNT"),
                        viewprodcuts.getDouble("PRICEPERUNIT"),
                        viewprodcuts.getString("TYPE"));
            }
            System.out.println("+---------------+--------------------+---------------+---------------+--------------------+---------------+---------------+---------------+---------------+---------------+");

            System.out.print("\n\n");



        } catch (Exception err) {
            System.out.print(err);
        }

    }
    public static void removeProduct(String type, String prdt_name){
        
        try {
            PreparedStatement products = conn.prepareStatement("DELETE FROM PRODUCT_TABLE WHERE PRDT_ID = ?");
            String prdt_id=""+type.charAt(0)+prdt_name;
            products.setString(1, prdt_id);
            products.executeUpdate();



        } catch (Exception err) {
            System.out.println(err);
        }


    }

    public static void UpdateName(String prdt_name, String prdt_id) {
        try {
            PreparedStatement products = conn.prepareStatement("UPDATE PRODUCT_TABLE SET PRDT_NAME = ? WHERE PRDT_ID = ?");
            products.setString(1, prdt_name);
            products.setString(2, prdt_id);
            products.executeUpdate();



        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public static void UpdateMnfDate(String mnf_date, String prdt_id) {
        try {
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date mnfDate = dateFormat.parse(mnf_date);
            PreparedStatement products = conn.prepareStatement("UPDATE PRODUCT_TABLE SET MNF_DATE = ? WHERE PRDT_ID = ?");
            products.setDate(1, new java.sql.Date(mnfDate.getTime()));     
            products.setString(2, prdt_id);
            products.executeUpdate();
            System.out.println("MNF_DATE Updated Successfully.");



        } catch (Exception err) {
            
            err.printStackTrace();
            System.out.println(err);
        }

    }

    public static void UpdatExpDate(String expdate, String prdt_id) {
        try {
            PreparedStatement products = conn.prepareStatement("UPDATE PRODUCT_TABLE SET EXPIRY_DATE = ? WHERE PRDT_ID = ?");
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date expDate = dateFormat.parse(expdate);
            products.setDate(1, new java.sql.Date(expDate.getTime()));     
            products.setString(2, prdt_id);
            products.executeUpdate();



        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public static void UpdateType(String type, String prdt_id) {
        try {

            PreparedStatement products = conn.prepareStatement("UPDATE PRODUCT_TABLE SET TYPE = ? , PRDT_ID = ? WHERE PRDT_ID = ?");
            String u_id=type.charAt(0)+prdt_id.substring(1);
            products.setString(1, type);
            products.setString(2, prdt_id);
            products.executeUpdate();



        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public static void Updatemanufact(String manufact, String prdt_id) {
        try {
            manufact="hari";
            PreparedStatement products = conn.prepareStatement("UPDATE PRODUCT_TABLE SET MANUFACTER = ? WHERE PRDT_ID = ?");
            products.setString(1, manufact);
            products.setString(2, prdt_id);
            products.executeUpdate();



        } catch (Exception err) {
            System.out.println(err);
        }

    }

    public static void UpdatePrdtCount(int prdt_count, String prdt_id) {
        try {
            PreparedStatement products = conn.prepareStatement("UPDATE PRODUCT_TABLE SET PRDT_COUNT = ? WHERE PRDT_ID = ?");
            products.setInt(1, prdt_count);
            products.setString(2, prdt_id);
            products.executeUpdate();



        } catch (Exception err) {
            System.out.println(err);
        }
        

    }

    public static void UpdatePrice(double price, String prdt_id) {
        try {
            System.out.println(prdt_id);
            PreparedStatement products = conn.prepareStatement("UPDATE PRODUCT_TABLE SET PRICE = ? WHERE PRDT_ID = ?");
            products.setDouble(1, price);
            products.setString(2, prdt_id);
            products.executeUpdate();



        } catch (Exception err) {
            System.out.println(err);
        }

    }

    public static void displayProducts(String user_id) {
        try {
            PreparedStatement products = conn.prepareStatement("SELECT PRDT_ID,TYPE,PRDT_NAME,UNIT_OF_MSMT,PRDT_COUNT,PRICEPERUNIT FROM PRODUCT_TABLE");

            ResultSet viewprodcuts = products.executeQuery();

            System.out.println("+-------+---------------+---------------+--------------------+---------------+---------------+---------------+");
            System.out.printf("| %5s | %-13s | %-13s | %-18s | %-13s | %-13s | %-13s |%n",
                    "S.NO", "PRDT_ID", "TYPE" ,  "PRDT_NAME", "UNIT_OF_MSMT","QTY AVAIL","PRICEPERUNIT");
            System.out.println("+-------+---------------+---------------+--------------------+---------------+---------------+---------------+");
            int c=1;
            while (viewprodcuts.next()) {
                System.out.printf("| %5s | %-13s | %-13s | %-18s | %-13s | %-13s | %-13s |%n",
                c++,
                viewprodcuts.getString("PRDT_ID"),
                viewprodcuts.getString("TYPE"),
                viewprodcuts.getString("PRDT_NAME"),
                viewprodcuts.getInt("UNIT_OF_MSMT"),
                viewprodcuts.getInt("PRDT_COUNT"),
                viewprodcuts.getDouble("PRICEPERUNIT"));
            }
            System.out.println("+-------+---------------+---------------+--------------------+---------------+---------------+---------------+");

            System.out.print("\n\n");
            User.addtoCart(user_id);



        } catch (Exception err) {
            System.out.print(err);
        }


    }

   
    
}
