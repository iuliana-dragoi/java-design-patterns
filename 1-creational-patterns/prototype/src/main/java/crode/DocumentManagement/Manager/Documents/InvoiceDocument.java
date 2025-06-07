package crode.DocumentManagement.Manager.Documents;

import crode.DocumentManagement.Template.DocumentTemplate;

public class InvoiceDocument implements DocumentTemplate {

    private String clientName;
    private String date;
    private final String type = "INVOICE";

    public InvoiceDocument() {
        this.clientName = "Default Client";
        this.date = "YYY-MM-DD";
    }

    @Override
    public DocumentTemplate clone() {
        InvoiceDocument clone = new InvoiceDocument();
        clone.clientName = this.clientName;
        clone.date = this.date;
        return clone;
    }

    @Override
    public void customize(String clientName, String date) {
        this.clientName = clientName;
        this.date = date;
    }

    @Override
    public void print() {
        System.out.println("== " + type + " ==");
        System.out.println("Client: " + clientName);
        System.out.println("Date: " + date);
    }
}
