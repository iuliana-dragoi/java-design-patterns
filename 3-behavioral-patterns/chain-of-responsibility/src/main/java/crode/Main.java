package crode;

import crode.Handler.ApprovalHandler;
import crode.Handler.CeoHandler;
import crode.Handler.DirectorHandler;
import crode.Handler.ManagerHandler;

public class Main {

    public static void main(String[] args) {

        ApprovalHandler manager = new ManagerHandler();
        ApprovalHandler director = new DirectorHandler();
        ApprovalHandler ceo = new CeoHandler();

        manager.setNext(director);
        director.setNext(ceo);

        PurchaseRequest[] requests = {
            new PurchaseRequest("Laptop", 800, "Ion"),
            new PurchaseRequest("Server", 3000, "Maria"),
            new PurchaseRequest("Car", 25000, "Alex"),
            new PurchaseRequest("Plane", 100000, "Bogdan")
        };

        for(PurchaseRequest request: requests) {
            System.out.println("\n--- Process request ---");
            manager.handleRequest(request);
        }
    }
}
