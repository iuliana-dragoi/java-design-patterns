package crode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {

    private static volatile Logger instance;
    private List<String> logs;
    private DateTimeFormatter formatter;

    private Logger() {
        logs = new ArrayList<>();
        formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        System.out.println("Logger instance created!");
    }

    public static Logger getInstance() {
        if(instance == null) {
            synchronized (Logger.class) {
                if(instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
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
