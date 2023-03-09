package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        if (map.get(uuid) == null) {
            return null;
        } else {
            return uuid;
        }
    }

    @Override
    protected void executeUpdate(Resume r, Object searchKey) {
        map.replace(searchKey.toString(), r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey(searchKey);
    }

    @Override
    protected void executeSave(Resume r, Object searchKey) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume executeGet(Object searchKey) {
        return map.get(searchKey);
    }

    @Override
    protected void executeDelete(Object searchKey) {
        map.remove(searchKey);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
