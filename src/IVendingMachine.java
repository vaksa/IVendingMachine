import Money.Money;
import Product.Product;

public interface IVendingMachine {
    String Manufacturer = "DDD"; //{ get; }

    State machineState = null;

    /// <summary>Amount of money inserted into vending machine. </summary>
    Money Amount = null;// { get; }

    /// <summary>Products that are sold.</summary>
    Product[] Products = null;// { get; set; }

    /// <summary>Inserts the coin into vending machine.</summary>
/// <param name="amount">Coin amount.</param>
    Money InsertCoin(Money amount);
    /// <summary>Returns all inserted coins back to user.</summary>
    Money ReturnMoney();
/// <summary>Buys product from list of product.</summary>
/// <param name="productNumber">Product.Product number in vending machine product
//    list.</param>
    Product Buy(int productNumber);
}