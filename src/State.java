public interface State {

    public void insertCoin(double coin) throws MachineWarning;

    public void buy(double price) throws MachineWarning;

    public void dispense(String productName) throws MachineWarning;

    public void getRemainder() throws MachineWarning;
}
