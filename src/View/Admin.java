package View;

import java.util.Date;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import Modal.Customer;
import Modal.Product;
import Resources.ProductDTO;

public class Admin {
    
    public static void Adminview(){
            ProductDTO product=new ProductDTO(null, null, 0, null, null, 0, null, 0);

            Scanner in=new Scanner(System.in);
        while(true){
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                 Welcome Manager                  |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("|   Press>>1 Add Product                           |");
            System.out.println("|   Press>>2 Remove Product                        |");
            System.out.println("|   Press>>3 Update Product                        |");
            System.out.println("|   Press>>4 View Product                          |");
            System.out.println("|   Press>>5 View Customer Details                 |");
            System.out.println("|   Press>>6 Exit                                  |");
            System.out.println("+--------------------------------------------------+");
            
            System.out.print("Enter your choice >>");
            int n=in.nextInt();
            in.nextLine();
            
            if(n==1){
                while(true){
                System.out.println("Enter Type of the Product (Tablet/Syrup/Oilment/NonDrug): ");
                String type = in.nextLine().toLowerCase();
                if("tablet".contains(type)){
                    type="TABLET";
                }
                else if("syrup".contains(type)){
                    type="SYRUP";
                }
                else if("oilment".contains(type)){
                    type="OILMENT";
                }
                else if("nondrug".contains(type)){
                    type="NON_DRUG";
                }
                else{
                    System.out.println("Enter valid type :");
                    continue;

                }
                System.out.println("Enter Product_name : ");
                String prdt_name = in.nextLine();
                System.out.println("Unit of measurement : ");
                int uom = in.nextInt();
                System.out.println("Enter Prdt_count : ");
                int prdt_count=in.nextInt();
                System.out.println("Enter Manufacture Date : ");
                in.nextLine();
                String Mnfdate = in.nextLine();
                System.out.println("Enter Expire Date : ");
                String expdate = in.nextLine();
                System.out.println("Enter Price of product : ");
                double price = in.nextDouble();
                in.nextLine();
                System.out.println("Enter Manufacturer of product : ");
                String manufacturer =in.nextLine();

                if(Product.addProduct(type,prdt_name,uom,Mnfdate,expdate,price,manufacturer,prdt_count)){
                    break; 
                }
            }
            }
            if(n==2){
                System.out.println("Enter Type : ");
                String type = in.nextLine();
                System.out.println("Enter Product_Name");
                String prdt_name=in.nextLine();
                Product.removeProduct(type, prdt_name);
                continue;
            }
            if(n==3){
                System.out.println("+--------------------------------------------------+");
                System.out.println("|                  Update Product                  |");
                System.out.println("+--------------------------------------------------+");
                System.out.println("|   Press>>1 Update Product Name                   |");
                System.out.println("|   Press>>2 Update Product Price                  |");
                System.out.println("|   Press>>3 Update Product Manfacture Date        |");
                System.out.println("|   Press>>4 Update Product Expiry Date            |");
                System.out.println("|   Press>>5 Update Product type                   |");
                System.out.println("|   Press>>6 Update Product Manufacturer           |");
                System.out.println("|   Press>>7 Update Product Count                  |");
                System.out.println("|   Press>>8 Exit                                  |");
                System.out.println("+--------------------------------------------------+");
            
                System.out.print("Enter your choice >>");
                int c=in.nextInt();
                in.nextLine();
                if(c==1){
                    System.out.println("Enter Product_id : ");
                    String prdt_id=in.nextLine();
                    System.out.println("Enter Product_Name : ");
                    String prdt_name=in.nextLine();
                    Product.UpdateName(prdt_name,prdt_id);
                }
                if(c==2){
                    System.out.println("Enter Product_id : ");
                    String prdt_id=in.nextLine();
                    System.out.println("Enter Product_Price : ");
                    double price=in.nextDouble();
                    Product.UpdatePrice(price,prdt_id);
                    
                }
                if(c==3){
                    System.out.println("Enter Product_id : ");
                    String prdt_id=in.nextLine();
                    System.out.println("Enter Manufacture Date : ");
                    String mnf_date=in.nextLine();
                    Product.UpdateMnfDate(mnf_date,prdt_id);
                    
                }
                if(c==4){
                    System.out.println("Enter Product_id : ");
                    String prdt_id=in.nextLine();
                    System.out.println("Enter Expire Date : ");
                    String expdate=in.nextLine();
                    Product.UpdatExpDate(expdate,prdt_id);
                    
                }
                if(c==5){
                    System.out.println("Enter Product_id : ");
                    String prdt_id=in.nextLine();
                    System.out.println("Enter Product_Type : ");
                    String type=in.nextLine();
                    Product.UpdateType(type,prdt_id);
                    
                }
                if(c==6){
                    System.out.println("Enter Product_id : ");
                    String prdt_id=in.nextLine();
                    System.out.println("Enter Manuufacturer : ");
                    String manufact=in.nextLine();
                    Product.Updatemanufact(manufact,prdt_id);
                    
                }
                if(c==7){
                    System.out.println("Enter Product_id : ");
                    String prdt_id=in.nextLine();
                    System.out.println("Enter Product_Count : ");
                    int prdt_count=in.nextInt();
                    Product.UpdatePrdtCount(prdt_count,prdt_id);

                }
                if(c==8){
                    continue;
                }

                
                continue;
            }
            if(n==4){
                Product.viewProducts();
                continue;
            }
            if(n==5){
                Customer.viewCustomer();
                continue;
            }
            if(n==6){
                return;
            }

        }
            
    }
}
