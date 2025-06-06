package crode;

import crode.Enum.LoggerEnum;

public class Main {

    public static void main(String[] args) {
        testLogger();
        testDatabaseConnection();
        testThreadSafety();
        performanceTest();

        LoggerEnum.INSTANCE.log("TEST");
        LoggerEnum.INSTANCE.log("TEST");
        LoggerEnum.INSTANCE.log("TEST");
    }

    private static void testLogger() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("logger1 == logger2? " + (logger1 == logger2));
        System.out.println("HashCode logger1: " + logger1.hashCode());
        System.out.println("HashCode logger2: " + logger2.hashCode());

        logger1.log("Application starts");
        logger2.log("User logs in");
        logger1.log("Operation complete Successfully");

        System.out.println("Total number logs: " + logger1.getLogCount());
        logger2.showAllLogs();

        System.out.println("------------------------");
    }

    private static void testDatabaseConnection() {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        System.out.println("db1 == db2? " + (db1 == db2));

        db1.executeQuery("SELECT * FROM users");
        db2.executeQuery("INSERT INTO logs VALUES ('test')");
        System.out.println("Connection string: " + db1.getConnectionString());

        System.out.println("------------------------");
    }

    private static void testThreadSafety() {

        Thread thead1 = new Thread(() -> {
            Logger logger = Logger.getInstance();
            logger.log("Log from Thread 1");
        });

        Thread thead2 = new Thread(() -> {
            Logger logger = Logger.getInstance();
            logger.log("Log from Thread 2");
        });

        Thread thead3 = new Thread(() -> {
            Logger logger = Logger.getInstance();
            logger.log("Log from Thread 3");
        });

        thead1.start();
        thead2.start();
        thead3.start();

        try {
            thead1.join();
            thead2.join();
            thead3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal log count: " + Logger.getInstance().getLogCount());

        System.out.println("------------------------");
    }

    private static void performanceTest() {
        final int ITERATIONS = 1000000;

        // Test DatabaseConnection (synchronized method)
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            DatabaseConnection.getInstance();
        }
        long syncTime = System.nanoTime() - startTime;

        // Test Logger (double-checked locking)
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            Logger.getInstance();
        }
        long doubleCheckedTime = System.nanoTime() - startTime;

        System.out.println("Synchronized method: " + syncTime / 1_000_000 + " ms");
        System.out.println("Double-checked locking: " + doubleCheckedTime / 1_000_000 + " ms");
        System.out.println("Difference: " + (syncTime - doubleCheckedTime) / 1_000_000 + " ms");

        if (syncTime > doubleCheckedTime) {
            System.out.println("Double-checked locking is much faster!");
        }

        System.out.println("------------------------");
    }
}
