package crode;

import crode.ContextClass.VendingMachine;

public class Main {

    public static void main(String[] args) {

        VendingMachine machine = new VendingMachine();

        System.out.println("=== Vending Machine ===");
        machine.showStatus();

        // Trying to select without money
        System.out.println("\n--- Trying to select without money ---");
        machine.selectProduct("Coca-Cola");

        // Inserting money
        System.out.println("\n--- Inserting money ---");
        machine.insertMoney(2.0);

        // Trying to select an expensive product
        System.out.println("\n--- Selecting expensive product ---");
        machine.selectProduct("Chips");

        // Adding more money
        System.out.println("\n--- Adding money ---");
        machine.insertMoney(2.5);

        // Selecting the product
        System.out.println("\n--- Selecting product ---");
        machine.selectProduct("Chips");

        // Dispense the product
        System.out.println("\n--- Dispensing ---");
        machine.dispenseProduct();

        System.out.println("\n--- Final Status ---");
        machine.showStatus();
    }
}
