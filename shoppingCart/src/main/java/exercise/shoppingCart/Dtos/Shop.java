package exercise.shoppingCart.Dtos;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Shop {

    private String name;
    private List<Product> productsInMarket;

    public Shop(){
        productsInMarket=new ArrayList<>();
        createProducts();
    }

    private void createProducts(){
        Product product1 = new Food("Coca-Cola",10,5.5,0,0,"drink",0);
        Product product2 = new Food("Chicken",10,6.3,0,0,"meal",0);
        Product product3 = new Food("Chocolate",10,7,0,0,"sweet",0);
        Product product4 = new Home("Sofa",3,20,0,0,"marron",0);
        Product product5 = new Home("Table",3,24.5,0,0,"black",0);
        Product product6 = new Technology("TV",5,60,0,0,2,0);
        Product product7 = new Technology("MP3",10,14.5,0,0,1,0);
        productsInMarket.add(product1);
        productsInMarket.add(product2);
        productsInMarket.add(product3);
        productsInMarket.add(product4);
        productsInMarket.add(product5);
        productsInMarket.add(product6);
        productsInMarket.add(product7);
    }

    public void showProducts(){
        for (Product product : productsInMarket){
            System.out.println(product.toString());
        }
    }

}
