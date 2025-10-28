package lesson9;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public interface Task {
    void run();
    void describe();
}

class TaskManager{
    private Map<Integer, Task> tasks;

    public TaskManager() {
        this.tasks = new HashMap<>();
    }

    public void addTask(Integer number, Task task) {
        tasks.put(number, task);
    }

    public void runTaskByNumber(Integer number) {
        Task task = tasks.get(number);
        if (task != null) {
            System.out.println("\n=== Задание " + number + " ===");
            task.describe();
            System.out.println("--- Выполнение ---");
            task.run();
            System.out.println("--- Завершено ---\n");
        } else {
            System.out.println("Задание с номером " + number + " не найдено!");
        }
    }

    public void showAllTasks() {
        System.out.println("\n=== Доступные задания ===");
        for (Integer number : tasks.keySet()) {
            System.out.print(number + " - ");
            tasks.get(number).describe();
        }
        System.out.println("0 - Выход");
    }
}

class Main {
    public static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        initTasks();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            taskManager.showAllTasks();
            System.out.print("Выберите номер задания: ");

            try {
                choice = sc.nextInt();

                if (choice != 0) {
                    taskManager.runTaskByNumber(choice);
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода! Введите число.");
                sc.nextLine();
                choice = -1;
            }

        } while (choice != 0);

        System.out.println("Программа завершена.");
        sc.close();
    }

    public static void initTasks() {
        Scanner sc = new Scanner(System.in);
        taskManager.addTask(1, new Task() {
            @Override
            public void run() {
                System.out.println("Выполнение калькулятора");
                System.out.println("Введите левый и правый операнд");
                int a = sc.nextInt(), b = sc.nextInt();
                System.out.println(a + " + " + b + " = " + (a + b));
                System.out.println(a + " - " + b + " = " + (a - b));
                System.out.println(a + " * " + b + " = " + (a * b));
                System.out.println(a + " / " + b + " = " + (a / b));
            }

            @Override
            public void describe() {
                System.out.println("Простой калькулятор");
            }
        });

        taskManager.addTask(2, new Task() {
            @Override
            public void run() {
                System.out.println("Работа со строками...");
                System.out.println("Введите текст");
                String text = sc.nextLine();
                System.out.println("Исходная строка: " + text);
                System.out.println("Длина строки: " + text.length());
                System.out.println("В верхнем регистре: " + text.toUpperCase());
                System.out.println("В нижнем регистре: " + text.toLowerCase());

                System.out.println("Введите слово которое хотите заменить");
                String findWord = sc.nextLine();
                System.out.println("Введите слово на которое хотите заменить");
                String replaceWord = sc.nextLine();
                System.out.println("Замена " + findWord +" на " + replaceWord  + ": " + text.replace(findWord, replaceWord));
            }

            @Override
            public void describe() {
                System.out.println("Операции со строками");
            }
        });

        taskManager.addTask(3, new Task() {
            @Override
            public void run() {
                System.out.println("Работа с массивами...");
                int[] numbers = {1, 2, 7, 4, 5, 3};
                System.out.print("Исходный массив: ");
                for (int num : numbers) {
                    System.out.print(num + " ");
                }
                System.out.println();

                int sum = 0;
                int max = numbers[0];
                for (int num : numbers) {
                    sum += num;
                    if (num > max) max = num;
                }

                System.out.println("Сумма элементов: " + sum);
                System.out.println("Максимальный элемент: " + max);
                System.out.println("Среднее значение: " + (double)sum / numbers.length);
            }

            @Override
            public void describe() {
                System.out.println("Операции с массивами - сумма, максимум, среднее");
            }
        });

        taskManager.addTask(4, new Task() {
            @Override
            public void run() {
                System.out.println("Демонстрация паттерна Singleton...");
                Logger.getInstance().log("Первое сообщение");
                Logger.getInstance().log("Второе сообщение");
                Logger.getInstance().log("Третье сообщение");

                // Проверка, что это действительно Singleton
                Logger logger1 = Logger.getInstance();
                Logger logger2 = Logger.getInstance();
                System.out.println("logger1 == logger2: " + (logger1 == logger2));
            }

            @Override
            public void describe() {
                System.out.println("Демонстрация паттерна Singleton с классом Logger");
            }
        });
    }
}

class Logger {
    private static Logger instance;

    private Logger() {}

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