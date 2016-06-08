import Money.Money;
import Product.Product;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class DispensingStateTests {

    VendingMachine machine = new VendingMachine();
    State machineState = new DispensingState(machine);

    @Test(expected = MachineWarning.class)
    public void insertCoinTest() throws MachineWarning {
        machineState.insertCoin(1);
    }

    @Test(expected = MachineWarning.class)
    public void buyTest() throws MachineWarning {
        machineState.buy(1);
    }

    @Test
    public void dispenseTest1() throws MachineWarning {
        machine.addProduct("Fanta", new Money(0, 77));
        machineState.dispense("Fanta");
        assertTrue(machine.getMachineState() instanceof NoCoinInsertedState);
    }

    @Test(expected = MachineWarning.class)
    public void dispenseTest2() throws MachineWarning {
        Product.available = 0;
        machineState.dispense("");
    }

    @Test
    public void getRemainderTest() throws MachineWarning {
        machineState.getRemainder();
        assertEquals(0.0, Money.amount);
        assertTrue(machine.getMachineState() instanceof NoCoinInsertedState);
    }

    @Test
    public void addProductTest() throws MachineWarning {
        assertEquals(0, machine.getAvailable());
        machine.addProduct("Coke", new Money(0, 50));
        assertEquals(machine.getAvailable(), 1);
        assertTrue(machine.getMachineState() instanceof NoCoinInsertedState);
    }
}
