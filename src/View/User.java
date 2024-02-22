package View;

import java.util.Scanner;

import Controller.PurchaseProduct;
import Modal.Cart;
import Modal.Product;

public class User {
    static Scanner in=new Scanner(System.in);
    public static void startCustomer(String user_id) {
        while(true){
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                   Welcome User                   |");
            System.out.println("+--------------------------------------------------+");
            System.out.println("|   Press>>1 View Products                         |");
            System.out.println("|   Press>>2 View Cart                             |");
            System.out.println("|   Press>>3 Exit                                  |");
            System.out.println("+--------------------------------------------------+");
            
            System.out.print("Enter your choice >>");
            int n=in.nextInt();
            in.nextLine();
            if(n==1){
                Product.displayProducts(user_id);

            }
            else if(n==2){
                if(!Cart.displayCart(user_id)){
                    continue;
                }
                System.out.println("+--------------------------------------------------+");
                System.out.println("|                   Welcome User                   |");
                System.out.println("+--------------------------------------------------+");
                System.out.println("|   Press>>1 PAY AMOUNT                            |");
                System.out.println("|   Press>>2 EXIT                                  |");
                System.out.println("+--------------------------------------------------+");
            
                System.out.print("Enter your choice >>");
                int c=in.nextInt();
                if(c==1){
                    if(Cart.displayCart(user_id)){
                        System.out.println("Enter Your Amount");
                        double amt=in.nextDouble();
                        double balance=PurchaseProduct.PurchaseProduct(amt,user_id);
                        if(balance<0){
                            System.out.println("Amount is Less than your purchase");
                        }
                        else{
                            System.out.print("Processing.....");
                                    try {
                                        for (int i = 5; i >= 0; i--) {
                                            System.out.print (".");
                                            Thread.sleep(1000); 
                                        }
                                        System.out.println("\r"+"---------- Payment Succesfull ----------");
                                    
                                    } catch (Exception err) {
                                        System.out.println(err);
                                    }
                            System.out.println("Your Balance Amount : "+balance);
                        }
                        
                    }
                    else{
                        System.out.println("***************** PURCHASE ANY PRODUCT TO PROCEED *****************");
                        continue;
                    }
                    continue;
                }
                if(c==2){
                    continue;
                }

            }
            else if(n==3){
                return;
            }
            else{
                System.out.println("********************Enter valid choice********************");
            }
        }
    }
    public static void addtoCart(String user_id) {
        System.out.println("<<<<Add to Cart By Product_id>>>>");
        while(true){
        System.out.println("Enter Product_ID : ");
        String prdt_id=in.nextLine();
        System.out.println("Enter Quantinty : ");
        int Quantinty=in.nextInt();
        in.nextLine();
        if(!PurchaseProduct.checkavail(prdt_id,Quantinty)){
            System.out.println("-------------------- No sufficient quantity ----------------------");
            continue;
        }
        else{
            Cart.InserttoCart(user_id,prdt_id,Quantinty);  
            System.out.println("---------------------Product Added to cart---------------------");
            break;
        }
        }
    }
   
  
    
}
