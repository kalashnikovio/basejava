package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        boolean repeat = false;

        if (size == 0) {
            storage[size] = r;
            size++;
        } else {
            int index = getIndex(r.getUuid());
            if (index >= 0) {
                System.out.println("UIDD " + r + " уже существует");
                repeat = true;
            }
            if (!repeat) {
                storage[size] = r;
                size++;
            }
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println("Uuid " + uuid + " не найден");
        }
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Uuid " + uuid + " не найден");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public String update(Resume resume) {
        int index = getIndex(resume.getUuid());
        String uuid = resume.getUuid();
        if (index >= 0) {
            storage[index].setUuid(resume.getUuid() + " upd");
            return "Uidd " + uuid + " обновлен";
        } else {
            System.out.println("Uuid " + uuid + " не найден");
        }
        return "Uidd " + uuid + " не обновлен";
    }
}
