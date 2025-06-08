package crode.ConcreteStates;

import crode.ContextClass.VendingMachine;
import crode.StateInterface.VendingMachineState;

public class IdleState implements VendingMachineState {

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Enter " + amount + " RON");
        machine.setInsertedMoney(amount);
        machine.setState(machine.getHasMoneyState());
        System.out.println("Status: Money entered");
    }

    @Override
    public void selectProduct(VendingMachine machine, String product) {
        System.out.println("Please insert money first!");
    }

    @Override
    public void dispenseProduct(VendingMachine machine) {
        System.out.println("There are no products to dispense!");
    }

    @Override
    public void returnMoney(VendingMachine machine) {
        System.out.println("There are no money to return!");
    }
}