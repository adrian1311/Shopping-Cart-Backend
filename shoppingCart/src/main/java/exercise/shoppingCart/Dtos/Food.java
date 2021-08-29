package exercise.shoppingCart.Dtos;

import lombok.Data;

import java.util.Objects;
@Data
public class Food extends Product {

    private String type;

    public Food(String productName, int productAmount, double productPrice,double totalPrice, double discount,String type,int orderedProducts) {
        super(productName, productAmount, productPrice,totalPrice,discount,orderedProducts);
        this.type = type;

    }

    @Override
    public String toString() {
        return "Food -->" +
                "  NAME : '" + getProductName() + '\'' +
                ", AMOUNT : '" + getProductAmount() + '\'' +
                ", PRICE : '" + getProductPrice() + '\'' +
                ", TYPE : '" + type + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(type, food.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
