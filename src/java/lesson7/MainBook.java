package lesson7;
import java.util.ArrayList;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" - " + author;
    }
}

class Library {
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

public class MainBook {
    public static void main(String[] args) {
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
}