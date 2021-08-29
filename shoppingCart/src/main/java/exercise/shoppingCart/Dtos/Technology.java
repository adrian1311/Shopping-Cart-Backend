package exercise.shoppingCart.Dtos;

import lombok.Data;

import java.util.Objects;
@Data
public class Technology extends Product {
    private int guarantee;

    public Technology(String productName, int productAmount, double productPrice, double totalPrice, double discount,  int guarantee,int orderedProducts) {
        super(productName, productAmount, productPrice,totalPrice,discount,orderedProducts);
        this.guarantee = guarantee;
    }


    @Override
    public String toString() {
        return "Technology -->" +
                " NAME :'" + getProductName() + '\'' +
                ", AMOUNT : '" + getProductAmount() + '\'' +
                ", PRICE : '" + getProductPrice() + '\'' +
                ", GUARANTEE : " + guarantee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Technology that = (Technology) o;
        return guarantee == that.guarantee;
    }

    @Override
    public int hashCode() {
        return Objects.hash(guarantee);
    }
}
