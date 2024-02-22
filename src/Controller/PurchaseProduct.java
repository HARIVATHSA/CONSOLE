package Controller;

import Modal.Cart;

public class PurchaseProduct {
    public static double PurchaseProduct(double amt, String user_id){
        double totalamt=Cart.gettotalamt(user_id);
        double balance=0;
        if(amt>=totalamt){
            balance=amt-totalamt;
            Cart.updatequantity(user_id);
            Cart.purchase(user_id);
        }
        else{
            return -1;
        }
        return balance;
    }

    public static boolean checkavail(String prdt_id, int quantinty) {
        int qtyavail=Cart.checkavail(prdt_id,quantinty);
        if(qtyavail>=quantinty){
            return true;
        }
        else{
            return false;
        }
    }
    
}
