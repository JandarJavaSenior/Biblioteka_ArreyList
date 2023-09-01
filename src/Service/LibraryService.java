package Service;
import Interface.LibraryInterface;
import Model.Database;
import Model.Library;
import java.util.List;

public class LibraryService implements LibraryInterface {
    private Database database;

    public LibraryService(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        List<Library> existingLibraries = database.getLibraries();
        existingLibraries.addAll(libraries);
        return existingLibraries;
    }


    @Override
    public List<Library> getAllLibraries() {
        List<Library> libraries = database.getLibraries();
        return libraries;
    }


    @Override
    public Library getLibraryById(Long id) {
        List<Library> libraries = database.getLibraries();

        for (Library library : libraries) {
            if (library.getId() == (id)) {
                return library;
            }
        }


        throw new IllegalArgumentException("Библиотека с ID " + id + " не найдена");
    }


    @Override
    public Library updateLibrary(Long id, Library updatedLibrary) {
        List<Library> libraries = database.getLibraries();

        for (int i = 0; i < libraries.size(); i++) {
            Library existingLibrary = libraries.get(i);
            if (existingLibrary.getId() == (id)) {
                libraries.set(i, updatedLibrary);
                return updatedLibrary;
            }
        }
        throw new IllegalArgumentException("Библиотека с ID " + id + " не найдена");
    }


    @Override
    public String deleteLibrary(Long id) {
        List<Library> libraries = database.getLibraries();

        for (Library library : libraries) {
            if (library.getId() == (id)) {
                libraries.remove(library);
                return "Библиотека с ID " + id + " удалена успешно";
            }
        }
        return "Библиотека с ID " + id + " не найдена";
    }
}


