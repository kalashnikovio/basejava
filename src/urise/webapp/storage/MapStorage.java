package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage<String> {
    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        if (map.get(uuid) == null) {
            return null;
        } else {
            return uuid;
        }
    }

    @Override
    protected void executeUpdate(Resume r, String searchKey) {
        map.replace(searchKey, r);
    }

    @Override
    protected boolean isExist(String searchKey) {
        return map.containsKey(searchKey);
    }

    @Override
    protected void executeSave(Resume r, String searchKey) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume executeGet(String searchKey) {
        return map.get(searchKey);
    }

    @Override
    protected void executeDelete(String searchKey) {
        map.remove(searchKey);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> doGetCopyAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}
