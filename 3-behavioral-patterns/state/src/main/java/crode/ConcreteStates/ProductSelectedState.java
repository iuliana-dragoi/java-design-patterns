package crode.ConcreteStates;

import crode.ContextClass.VendingMachine;
import crode.StateInterface.VendingMachineState;

public class ProductSelectedState implements VendingMachineState {

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Add more " + amount + " RON");
        machine.setInsertedMoney(machine.getInsertedMoney() + amount);
    }

    @Override
    public void selectProduct(VendingMachine machine, String product) {
        System.out.println("Change selection to " + product);
        selectProduct(machine, product); // Re-validate
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        machine.setState(machine.getDispensingState());
        machine.dispenseProduct(); // Delegate to DispensingState
    }

    @Override
    public void returnMoney(VendingMachine machine) {
        System.out.println("I return " + machine.getInsertedMoney() + " RON");
        machine.setInsertedMoney(0);
        machine.setSelectedProduct("");
        machine.setState(machine.getIdleState());
        System.out.println("State: Idle");
    }
}