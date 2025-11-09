package lesson10;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements Logger {
    private final String name;
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String LOG_FILE = "application.log";

    public FileLogger(String name) {
        this.name = name;
    }

    private void log(LogLevel level, String mes) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logMessage = String.format("%s %s %s : %s%n", timestamp, level, name, mes);

        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(logMessage);
        } catch (IOException e) {
            System.err.println("Ошибка записи в лог-файл: " + e.getMessage());
        }
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
