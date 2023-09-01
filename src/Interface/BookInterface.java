package Interface;

import Model.Book;

import java.util.List;

public interface BookInterface {
    Book saveBook(Long libraryId, Book book);
    List<Book> getAllBooks(Long libraryId);

    Book getBookById(Long libraryId, Long bookId);

    String deleteBook(Long libraryId,Long bookId);

    void clearBooksByLibraryId(Long libraryId);
}
