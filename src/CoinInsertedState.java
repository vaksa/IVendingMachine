import Money.Money;

public class CoinInsertedState implements State {

    VendingMachine machine;

    public CoinInsertedState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(double coin) throws MachineWarning {
        if ((coin == 1) || (coin == 2)) {
            Money.amount += coin;           //add Euros
        } else {
            Money.amount += (coin / 100);   //add Cents
        }
        System.out.println("Coin was inserted. Balance is " + Money.amount + " euros");
        machine.setMachineState(machine.getCoinInsertedState());
    }

    @Override
    public void buy(double price) throws MachineWarning {
        if (Money.amount >= price) {
            machine.setMachineState(machine.getDispensingState());
            Money.amount -= price;
            getRemainder();
        } else {
            throw new MachineWarning("Not enough money. Please, insert more coins");
        }
    }

    @Override
    public void dispense(String productName) throws MachineWarning {
        throw new MachineWarning("Invalid Operation");
    }

    @Override
    public void getRemainder() throws MachineWarning {
        Money.returnMoney();
        System.out.println("Take your remainder");
        machine.setMachineState(machine.getNoCoinInsertedState());
    }

}
