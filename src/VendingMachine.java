public class VendingMachine {
    private VendingMachineState currentState;
    private int inventory;

    public VendingMachine(int inventory) {
        this.inventory = inventory;
        this.currentState = new IdleState();
    }

    public void setMachineState(VendingMachineState state) {
        this.currentState = state;
    }

    public VendingMachineState getMachineState() {
        return currentState;
    }

    public int getInventory() {
        return inventory;
    }

    public void reduceInventory() {
        if (inventory > 0) inventory--;
    }

    public void selectItem() { currentState.selectItem(this); }
    public void insertCoin() { currentState.insertCoin(this); }
    public void dispenseItem() { currentState.dispenseItem(this); }
    public void setOutOfOrder() { currentState.setOutOfOrder(this); }
}