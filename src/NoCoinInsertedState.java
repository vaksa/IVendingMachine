public class NoCoinInsertedState implements State {

    VendingMachine machine;

    public NoCoinInsertedState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(double coin) throws MachineWarning {
        System.out.println("Coin was inserted");
        machine.setMachineState(machine.getCoinInsertedState());
    }

    @Override
    public void buy(double price) throws MachineWarning {
        throw new MachineWarning("Insert coin, please");
    }

    @Override
    public void dispense(String productName) throws MachineWarning {
        throw new MachineWarning("Invalid Operation. No coins");
    }

    @Override
    public void getRemainder() throws MachineWarning {
        throw new MachineWarning("Invalid Operation. Nothing was inserted");
    }


}
