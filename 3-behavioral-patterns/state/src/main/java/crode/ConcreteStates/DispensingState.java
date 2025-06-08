package crode.ConcreteStates;

import crode.ContextClass.VendingMachine;
import crode.StateInterface.VendingMachineState;

public class DispensingState implements VendingMachineState {

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Wait for dispensing to finish...");
    }

    @Override
    public void selectProduct(VendingMachine machine, String product) {
        System.out.println("Wait for dispensing to finish...");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        String product = machine.getSelectedProduct();
        double price = machine.getProducts().get(product);
        double change = machine.getInsertedMoney() - price;

        System.out.println("Dispensing " + product + "...");
        System.out.println("Product delivered successfully!");

        if (change > 0) {
            System.out.println("Remaining: " + change + " RON");
        }

        // Reset
        machine.setInsertedMoney(0);
        machine.setSelectedProduct("");
        machine.setState(machine.getIdleState());
        System.out.println("Status: Idle");
    }

    @Override
    public void returnMoney(VendingMachine machine) {
        System.out.println("Unable to return money during dispensing...");
    }
}
