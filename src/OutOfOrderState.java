public class OutOfOrderState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Machine is Out of Order. Operations disabled.");
    }

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Machine is Out of Order. Coins rejected.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Machine is Out of Order. Cannot dispense.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is already Out of Order.");
    }
}