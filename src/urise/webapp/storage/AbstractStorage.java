package urise.webapp.storage;

import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object searchKey(String uuid);

    protected abstract void executeUpdate(Resume r, Object searchKey);

    protected abstract boolean exists(Object searchKey);

    protected abstract void executeSave(Resume r, Object searchKey);

    protected abstract Resume executeGet(Object searchKey);

    protected abstract void executeDelete(Object searchKey);

    public void update(Resume r) {
        Object searchKey = getExistsKey(r.getUuid());
        executeUpdate(r, searchKey);
    }

    public void save(Resume r) {
        Object searchKey = getNotExistsKey(r.getUuid());
        executeSave(r, searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = getExistsKey(uuid);
        return executeGet(searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getExistsKey(uuid);
        executeDelete(searchKey);
    }

    private Object getExistsKey(String uuid) {
        Object Key = searchKey(uuid);
        if (!exists(Key)) {
            throw new NotExistStorageException(uuid);
        }
        return Key;
    }

    private Object getNotExistsKey(String uuid) {
        Object Key = searchKey(uuid);
        if (exists(Key)) {
            throw new ExistStorageException(uuid);
        }
        return Key;
    }
}
