package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
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

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    final public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("Uuid " + resume.getUuid() + " не найден");
        }
    }

    final public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    final public void save(Resume r) {
        int index = getIndex(r.getUuid());

        if (size == STORAGE_LIMIT) {
            System.out.println("Достигнуто максимальное количество UUID");
        } else if (index >= 0) {
            System.out.println("UIDD " + r + " уже существует");
        } else {
            saveUsingIndex(index, r);
            size++;
        }
    }

    final public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            deleteUsingIndex(index);
            size--;
        } else {
            System.out.println("Uuid " + uuid + " не найден");
        }
    }

    protected abstract void deleteUsingIndex(int index);

    protected abstract int getIndex(String uuid);

    protected abstract void saveUsingIndex(int index, Resume r);
}