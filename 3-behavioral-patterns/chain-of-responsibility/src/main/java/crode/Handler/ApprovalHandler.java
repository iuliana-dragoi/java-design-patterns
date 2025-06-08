package crode.Handler;

import crode.PurchaseRequest;

public abstract class ApprovalHandler {

    protected ApprovalHandler nextHandler;

    public void setNext(ApprovalHandler handler) {
        this.nextHandler = handler;
    }

    public abstract void handleRequest(PurchaseRequest request);
}
