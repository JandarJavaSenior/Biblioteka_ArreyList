package Interface;

import Model.Reader;

import java.util.List;

public interface ReaderInterface {

    void saveReader(Reader reader);
    List<Reader> getAllReaders();

    Reader getReaderById(Long id);

    Reader updateReader(Long id, Reader reader);

    void assignReaderToLibrary(Long readerId,Long libraryId);
}
