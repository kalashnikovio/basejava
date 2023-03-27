package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {
//    private static class ResumeComparator implements Comparator<Resume> {
//        @Override
//        public int compare(Resume o1, Resume o2) {
//            return o1.getUuid().compareTo(o2.toString());
//        }
//    }

    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.toString());

    @Override
    protected void deleteUsingIndex(int index) {
        for (int i = index; i < size; i++) {
            storage[i] = storage[i + 1];
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }

    @Override
    protected void saveUsingIndex(int index, Resume r) {
        if (index < 0) {
            index = -(index) - 1;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = r;
    }
}