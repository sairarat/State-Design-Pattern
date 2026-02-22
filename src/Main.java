public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine(1);

        System.out.println("--- Test 1: Successful Transaction ---");
        machine.selectItem();   // Idle -> ItemSelected
        machine.insertCoin();   // Remains in ItemSelected
        machine.dispenseItem(); // ItemSelected -> Dispensing -> Idle

        System.out.println("\n--- Test 2: Out of Stock Transition ---");
        machine.selectItem();   // Idle -> ItemSelected
        machine.dispenseItem(); // Inventory is 0, goes to OutOfOrder

        System.out.println("\n--- Test 3: Out of Order Behavior ---");
        machine.insertCoin();   // Should be disallowed
        machine.selectItem();   // Should be disallowed
    }
}