package crode.ContextClass;

import crode.ConcreteStates.DispensingState;
import crode.ConcreteStates.HasMoneyState;
import crode.ConcreteStates.IdleState;
import crode.ConcreteStates.ProductSelectedState;
import crode.StateInterface.VendingMachineState;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private VendingMachineState idleState;
    private VendingMachineState hasMoneyState;
    private VendingMachineState productSelectedState;
    private VendingMachineState dispensingState;

    private VendingMachineState currentState;
    private double insertedMoney = 0;
    private String selectedProduct = "";
    private Map<String, Double> products;

    public VendingMachine() {
        // States Initialization
        idleState = new IdleState();
        hasMoneyState = new HasMoneyState();
        productSelectedState = new ProductSelectedState();
        dispensingState = new DispensingState();

        currentState = idleState;

        // Products Initialization
        products = new HashMap<>();
        products.put("Coca-Cola", 2.5);
        products.put("Snickers", 3.0);
        products.put("Water", 1.5);
        products.put("Chips", 4.0);
    }

    // Delegation at the current state
    public void insertMoney(double amount) {
        currentState.insertMoney(this, amount);
    }

    public void selectProduct(String product) {
        currentState.selectProduct(this, product);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct(this);
    }

    public void returnMoney() {
        currentState.returnMoney(this);
    }

    // Getters and setters for state
    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public VendingMachineState getIdleState() { return idleState; }
    public VendingMachineState getHasMoneyState() { return hasMoneyState; }
    public VendingMachineState getProductSelectedState() { return productSelectedState; }
    public VendingMachineState getDispensingState() { return dispensingState; }

    // Getters and setters for date
    public double getInsertedMoney() { return insertedMoney; }
    public void setInsertedMoney(double money) { this.insertedMoney = money; }

    public String getSelectedProduct() { return selectedProduct; }
    public void setSelectedProduct(String product) { this.selectedProduct = product; }

    public Map<String, Double> getProducts() { return products; }

    public void showStatus() {
        System.out.println("Money entered: " + insertedMoney + " RON");
        System.out.println("Selected product: " + (selectedProduct.isEmpty() ? "None" : selectedProduct));
        System.out.println("Available products: " + products.keySet());
    }
}
