package urise.webapp.storage;

import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.exception.StorageException;
import urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public List<Resume> doGetCopyAll() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    final public void doUpdate(Resume r, Integer index) {
        storage[index] = r;
    }

    final public Resume doGet(Integer index) {
        return storage[index];
    }

    final public void doSave(Resume r, Integer index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            saveUsingIndex(index, r);
            size++;
        }
    }

    final public void doDelete(Integer index) {
        deleteUsingIndex(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }

    protected abstract void deleteUsingIndex(int index);

    protected abstract Integer getSearchKey(String uuid);

    protected abstract void saveUsingIndex(int index, Resume r);
}