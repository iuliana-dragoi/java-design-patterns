package crode.DocumentManagement.Manager.Documents;

import crode.DocumentManagement.Template.DocumentTemplate;

public class ReportDocument implements DocumentTemplate {

    private String reportId;
    private String title;
    private String author;
    private String dateGenerated;
    private String content;
    private String summary;
    private boolean confidential;

    public ReportDocument() {
        this.reportId = "R-0001";
        this.title = "Default Report";
        this.author = "System";
        this.dateGenerated = "2025-01-01";
        this.content = "Generic report content...";
        this.summary = "Standard summary.";
        this.confidential = false;
    }

    @Override
    public DocumentTemplate clone() {
        ReportDocument clone = new ReportDocument();
        clone.reportId = this.reportId;
        clone.title = this.title;
        clone.author = this.author;
        clone.dateGenerated = this.dateGenerated;
        clone.content = this.content;
        clone.summary = this.summary;
        clone.confidential = this.confidential;
        return clone;
    }

    @Override
    public void customize(String clientName, String date) {
        this.title = title;
        this.dateGenerated = date;
        this.reportId = "R-" + title.hashCode(); // demo
    }

    @Override
    public void print() {
        System.out.println("=== REPORT DOCUMENT ===");
        System.out.println("Report ID: " + reportId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Date: " + dateGenerated);
        System.out.println("Summary: " + summary);
        System.out.println("Content: " + content);
        System.out.println("Confidential: " + confidential);
        System.out.println("========================");
    }
}
