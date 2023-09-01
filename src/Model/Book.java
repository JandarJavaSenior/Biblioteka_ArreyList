package Model;

import Enam.Genre;

public class Book {
    private long id;
    private String name;
    private String author;
    private Genre genre;
    private static long idd = 1;

    public Book(String name, String author, Genre genre) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.id = idd++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +'\n' +
                "name='" + name + '\n' +
                "author='" + author + '\n' +
                "genre=" + genre + '\n' ;
    }
}
