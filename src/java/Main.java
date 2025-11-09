import lesson1.Car;
import lesson10.LoggerFactory;
import lesson10.LoggerFactoryType;
import lesson2.BankAccount;
import lesson3.Animal;
import lesson4.Circle;
import lesson4.Rectangle;
import lesson4.Shape;
import lesson5.Driver;
import lesson5.Programmer;
import lesson5.Workable;
import lesson6.NewBank;
import lesson7.Book;
import lesson7.Library;
import lesson8.Logger;
import lesson9.Task;
import lesson9.TaskManager;

import java.util.List;
import java.util.Scanner;

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
                Car c = new Car("BMW", "C2", "2024");
                c.displayInfo();
            }

            @Override
            public void describe() {
                System.out.println("Задание 1");
            }
        });

        taskManager.addTask(2, new Task() {
            @Override
            public void run() {
                BankAccount ba = new BankAccount();

                ba.setAccountNumber("ЦА16545/165-5");
                ba.setOwnerName("");
                ba.setBalance(10000.00);

                ba.displayInfo();

                ba.deposit(500.00);
                ba.withdraw(2500.00);
            }

            @Override
            public void describe() {
                System.out.println("Задание 2");
            }
        });

        taskManager.addTask(3, new Task() {
            @Override
            public void run() {
                Animal.Dog d = new Animal.Dog("Juna", 2);
                Animal.Cat c = new Animal.Cat("Jull", 5);

                d.makeSound();
                c.makeSound();
            }

            @Override
            public void describe() {
                System.out.println("Задание 3");
            }
        });

        taskManager.addTask(4, new Task() {
            @Override
            public void run() {
                Shape rectangle = new Rectangle(4.0, 6.0);
                rectangle.calculateArea();

                Shape circle = new Circle(5.0);
                circle.calculateArea();
            }

            @Override
            public void describe() {
                System.out.println("Задание 4");
            }
        });

        taskManager.addTask(5, new Task() {
            @Override
            public void run() {
                Workable[] work = new Workable[2];

                work[0] = new Programmer();
                work[1] = new Driver();

                for(Workable w : work){
                    w.work();
                }
            }

            @Override
            public void describe() {
                System.out.println("Задание 5");
            }
        });

        taskManager.addTask(6, new Task() {
            @Override
            public void run() {
                NewBank ba = new NewBank();

                ba.setAccountNumber("ЦА16545/165-5");
                ba.setOwnerName("");
                ba.setBalance(10000.00);

                ba.displayInfo();

                try {
                    ba.deposit(500.00);
                    ba.withdraw(2500.00);
                } catch (IllegalArgumentException e) {
                    System.out.println("Произошла ошибка: " + e.getMessage());
                }

                System.out.println("\n--- Тестирование исключений ---");


                try {
                    ba.withdraw(-100.00); // Эта операция должна вызвать исключение
                } catch (IllegalArgumentException e) {
                    System.out.println("Поймано исключение: " + e.getMessage());
                }


                System.out.println("\n--- Итоговое состояние счета ---");
                ba.displayInfo();
            }

            @Override
            public void describe() {
                System.out.println("Задание 6");
            }
        });

        taskManager.addTask(7, new Task() {
            @Override
            public void run() {
                Library library = new Library();

                Book book1 = new Book("Война и мир", "Лев Толстой");
                Book book2 = new Book("Горе от ума", "Александр Грибоедов");
                Book book3 = new Book("Герой нашего времени", "Михаил Лермонтов");
                Book book4 = new Book("1984", "Джордж Оруэлл");

                System.out.println("=== ДОБАВЛЕНИЕ КНИГ ===");
                library.addBook(book1);
                library.addBook(book2);
                library.addBook(book3);
                library.addBook(book4);

                System.out.println("\n=== ОТОБРАЖЕНИЕ ВСЕХ КНИГ ===");
                library.displayBooks();

                System.out.println("\n=== УДАЛЕНИЕ КНИГИ ===");
                library.removeBook("Преступление и наказание");

                System.out.println("\n=== ПОПЫТКА УДАЛИТЬ НЕСУЩЕСТВУЮЩУЮ КНИГУ ===");
                library.removeBook("Несуществующая книга");

                System.out.println("\n=== ОТОБРАЖЕНИЕ КНИГ ПОСЛЕ УДАЛЕНИЯ ===");
                library.displayBooks();

                System.out.println("\n=== ИНФОРМАЦИЯ О БИБЛИОТЕКЕ ===");
                System.out.println("Всего книг в библиотеке: " + library.getBookCount());
            }

            @Override
            public void describe() {
                System.out.println("Задание 7");
            }
        });

        taskManager.addTask(8, new Task() {
            @Override
            public void run() {
                Logger.getInstance().log("Программа запущена!");
                Logger logger1 = Logger.getInstance();
                Logger logger2 = Logger.getInstance();
                System.out.println("Один и тот же объект? " + (logger1 == logger2));
                Logger.getInstance().log("Программа завершена!");
            }

            @Override
            public void describe() {
                System.out.println("Задание 8");
            }
        });

        taskManager.addTask(9, new Task() {
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

        taskManager.addTask(10, new Task() {
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

        taskManager.addTask(11, new Task() {
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


        taskManager.addTask(12, new Task() {
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

        taskManager.addTask(13, new Task() {
            @Override
            public void run() {
                lesson10.Logger logger1 = LoggerFactory.getLoggerNew("Les10");
                logger1.infoNew("Приложение запущено");
                logger1.debugNew("Отладочная информация");
                logger1.errorNew("Произошла ошибка");

                // Переключаем на файловое логгирование
                LoggerFactory.initFactory(LoggerFactoryType.FILE);

                lesson10.Logger logger2 = LoggerFactory.getLoggerNew("Les10");
                logger2.infoNew("Это сообщение будет записано в файл");

                lesson10.Logger logger3 = LoggerFactory.getLoggerNew(Main.class);
                logger3.debugNew("Логгер для класса Main");

                // Проверка, что логгеры кэшируются
                lesson10.Logger logger4 = LoggerFactory.getLoggerNew("Les10");
                System.out.println("logger2 и logger4 один и тот же объект: " + (logger2 == logger4));

            }

            @Override
            public void describe() {
                System.out.println("Демонстрация паттерна Singleton с классом Logger");
            }
        });
    }
}