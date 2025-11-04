package lesson9;

import java.util.HashMap;
import java.util.Map;

public class TaskManager {
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