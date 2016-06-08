import Money.Money;
import Product.Product;

public class DispensingState implements State {

    VendingMachine machine;

    public DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(double coin) throws MachineWarning {
        throw new MachineWarning("Please wait");
    }

    @Override
    public void buy(double price) throws MachineWarning {
        throw new MachineWarning("Please wait");
    }

    @Override
    public void dispense(String productName) throws MachineWarning {
        if (Product.available > 0) {
            machine.dispenseProduct(productName);
            machine.setMachineState(machine.getNoCoinInsertedState());
        } else {
            machine.setMachineState(machine.getEmptyState());
            throw new MachineWarning("Sorry. Not available");
        }
    }

    @Override
    public void getRemainder() throws MachineWarning {
        Money.returnMoney();
        System.out.println("Take your remainder");
        machine.setMachineState(machine.getNoCoinInsertedState());
    }

}
