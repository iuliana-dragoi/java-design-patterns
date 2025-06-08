package crode.Handler;

import crode.PurchaseRequest;

public class DirectorHandler extends ApprovalHandler {

    @Override
    public void handleRequest(PurchaseRequest request) {
        if(request.getAmount() < 5000) {
            System.out.println("Director approves request for " +  request.getItem() + " with value of " + request.getAmount() + " RON");
        }
        else if(nextHandler != null) {
            System.out.println("Director redirects request to CEO");
            nextHandler.handleRequest(request);
        }
        else {
            System.out.println("The request cannot be processed!");
        }
    }
}
