package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
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
            for (int i = 0; i < size; i++) {
                if (storage[i].toString() == r.toString()) {
                    System.out.println("UIDD " + r + " уже существует");
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                storage[size] = r;
                size++;
            }
        }
    }

    public Resume get(String uuid) {
        boolean check = checkUuid(uuid);
        if (check) {
            for (int i = 0; i < size; i++) {
                if (storage[i].toString() == uuid) {
                    return storage[i];
                }
            }
        }
        return null;
    }

    public void delete(String uuid) {
        boolean check = checkUuid(uuid);
        if (check) {
            for (int i = 0; i < size; i++) {
                if (storage[i].toString() == uuid) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                    break;
                }
            }
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

    private boolean checkUuid(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                return true;
            }
        }
        System.out.print("Uidd " + uuid + " не найден ");
        return false;
    }

    public String update(Resume resume) {
        boolean check = checkUuid(resume.getUuid());
        String uuid = resume.getUuid();
        if (check) {
            for (int i = 0; i < size; i++) {
                if (storage[i].toString() == uuid) {
                    storage[i].setUuid(resume.getUuid() + " upd");
                    return "Uidd " + uuid + " обновлен";
                }
            }
        }
        return "Uidd " + uuid + " не обновлен";
    }
}
