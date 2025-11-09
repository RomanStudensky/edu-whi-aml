package lesson10;

import java.util.HashMap;
import java.util.Map;

public class LoggerFactory {
    private static ILoggerFactory factory = new ConsoleLoggerFactory();
    private static Map<String, Logger> loggers = new HashMap<>();

    public static void initFactory(LoggerFactoryType type) {
        switch (type) {
            case CONSOLE:
                factory = new ConsoleLoggerFactory();
                break;
            case FILE:
                factory = new FileLoggerFactory();
                break;
            default:
                throw new IllegalArgumentException("Неизвестный тип фабрики: " + type);
        }
        // Очищаем кэш логгеров при смене фабрики
        loggers.clear();
    }

    public static Logger getLoggerNew(String name) {
        return loggers.computeIfAbsent(name, factory::getLoggerNew);
    }

    public static Logger getLoggerNew(Class<?> clazz) {
        return getLoggerNew(clazz.getName());
    }
}
