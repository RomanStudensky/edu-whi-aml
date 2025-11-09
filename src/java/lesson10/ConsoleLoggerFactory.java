package lesson10;

class ConsoleLoggerFactory implements ILoggerFactory {
    @Override
    public Logger getLoggerNew(String name) {
        return new ConsoleLogger(name);
    }
}

class FileLoggerFactory implements ILoggerFactory {
    @Override
    public Logger getLoggerNew(String name) {
        return new FileLogger(name);
    }
}