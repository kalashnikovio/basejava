package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void deleteUsingIndex(int index) {
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void saveUsingIndex(int index, Resume r) {
        storage[size] = r;
        size++;
    }
}
