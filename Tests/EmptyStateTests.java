import Money.Money;
import org.junit.Test;

import static Money.Money.amount;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class EmptyStateTests {
    VendingMachine machine = new VendingMachine();
    State machineState = new EmptyState(machine);

    @Test(expected = MachineWarning.class)
    public void insertCoinTest() throws MachineWarning {
        machineState.insertCoin(1);
    }

    @Test
    public void insertCoinAmountTest() {
        try {
            machineState.insertCoin(1);
        } catch (MachineWarning e) {
            assertEquals(0.0, amount);
        }
    }

    @Test(expected = MachineWarning.class)
    public void buyTest() throws MachineWarning {
        machineState.buy(1);
    }

    @Test(expected = MachineWarning.class)
    public void dispenseTest() throws MachineWarning {
        machineState.dispense("Coke");
    }

    @Test(expected = MachineWarning.class)
    public void getRemainderTest() throws MachineWarning {
        machineState.getRemainder();
    }

    @Test
    public void getRemainderAmountTest() throws MachineWarning {
        try {
            machineState.getRemainder();
        } catch (MachineWarning e) {
            assertEquals(0.0, amount);
        }
    }

    @Test
    public void addProductTest() throws MachineWarning {
        assertEquals(0, machine.getAvailable());
        machine.addProduct("Coke", new Money(0, 50));
        assertEquals(machine.getAvailable(), 1);
        assertTrue(machine.getMachineState() instanceof NoCoinInsertedState);
    }


}
