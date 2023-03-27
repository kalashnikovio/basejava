import urise.webapp.model.Resume;
import urise.webapp.storage.SortedArrayStorage;

/**
 * Test for your urise.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final SortedArrayStorage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        String uuid = "uuid1";
        Resume r1 = new Resume(uuid);
        uuid = "uuid2";
        Resume r2 = new Resume(uuid);
        uuid = "uuid3";
        Resume r3 = new Resume(uuid);

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("UPD Uuid: ");
        ARRAY_STORAGE.update(r1);

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
