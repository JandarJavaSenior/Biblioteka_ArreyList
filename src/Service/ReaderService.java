package Service;

import Interface.ReaderInterface;
import Model.Database;
import Model.Library;
import Model.Reader;

import java.util.List;

public class ReaderService implements ReaderInterface {
    private Database database;

    public ReaderService(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public void saveReader(Reader reader) {
        List<Reader> readers = database.getReaders();
        readers.add(reader);
        System.out.println("Книга добавлена!");
    }


    @Override
    public List<Reader> getAllReaders() {
        List<Reader> readers = database.getReaders();
        return readers;
    }


    @Override
    public Reader getReaderById(Long id) {
        List<Reader> readers = database.getReaders();

        for (Reader reader : readers) {
            if (reader.getId()==(id)) {
                return reader;
            }
        }
        throw new IllegalArgumentException("Читатель с ID " + id + " не найден");
    }


    @Override
    public Reader updateReader(Long id, Reader updatedReader) {
        List<Reader> readers = database.getReaders();

        for (int i = 0; i < readers.size(); i++) {
            Reader existingReader = readers.get(i);
            if (existingReader.getId()==(id)) {
                readers.set(i, updatedReader);
                return updatedReader;
            }
        }
        throw new IllegalArgumentException("Читатель с ID " + id + " не найден");
    }


    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        List<Reader> readers = database.getReaders();
        List<Library> libraries = database.getLibraries();

        Reader readerToAssign = null;
        Library libraryToAssign = null;

        for (Reader reader : readers) {
            if (reader.getId()==(readerId)) {
                readerToAssign = reader;
                break;
            }
        }

        for (Library library : libraries) {
            if (library.getId()==(libraryId)) {
                libraryToAssign = library;
                break;
            }
        }

        if (readerToAssign != null && libraryToAssign != null) {
            libraryToAssign.getReaders().add(readerToAssign);
        } else {
            throw new IllegalArgumentException("Читатель с ID " + readerId
                    + " или библиотека с ID " + libraryId + " не найдены");
        }
    }

}
