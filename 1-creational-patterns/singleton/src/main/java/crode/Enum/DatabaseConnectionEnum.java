package crode.Enum;

public enum DatabaseConnectionEnum {

    INSTANCE;

    public void executeQuery(String query) {
        System.out.println("Executing: " + query);
    }
}
