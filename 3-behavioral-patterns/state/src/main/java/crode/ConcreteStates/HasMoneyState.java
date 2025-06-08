package crode.ConcreteStates;

import crode.ContextClass.VendingMachine;
import crode.StateInterface.VendingMachineState;

public class HasMoneyState implements VendingMachineState {

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Add more " + amount + " RON");
        machine.setInsertedMoney(machine.getInsertedMoney() + amount);
        System.out.println("Total: " + machine.getInsertedMoney() + " RON");
    }

    @Override
    public void selectProduct(VendingMachine machine, String product) {
        if (!machine.getProducts().containsKey(product)) {
            System.out.println("The product " + product + " does not exist!");
            return;
        }

        double price = machine.getProducts().get(product);
        if (machine.getInsertedMoney() >= price) {
            System.out.println("Select " + product + " (price: " + price + " RON)");
            machine.setSelectedProduct(product);
            machine.setState(machine.getProductSelectedState());
            System.out.println("State: Product selected");
        } else {
            System.out.println("Insufficient money! Needed: " + price + " RON, you have: " +
                    machine.getInsertedMoney() + " RON");
        }
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        System.out.println("Select a product first!");
    }

    @Override
    public void returnMoney(VendingMachine machine) {
        System.out.println("Returning " + machine.getInsertedMoney() + " RON");
        machine.setInsertedMoney(0);
        machine.setState(machine.getIdleState());
        System.out.println("State: Waiting");
    }
}