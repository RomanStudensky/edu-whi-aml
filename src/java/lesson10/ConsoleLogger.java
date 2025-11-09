package lesson10;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger implements Logger {
    private final String name;
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public ConsoleLogger(String name) {
        this.name = name;
    }

    private void log(LogLevel level, String mes) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.printf("%s %s %s : %s%n", timestamp, level, name, mes);
    }

    @Override
    public void infoNew(String mes) {
        log(LogLevel.INFO, mes);
    }

    @Override
    public void debugNew(String mes) {
        log(LogLevel.DEBUG, mes);
    }

    @Override
    public void errorNew(String mes) {
        log(LogLevel.ERROR, mes);
    }
}
