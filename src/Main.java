import Enam.Gender;
import Enam.Genre;
import Model.Book;
import Model.Database;
import Model.Library;
import Model.Reader;
import Service.BookService;
import Service.LibraryService;
import Service.ReaderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book( "The Hobbit", "J.R.R. Tolkien", Genre.FANTASY);
        Book book2 = new Book( "1984", "George Orwell", Genre.SCIENCE_FICTION);
        Book book3 = new Book( "Sherlock Holmes", "Arthur Conan Doyle", Genre.MYSTERY);
        Book book4 = new Book( "Pride and Prejudice", "Jane Austen", Genre.ROMANCE);
        Book book5 = new Book( "The Road", "Cormac McCarthy", Genre.POST_APOCALYPTIC);

        Book book6 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", Genre.FANTASY);
        Book book7 = new Book("Dune", "Frank Herbert", Genre.SCIENCE_FICTION);
        Book book8 = new Book("Gone Girl", "Gillian Flynn", Genre.MYSTERY);
        Book book9 = new Book("Outlander", "Diana Gabaldon", Genre.ROMANCE);
        Book book10 = new Book("The Stand", "Stephen King", Genre.POST_APOCALYPTIC);
        List<Book> books = new ArrayList<>(List.of(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10));
        List<Book> books1 = new ArrayList<>(List.of(book1, book2, book3, book4, book5));
        List<Book> books2 = new ArrayList<>(List.of(book6, book7, book8, book9, book10));


        Reader reader1 = new Reader( "John Doe", "john@example.com", "+123456789", Gender.MALE);
        Reader reader2 = new Reader("Jane Smith", "jane@example.com", "+987654321", Gender.FEMALE);
        Reader reader3 = new Reader( "Alex Johnson", "alex@example.com", "+555555555", Gender.MALE);
        Reader reader4 = new Reader("Emily Brown", "emily@example.com", "+111111111", Gender.FEMALE);
        Reader reader5 = new Reader( "Sam Wilson", "sam@example.com", "+999999999", Gender.MALE);

        Reader reader6 = new Reader("Ava Miller", "ava@example.com", "+444444444", Gender.FEMALE);
        Reader reader7 = new Reader("Ethan Davis", "ethan@example.com", "+777777777", Gender.MALE);
        Reader reader8 = new Reader("Olivia Garcia", "olivia@example.com", "+666666666", Gender.FEMALE);
        Reader reader9 = new Reader("Liam Martinez", "liam@example.com", "+222222222", Gender.MALE);
        Reader reader10 = new Reader("Sophia Brown", "sophia@example.com", "+888888888", Gender.FEMALE);
        List<Reader> readers = new ArrayList<>(List.of(reader1, reader2, reader3, reader4, reader5, reader6, reader7, reader8, reader9, reader10));
        List<Reader> readers1 = new ArrayList<>(List.of(reader1, reader2, reader3, reader4, reader5));
        List<Reader> readers2 = new ArrayList<>(List.of(reader6, reader7, reader8, reader9, reader10));

        Library library1 = new Library("Central", "1 Main St",books1,readers1);
        Library library2 = new Library("Library", "3 Main St",books2,readers2);
        List<Library> libraries = new ArrayList<>(List.of(library1,library2));
        Database database = new Database(books,readers,libraries);

        BookService bookService = new BookService(database);
        ReaderService readerService = new ReaderService(database);
        LibraryService libraryService = new LibraryService(database);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите вариант:");
            System.out.println("1 - Book");
            System.out.println("2 - Reader");
            System.out.println("3 - Library");
            System.out.println("0 - Выйти");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Выход из программы.");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Выбран вариант Book");
                    switch (choice) {
                        case 1:
                            while (true) {
                                System.out.println("Выберите действие для Book:");
                                System.out.println("1 - Сохранить книгу");
                                System.out.println("2 - Получить все книги");
                                System.out.println("3 - Получить книгу по ID");
                                System.out.println("4 - Удалить книгу");
                                System.out.println("5 - Очистить книги по ID библиотеки");
                                System.out.println("0 - Вернуться назад");

                                int bookChoice = scanner.nextInt();

                                if (bookChoice == 0) {
                                    break;
                                }

                                switch (bookChoice) {
                                    case 1:
                                        System.out.println("Обработка сохранения книги");
                                        System.out.println("Введи в какую id");
                                        Long saveBookid = scanner.nextLong();
                                        System.out.println(bookService.saveBook(saveBookid, book2));
                                        break;
                                    case 2:
                                        System.out.println("Обработка получения всех книг");
                                        System.out.println(bookService.getAllBooks(1L));
                                        break;
                                    case 3:
                                        System.out.println("Обработка получения книги по ID");
                                        System.out.println(bookService.getBookById(1L, 2L));
                                        break;
                                    case 4:
                                        System.out.println("Обработка удаления книги");
                                        System.out.println("ID LIBRARY");
                                        Long idlal = scanner.nextLong();
                                        System.out.println("ID BOOK");
                                        Long idbook = scanner.nextLong();
                                        System.out.println(bookService.deleteBook(idlal, idbook));
                                        break;
                                    case 5:
                                        System.out.println("Обработка очистки книг по ID библиотеки");
                                        bookService.clearBooksByLibraryId(1L);
                                        System.out.println("Книги в библиотеке успешно очищены.");
                                        break;
                                    default:
                                        System.out.println("Недопустимый выбор для Book.");
                                        break;
                                }
                            }
                            break;
                case 2:
                    System.out.println("Выбран вариант Reader");
                    while (true) {
                        System.out.println("Выберите действие для Reader:");
                        System.out.println("1 - Сохранить читателя");
                        System.out.println("2 - Получить всех читателей");
                        System.out.println("3 - Получить читателя по ID");
                        System.out.println("4 - Обновить читателя");
                        System.out.println("5 - Назначить читателя в библиотеку");
                        System.out.println("0 - Вернуться назад");

                        int readerChoice = scanner.nextInt();

                        if (readerChoice == 0) {
                            break;
                        }

                        switch (readerChoice) {
                            case 1:
                                System.out.println("Обработка сохранения читателя");
                                readerService.saveReader(reader2);
                                System.out.println("Читатель успешно сохранен.");
                                break;
                            case 2:
                                System.out.println("Обработка получения всех читателей");
                                System.out.println(readerService.getAllReaders());
                                break;
                            case 3:
                                System.out.println("Обработка получения читателя по ID");
                                System.out.println(readerService.getReaderById(4L));
                                break;
                            case 4:
                                System.out.println("Обработка обновления читателя");
                                System.out.println(readerService.updateReader(1L, reader6));
                                break;
                            case 5:
                                System.out.println("Обработка назначения читателя в библиотеку");
                                readerService.assignReaderToLibrary(1L, 2L);
                                System.out.println("Читатель назначен в библиотеку.");
                                break;
                            default:
                                System.out.println("Недопустимый выбор для Reader.");
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Выбран вариант Library");
                    while (true) {
                        System.out.println("Выберите действие для Library:");
                        System.out.println("1 - Сохранить библиотеку");
                        System.out.println("2 - Получить все библиотеки");
                        System.out.println("3 - Получить библиотеку по ID");
                        System.out.println("4 - Обновить библиотеку");
                        System.out.println("5 - Удалить библиотеку");
                        System.out.println("0 - Вернуться назад");

                        int libraryChoice = scanner.nextInt();

                        if (libraryChoice == 0) {
                            break;
                        }

                        switch (libraryChoice) {
                            case 1:
                                System.out.println("Обработка сохранения библиотеки");
                                libraryService.saveLibrary(libraries);
                                System.out.println("Библиотека успешно сохранена.");
                                break;
                            case 2:
                                System.out.println("Обработка получения всех библиотек");
                                System.out.println(libraryService.getAllLibraries());
                                break;
                            case 3:
                                System.out.println("Обработка получения библиотеки по ID");
                                System.out.println(libraryService.getLibraryById(1L));
                                break;
                            case 4:
                                System.out.println("Обработка обновления библиотеки");
                                libraryService.updateLibrary(1L, library2);
                                System.out.println("Библиотека успешно обновлена.");
                                break;
                            case 5:
                                System.out.println("Обработка удаления библиотеки");
                                libraryService.deleteLibrary(2L);
                                System.out.println("Библиотека успешно удалена.");
                                break;
                            default:
                                System.out.println("Недопустимый выбор для Library.");
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("Недопустимый выбор");
                    break;
            }
        }

        scanner.close();




    }
    }
}
