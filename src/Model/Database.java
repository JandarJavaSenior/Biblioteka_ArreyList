package Model;

import java.util.List;

public class Database {
    private List<Book>books;
    private List<Reader>readers;
    private List<Library>libraries;

    public Database(List<Book> books, List<Reader> readers, List<Library> libraries) {
        this.books = books;
        this.readers = readers;
        this.libraries = libraries;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

}
