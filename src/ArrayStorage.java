/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        for (int i = 0; i < size; i++) {
                storage[i] = null;
        }
    }

    void save(Resume r) {

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
            if (repeat == false) {
                storage[size] = r;
                size++;
            }
        }
    }

    Resume get(String uuid) {

        int foundElement = 0;

        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                foundElement = i;
            }
        }

        return storage[foundElement];
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                for (int j = i + 1; j <= size; j++) {
                    storage[i] = storage[j];
                    storage[j] = null;
                    i++;
                }
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
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
        return size;
    }
}
