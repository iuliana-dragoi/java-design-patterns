package crode.Implementations.Log;

import crode.Interfaces.Logger;

import java.util.Date;

public class ConsoleLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("[LOG] " + new Date() + ": " + message);
    }
}
