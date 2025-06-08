import crode.AbstractTemplateClass.OrderProcessor;
import crode.ConcreteTemplate.CorporateOrderProcessor;
import crode.ConcreteTemplate.InStoreOrderProcessor;
import crode.ConcreteTemplate.OnlineOrderProcessor;

public class Main {

    public static void main(String[] args) {
        System.out.println("🛒 Template Method Pattern - Order Processing\n");

        // Online order
        System.out.println("\n1 ONLINE ORDER");
        OrderProcessor onlineOrder = new OnlineOrderProcessor("ion.popescu@email.com", 250.0);
        onlineOrder.processOrder();

        // In-store order
        System.out.println("\n2 IN-STORE ORDER");
        OrderProcessor inStoreOrder = new InStoreOrderProcessor("Maria Ionescu", true);
        inStoreOrder.processOrder();

        // Corporate order
        System.out.println("\n3 CORPORATE ORDER");
        OrderProcessor corporateOrder = new CorporateOrderProcessor("Tech Solutions SRL", 1500.0, true);
        corporateOrder.processOrder();

        // Small corporate order (no stock check)
        System.out.println("\n4 SMALL CORPORATE ORDER");
        OrderProcessor smallCorporateOrder = new CorporateOrderProcessor("StartUp ABC", 300.0, false);
        smallCorporateOrder.processOrder();
    }
}
