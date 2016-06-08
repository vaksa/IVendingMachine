package Product;

import Money.Money;

public class Product {
    public static int available;
    public Money price;
    public String name;

    public Product(String name, Money price){
        available++;
        this.name = name;
        this.price = price;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
