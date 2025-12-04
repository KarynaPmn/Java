package org.example;

import java.util.concurrent.locks.Lock;

public class Logger {
    private static Logger _instance;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

    private Logger() { }

    public static Logger getInstance() {
        if (_instance == null) {
            synchronized (Logger.class) {
                if (_instance == null) {
                    _instance = new Logger();
                }
            }
        }
        return _instance;
    }

    public void DisplayLog(String log) {
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK + log + ANSI_RESET + "\n");
    }

    public void DisplayLogError(String log) {
        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + log + ANSI_RESET + "\n");
    }
}
