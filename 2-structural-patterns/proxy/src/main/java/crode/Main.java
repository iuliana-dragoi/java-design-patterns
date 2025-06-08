package crode;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== User normal ===");
        FileDownloader userDownloader = new ProxyFileDownloader("USER");
        userDownloader.downloadFile("document.pdf");
        userDownloader.downloadFile("document.pdf"); // From cache
        userDownloader.downloadFile("virus.exe"); // Blocked

        System.out.println("\n=== Admin ===");
        FileDownloader adminDownloader = new ProxyFileDownloader("ADMIN");
        adminDownloader.downloadFile("system.exe"); // Allowed
    }
}
