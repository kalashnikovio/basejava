import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
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
        int foundElement = -1;

        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                foundElement = i;
            }
        }
        if (foundElement >= 0) {
            return storage[foundElement];
        } else {
            return storage[size + 1];
        }
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
