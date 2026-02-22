# Lab-Assignment-2-State-Design-Pattern
Laboratory Assignment for State Design Pattern implementation in Java.

# Vending Machine State Management System

This repository implements the **State Design Pattern** to manage the operational lifecycle of a vending machine. By transitioning from conditional logic to a state-based architecture, the system ensures that machine operations are handled cleanly, reducing errors as state complexity grows.

A vending machine's behavior changes based on its current state. This project captures transitions across four primary states: **Idle**, **ItemSelected**, **Dispensing**, and **OutOfOrder**.

### State Behaviors and Restrictions

| Action | Idle State | ItemSelected State | Dispensing State | OutOfOrder State |
| :--- | :--- | :--- | :--- | :--- |
| **Select Item** | **Allowed** | Restricted | Restricted | Restricted |
| **Insert Coin** | Restricted | **Allowed** | Restricted | Restricted |
| **Dispense Item** | Restricted | **Allowed** | Restricted | Restricted |
| **Set Out of Order**| **Allowed** | **Allowed** | Restricted | Restricted |

---

## Implementation Details

### 1. The State Interface (`VendingMachineState`)
Defines a uniform contract for all possible actions. Each concrete state must implement these methods, receiving a reference to the `VendingMachine` context to manipulate its state or inventory:
* `selectItem(VendingMachine machine)`
* `insertCoin(VendingMachine machine)`
* `dispenseItem(VendingMachine machine)`
* `setOutOfOrder(VendingMachine machine)`

### 2. Concrete State Classes
* **IdleState**: The starting state. Allows item selection, which transitions the machine to `ItemSelectedState`.
* **ItemSelectedState**: Allows coin insertion. When dispensing is triggered, it checks inventory: if stock exists, it moves to `DispensingState`; otherwise, it transitions to `OutOfOrderState`.
* **DispensingState**: Handles the delivery of the product. It calls `reduceInventory()` and **automatically** transitions the machine back to `IdleState`.
* **OutOfOrderState**: A terminal state where all operations are disabled and inform the user that the machine is unavailable.

### 3. The Context (`VendingMachine`)
The `VendingMachine` class maintains the machine's internal data (inventory) and a reference to the `currentState`. It delegates all user actions to the state object.

![image](https://github.com/sairarat/State-Design-Pattern/blob/master/State%20Design%20Pattern%20UML.png)
