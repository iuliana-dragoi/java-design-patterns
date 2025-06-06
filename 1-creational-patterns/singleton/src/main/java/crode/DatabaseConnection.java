package crode;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private String connectionString;

    private DatabaseConnection() {
        connectionString = "jdbc:mysql://localhost:3306/mydb";
        System.out.println("Database connection established");
    }

    public static synchronized DatabaseConnection getInstance() {
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void executeQuery(String query) {
        System.out.println("Executing query: " + query);
    }

    public String getConnectionString() {
        return connectionString;
    }
}
