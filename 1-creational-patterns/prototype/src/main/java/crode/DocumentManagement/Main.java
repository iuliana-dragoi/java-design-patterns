package crode.DocumentManagement;

import crode.DocumentManagement.Manager.Documents.InvoiceDocument;
import crode.DocumentManagement.Manager.DocumentManager;
import crode.DocumentManagement.Template.DocumentTemplate;

public class Main {

    public static void main(String[] args) {

        DocumentManager manager = new DocumentManager();
        manager.addTemplate("invoice", new InvoiceDocument());

        DocumentTemplate invoiceForAlice = manager.getClonedTemplate("invoice");
        invoiceForAlice.customize("Alice", "2025-06-06");
        invoiceForAlice.print();

        DocumentTemplate invoiceForBob = manager.getClonedTemplate("invoice");
        invoiceForBob.customize("Bob", "2025-06-07");
        invoiceForBob.print();
    }
}
