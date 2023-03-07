package urise.webapp.storage;

import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object searchKey(String uuid);

    protected abstract void executeUpdate(Resume r, Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void executeSave(Resume r, Object searchKey);

    protected abstract Resume executeGet(Object searchKey);

    protected abstract void executeDelete(Object searchKey);

    public void update(Resume r) {
        Object searchKey = getExistingSearchKey(r.getUuid());
        executeUpdate(r, searchKey);
    }

    public void save(Resume r) {
        Object searchKey = getNotExistingSearchKey(r.getUuid());
        executeSave(r, searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = getExistingSearchKey(uuid);
        return executeGet(searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistingSearchKey(uuid);
        executeDelete(searchKey);
    }

    private Object getExistingSearchKey(String uuid) {
        Object Key = searchKey(uuid);
        if (!isExist(Key)) {
            throw new NotExistStorageException(uuid);
        }
        return Key;
    }

    private Object getNotExistingSearchKey(String uuid) {
        Object Key = searchKey(uuid);
        if (isExist(Key)) {
            throw new ExistStorageException(uuid);
        }
        return Key;
    }
}
