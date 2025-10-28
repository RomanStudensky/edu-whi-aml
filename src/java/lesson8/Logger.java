package lesson8;

public class Logger {

    private static Logger instance;

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

class Main {
    public static void main(String[] args) {
        Logger.getInstance().log("Программа запущена!");
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println("Один и тот же объект? " + (logger1 == logger2));
        Logger.getInstance().log("Программа завершена!");
    }
}
