import Money.Money;
import Product.Product;

import java.util.ArrayList;

public class VendingMachine {

    State emptyState = new EmptyState(this);

    State noCoinInsertedState = new NoCoinInsertedState(this);

    State coinInsertedState = new CoinInsertedState(this);

    State dispensingState = new DispensingState(this);

    State machineState = null;

    public ArrayList<Product> products = new ArrayList<>();

    public State getMachineState() {
        return machineState;
    }

    public void setMachineState(State machineState) {
        this.machineState = machineState;
    }

    public State getDispensingState() {
        return dispensingState;
    }

    public void setDispensingState(State dispensingState) {
        this.dispensingState = dispensingState;
    }

    public State getCoinInsertedState() {
        return coinInsertedState;
    }

    public void setCoinInsertedState(State coninInsertedState) {
        this.coinInsertedState = coninInsertedState;
    }

    public State getNoCoinInsertedState() {
        return noCoinInsertedState;
    }

    public void setNoCoinInsertedState(State noCoinInsertedState) {
        this.noCoinInsertedState = noCoinInsertedState;
    }

    public State getEmptyState() {
        return emptyState;
    }

    public void setEmptyState(State emptyState) {
        this.emptyState = emptyState;
    }

    public void addProduct(String name, Money price) throws MachineWarning {
        products.add(new Product(name, price));
        setMachineState(getNoCoinInsertedState());
    }

    public void dispenseProduct(String productName) {
        System.out.println(String.format("Take your product (%s)", productName));
        products.remove(productName);
    }

    public int getAvailable() {
        return products.size();
    }
}
