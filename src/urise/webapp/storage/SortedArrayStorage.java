package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());

        if (size == STORAGE_LIMIT) {
            System.out.println("Достигнуто максимальное количество UUID");
        } else if (index >= 0) {
            System.out.println("UIDD " + r + " уже существует");
        } else {
            storage[size] = r;
            size++;
            sortStorage();
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            sortStorage();
        } else {
            System.out.println("Uuid " + uuid + " не найден");
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    public void sortStorage() {
        for (int k = 1; k < size; k++) {
            Resume newElement = storage[k];
            int index;
            index = Arrays.binarySearch(storage, 0, k, newElement);
            if (index < 0) {
                index = -(index) - 1;
            }
            System.arraycopy(storage, index, storage, index + 1, k - index);
            storage[index] = newElement;
        }
    }
}