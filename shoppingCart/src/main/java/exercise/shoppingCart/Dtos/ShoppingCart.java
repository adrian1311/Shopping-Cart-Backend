package exercise.shoppingCart.Dtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ShoppingCart {

    private List<Product> productsInCart;
    private double totalPrice; // AMOUNT WITH DISCOUNT
    private double totalPriceWithOutDiscount; // TOTAL AMOUNT
    private double totalDiscount; //DISCOUNT
    private double discountWithOut100; //TOTAL AMOUN WITHOUT DISCOUNT WHEN MORE THAN 100

    public ShoppingCart(){
        this.productsInCart = new ArrayList<>();
    }

}
