package crode.DocumentManagement.Template;

public interface DocumentTemplate extends Cloneable {

    DocumentTemplate clone();
    void customize(String clientName, String date);
    void print();
}
