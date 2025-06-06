package crode.Enum;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public enum LoggerEnum {

    INSTANCE;

    private final List<String> logs = new ArrayList<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    LoggerEnum() {
        System.out.println("LoggerEnum instance created!");
    }

    public void log(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = "[" + timestamp + "] " + message;
        logs.add(logEntry);
        System.out.println(logEntry);
    }

    public void showAllLogs() {
        System.out.println("=== ALL LOGS ===");
        logs.forEach(System.out::println);
    }

    public int getLogCount() {
        return logs.size();
    }
}
