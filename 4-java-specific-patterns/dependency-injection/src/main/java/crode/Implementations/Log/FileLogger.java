package crode.Implementations.Log;

import crode.Interfaces.Logger;

import java.util.Date;

public class FileLogger implements Logger {

    private String filename;

    public FileLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(String message) {
        System.out.println("[FILE-LOG to " + filename + "] " + new Date() + ": " + message);
    }

}
