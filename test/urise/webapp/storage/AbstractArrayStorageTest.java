package urise.webapp.storage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.exception.StorageException;
import urise.webapp.model.Resume;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        storage.clear();
        try {
            for (int i = 0; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("name" + i));
            }
        } catch (StorageException exception) {
            throw new StorageException("Достигнуто максимальное количество UUID", "" );
        }
        storage.save(new Resume("Over"));
    }
}