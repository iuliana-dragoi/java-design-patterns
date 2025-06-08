package crode.Handler;

import crode.PurchaseRequest;

public class ManagerHandler extends ApprovalHandler {

    @Override
    public void handleRequest(PurchaseRequest request) {
        if(request.getAmount() < 1000) {
            System.out.println("Manager approves request for " +  request.getItem() + " with value of " + request.getAmount() + " RON");
        }
        else if(nextHandler != null) {
            System.out.println("Manager redirects request to Director");
            nextHandler.handleRequest(request);
        }
        else {
            System.out.println("The request cannot be processed!");
        }
    }
}
