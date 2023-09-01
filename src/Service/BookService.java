package Service;

import Interface.BookInterface;
import Model.Book;
import Model.Database;
import Model.Library;

import java.util.List;

public class BookService implements BookInterface {
    private Database database;

    public BookService(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public Book saveBook(Long libraryId, Book book) {
        List<Library> libraries = database.getLibraries();

        for (Library library : libraries) {
            if (library.getId() == libraryId) {
                long maxId = 0;

                // Находим максимальный существующий ID в библиотеке
                for (Book existingBook : library.getBooks()) {
                    maxId = Math.max(maxId, existingBook.getId());
                }

                // Генерируем новый уникальный ID для книги
                long newBookId = maxId + 1;
                book.setId(newBookId);

                // Добавляем книгу в список библиотеки
                library.getBooks().add(book);

                return book;
            }
        }

        throw new IllegalArgumentException("Библиотека с ID " + libraryId + " не найдена");
    }



    @Override
    public List<Book> getAllBooks(Long libraryId) {
        List<Library> libraries = database.getLibraries();

        for (Library library : libraries) {
            if (library.getId() == libraryId) {
                return library.getBooks();
            }
        }

        throw new IllegalArgumentException("Библиотека с ID " + libraryId + " не найдена");
    }


    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        List<Library> libraries = database.getLibraries();

        for (Library library : libraries) {
            if (library.getId() == libraryId) {
                List<Book> books = library.getBooks();

                for (Book book : books) {
                    if (book.getId() == bookId) {
                        return book;
                    }
                }

                return null;
            }
        }

        return null;
    }


    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        List<Library> libraries = database.getLibraries();

        for (Library library : libraries) {
            if (library.getId() == libraryId) {
                List<Book> books = library.getBooks();

                for (int i = 0; i < books.size(); i++) {
                    if (books.get(i).getId() == bookId) {
                        books.remove(i);
                        reassignBookIds(books); // Перегенерировать ID после удаления
                        return "Книга с ID " + bookId + " удалена успешно";
                    }
                }
                return "Книга с ID " + bookId + " не найдена в библиотеке";
            }
        }
        return "Библиотека с ID " + libraryId + " не найдена";
    }

    // Метод для перегенерации ID книг
    private void reassignBookIds(List<Book> books) {
        for (int i = 0; i < books.size(); i++) {
            books.get(i).setId (i + 1);
        }
    }




    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        List<Library> libraries = database.getLibraries();

        for (Library library : libraries) {
            if (library.getId() == libraryId) {
                library.getBooks().clear();
                return;
            }
        }
        throw new IllegalArgumentException("Библиотека с ID " + libraryId + " не найдена");
    }

}
