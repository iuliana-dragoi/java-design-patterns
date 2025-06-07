package crode.DocumentManagement.Manager.Documents;

import crode.DocumentManagement.Template.DocumentTemplate;

public class ContractDocument implements DocumentTemplate {

    private String contractId;
    private String clientName;
    private String providerName;
    private String startDate;
    private String endDate;
    private String terms;
    private boolean signed;
    private String signatureClient;
    private String signatureProvider;

    public ContractDocument() {
        this.contractId = "C-0001";
        this.clientName = "Default Client";
        this.providerName = "Provider SRL";
        this.startDate = "2025-01-01";
        this.endDate = "2025-12-31";
        this.terms = "Standard terms and conditions apply.";
        this.signed = false;
    }

    @Override
    public DocumentTemplate clone() {
        ContractDocument clone = new ContractDocument();
        clone.contractId = this.contractId;
        clone.clientName = this.clientName;
        clone.providerName = this.providerName;
        clone.startDate = this.startDate;
        clone.endDate = this.endDate;
        clone.terms = this.terms;
        clone.signed = this.signed;
        clone.signatureClient = this.signatureClient;
        clone.signatureProvider = this.signatureProvider;
        return clone;
    }

    @Override
    public void customize(String clientName, String startDate) {
        this.clientName = clientName;
        this.startDate = startDate;
        this.contractId = "C-" + clientName.hashCode(); // demo
    }

    @Override
    public void print() {
        System.out.println("=== CONTRACT DOCUMENT ===");
        System.out.println("Contract ID: " + contractId);
        System.out.println("Client: " + clientName);
        System.out.println("Provider: " + providerName);
        System.out.println("Start: " + startDate + ", End: " + endDate);
        System.out.println("Terms: " + terms);
        System.out.println("Signed: " + signed);
        System.out.println("Client Signature: " + (signatureClient != null ? signatureClient : "-"));
        System.out.println("Provider Signature: " + (signatureProvider != null ? signatureProvider : "-"));
        System.out.println("==========================");
    }
}
