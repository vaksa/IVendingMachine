package Money;

public class Money {
    public double euros;
    public double cents;
    public double price;
    public static double amount;

    public Money(double euros, double cents) {
        this.euros = euros;
        this.cents = cents;
        this.price = euros + cents / 100;
    }

    public static void returnMoney() {
        amount = 0.0;
    }

    public double getEuros() {
        return euros;
    }

    public void setEuros(double euros) {
        this.euros = euros;
    }

    public double getCents() {
        return cents;
    }

    public void setCents(double cents) {
        this.cents = cents;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
