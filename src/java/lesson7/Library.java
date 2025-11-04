package lesson7;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;  //Динамический массив который будет хранить только Book объекты

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Книга добавлена: " + book);
    }


    //books.get(i) - получаем книгу по индексу
    //books.get(i).getTitle() - получаем название книги
    //.equalsIgnoreCase(title) - сравнение без учета регистра
    public void removeBook(String title) {
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                Book removedBook = books.remove(i);
                System.out.println("Книга удалена: " + removedBook);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Книга с названием \"" + title + "\" не найдена.");
        }
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста.");
            return;
        }

        System.out.println("\nСписок книг в библиотеке:");
        System.out.println("-------------------------");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
        System.out.println("-------------------------");
    }

    public int getBookCount() {
        return books.size();
    }
}
