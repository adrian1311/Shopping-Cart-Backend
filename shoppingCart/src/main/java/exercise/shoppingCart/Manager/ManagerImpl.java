package exercise.shoppingCart.Manager;

import exercise.shoppingCart.Dtos.Product;
import exercise.shoppingCart.Dtos.Shop;
import exercise.shoppingCart.Dtos.ShoppingCart;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ManagerImpl implements Manager {
    Logger LOGGER = LoggerFactory.getLogger(ManagerImpl.class);

    private Shop shop;
    private ShoppingCart cart;

    public ManagerImpl(){
        this.shop=new Shop();
        this.cart = new ShoppingCart();
    }

    public List<Product> show(){
        return shop.getProductsInMarket();
    }

    public ShoppingCart calculateShoppingCart(List<Product> products){
        double totalPrice = 0;
        double totalPriceWithOutDiscount = 0;
        double discount = 0;

        for(Product product : products){
            product.setTotalPrice(product.getOrderedProducts() * product.getProductPrice());
            totalPriceWithOutDiscount += product.getTotalPrice();
            if(product.getOrderedProducts()>=2){
                product.setDiscount(product.getTotalPrice()*0.9);
                totalPrice +=product.getOrderedProducts() * (product.getProductPrice() * 0.9);
            }else {
                product.setDiscount(product.getTotalPrice());
                totalPrice +=product.getOrderedProducts() * product.getProductPrice();
            }
        }
        if(totalPrice>100){
            cart.setTotalPrice(totalPrice * 0.9);
        }else{
            cart.setTotalPrice(totalPrice);
        }

        discount = totalPriceWithOutDiscount-totalPrice;
        cart.setDiscountWithOut100(totalPrice);
        cart.setTotalDiscount(discount);
        cart.setTotalPriceWithOutDiscount(totalPriceWithOutDiscount);
        cart.setProductsInCart(products);
        return cart;

    }

    public ShoppingCart addProduct(Product product){
        boolean productExist = false;
            for(Product productInCart : cart.getProductsInCart()){
                if(product.getProductName().equals(productInCart.getProductName()) ){
                    productExist = true;
                        productInCart.setOrderedProducts( productInCart.getOrderedProducts() + product.getOrderedProducts());
                }
            }
            if(!productExist && product.getOrderedProducts()>0 && product.getProductAmount()>product.getOrderedProducts()){
                cart.getProductsInCart().add(product);
            }
        return calculateShoppingCart(cart.getProductsInCart());
    }

    public ShoppingCart deleteProd(Product product){
        for (Iterator<Product> iterator = cart.getProductsInCart().iterator(); iterator.hasNext(); ) {
            Product value = iterator.next();
            if (product.getProductName().equals(value.getProductName())) {
                iterator.remove();
            }
        }
        return calculateShoppingCart(cart.getProductsInCart());
    }

}
