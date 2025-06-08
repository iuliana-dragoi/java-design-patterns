package crode.Handler;

import crode.PurchaseRequest;

public class CeoHandler extends ApprovalHandler {

    @Override
    public void handleRequest(PurchaseRequest request) {
        if (request.getAmount() <= 50000) {
            System.out.println("CEO approves request for " +  request.getItem() + " with value of " + request.getAmount() + " RON");
        } else {
            System.out.println("CEO rejects the request - the amount is too big: " + request.getAmount());
        }
    }
}
