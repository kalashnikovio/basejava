package urise.webapp.storage;

import urise.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {
    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void executeUpdate(Resume r, Object uuid) {
        map.put((String) uuid, r);
    }

    @Override
    protected boolean isExist(Object uuid) {
        return map.containsKey((String) uuid);
    }

    @Override
    protected void executeSave(Resume r, Object uuid) {
        map.put((String) uuid, r);
    }

    @Override
    protected Resume executeGet(Object uuid) {
        return map.get((String) uuid);
    }

    @Override
    protected void executeDelete(Object uuid) {
        map.remove((String) uuid);
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
