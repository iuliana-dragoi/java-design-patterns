package crode.StateInterface;

import crode.ContextClass.VendingMachine;

public interface VendingMachineState {
    void insertMoney(VendingMachine machine, double amount);
    void selectProduct(VendingMachine machine, String product);
    void dispenseProduct(VendingMachine machine);
    void returnMoney(VendingMachine machine);
}
