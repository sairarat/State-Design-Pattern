public class DispensingState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Currently dispensing. Please wait.");
    }

    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Currently dispensing. Cannot accept coins.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Dispensing item...");
        machine.reduceInventory();
        machine.setMachineState(new IdleState());
        System.out.println("Dispensing complete. Returning to Idle state.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Cannot change to Out of Order while dispensing.");
    }
}