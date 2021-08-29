package exercise.shoppingCart.Dtos;

import lombok.Data;

@Data
    public class Product {

        private String productName;
        private int productAmount;
        private double productPrice;
        private double totalPrice;
        private double discount;
        private int orderedProducts;

        public Product(String productName, int productAmount, double productPrice, double totalPrice, double discount,int orderedProducts){
            this.productName = productName;
            this.productAmount = productAmount;
            this.productPrice = productPrice;
            this.totalPrice = totalPrice;
            this.discount = discount;
            this.orderedProducts = orderedProducts;
        }

        public Product(){

        }

    @Override
        public String toString() {
            return "Product --> " +
                    "  NAME ='" + productName + '\'' +
                    ", AMOUNT =" + productAmount +
                    ", PRICE =" + productPrice;
        }
    }
