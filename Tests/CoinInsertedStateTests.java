import Money.Money;
import Product.Product;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CoinInsertedStateTests {

    VendingMachine machine = new VendingMachine();
    State machineState = new CoinInsertedState(machine);

    @Test
    public void insertCoinTest() throws MachineWarning {
        machineState.insertCoin(1);
        assertEquals(1.0, Money.amount);
        machineState.insertCoin(2);
        assertEquals(3.0, Money.amount);
        machineState.insertCoin(5);
        assertEquals(3.05, Money.amount);
        machineState.insertCoin(10);
        assertEquals(3.15, Money.amount);
        machineState.insertCoin(20);
        assertEquals(3.35, Money.amount);
        machineState.insertCoin(50);
        assertEquals(3.85, Money.amount);
        assertTrue(machine.getMachineState() instanceof CoinInsertedState);
    }

    @Test
    public void buyTest1() throws MachineWarning {
        Money.amount = 2;
        machineState.buy(1);
        assertTrue(machine.getMachineState() instanceof NoCoinInsertedState);
    }

    @Test(expected = MachineWarning.class)
    public void buyTest2() throws MachineWarning {
        Money.amount = 0;
        machineState.buy(1);
    }

    @Test(expected = MachineWarning.class)
    public void dispenseTest() throws MachineWarning {
        machineState.dispense("Coke");
    }

    @Test
    public void getRemainderTest() throws MachineWarning {
        machineState.getRemainder();
        assertEquals(0.0, Money.amount);
        assertTrue(machine.getMachineState() instanceof NoCoinInsertedState);
    }

    @Test
    public void addProductTest() throws MachineWarning {
        assertEquals(0, Product.available);
        machine.addProduct("Coke", new Money(0, 50));
        assertEquals(1, Product.available);
        assertTrue(machine.getMachineState() instanceof NoCoinInsertedState);
    }
}
