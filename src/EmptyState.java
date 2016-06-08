import Money.Money;

public class EmptyState implements State {

    VendingMachine machine;

    public EmptyState(VendingMachine machine) {
        this.machine =  machine;
    }

    @Override
    public void insertCoin(double coin) throws MachineWarning{
        Money.returnMoney();
        throw new MachineWarning("Sorry. Not available");
    }

    @Override
    public void buy(double price) throws MachineWarning{
        throw new MachineWarning("Invalid Action");
    }

    @Override
    public void dispense(String productName) throws MachineWarning{
        throw new MachineWarning("Invalid Action");
    }

    @Override
    public void getRemainder() throws MachineWarning{
       throw new MachineWarning("Invalid Action");
    }

}
