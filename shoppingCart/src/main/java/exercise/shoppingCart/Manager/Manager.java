package exercise.shoppingCart.Manager;

import exercise.shoppingCart.Dtos.Product;
import exercise.shoppingCart.Dtos.ShoppingCart;

import java.util.List;

public interface Manager {

    public List<Product> show();
    public ShoppingCart calculateShoppingCart(List<Product> products);
    public ShoppingCart addProduct(Product product);
    public ShoppingCart deleteProd(Product product);

}
