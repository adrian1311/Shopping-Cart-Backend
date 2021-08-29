package exercise.shoppingCart.Controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import exercise.shoppingCart.Dtos.Product;
import exercise.shoppingCart.Dtos.ShoppingCart;
import exercise.shoppingCart.Manager.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("shoppingCart")
public class ShoppingCartController {

    @Autowired
    private Manager manager;

    @PostMapping(value = "/showProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> showProductsInShop() {
        return manager.show();
    }

    @PostMapping(value = "/addProductInCart", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShoppingCart addProductInCart(@RequestBody List<Product> products) {
        return manager.calculateShoppingCart(products);
    }
    @PostMapping(value = "/addProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShoppingCart addProduct(@RequestBody Product product) {
        return manager.addProduct(product);
    }

    @PostMapping(value = "/deleteProduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShoppingCart deleteProduct(@RequestBody Product product) {
        return manager.deleteProd(product);
    }


    }
