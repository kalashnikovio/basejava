/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            } else if (storage[i].toString() == r.toString()) {
                System.out.println("UIDD " + r + " уже существует");
                break;
            }
        }
    }

    Resume get(String uuid) {
        int size = 0;
        int foundElement = 0;

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            }
            size++;
        }
        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                foundElement = i;
            }
        }

        return storage[foundElement];
    }

    void delete(String uuid) {
        int size = 0;

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            }
            size++;
        }

        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                for (int j = i + 1; j <= size; j++) {
                    storage[i] = storage[j];
                    storage[j] = null;
                    i++;
                }
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int size = 0;

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            }
            size++;
        }

        Resume[] storageFill = new Resume[size];
        for (int i = 0; i < storageFill.length; i++) {
            if (storage[i] == null) {
                break;
            }
            storageFill[i] = storage[i];
        }
        return storageFill;
    }

    int size() {
        int size = 0;

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                break;
            }
            size++;
        }
        return size;
    }
}
