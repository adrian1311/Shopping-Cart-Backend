package exercise.shoppingCart.Dtos;

import lombok.Data;

import java.util.Objects;
@Data
public class Home extends Product {

    private String color;

    public Home(String productName, int productAmount, double productPrice,double totalPrice, double discount,String color,int orderedProducts) {
        super(productName, productAmount, productPrice,totalPrice,discount,orderedProducts);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Home -->" +
                " NAME : '" + getProductName() + '\'' +
                ", AMOUNT : '" + getProductAmount() + '\'' +
                ", PRICE  :'" + getProductPrice() + '\'' +
                ", COLOR : '" + color + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return color.equals(home.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

}
