public class ItemSelectedState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Item already selected. Please insert coins or dispense.");
    }

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Coin accepted.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        if (machine.getInventory() > 0) {
            machine.setMachineState(new DispensingState());
            machine.getMachineState().dispenseItem(machine);
        } else {
            System.out.println("Out of stock! Setting to Out of Order.");
            machine.setMachineState(new OutOfOrderState());
        }
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is now Out of Order.");
        machine.setMachineState(new OutOfOrderState());
    }
}