package urise.webapp.storage;

import urise.webapp.exception.ExistStorageException;
import urise.webapp.exception.NotExistStorageException;
import urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());
    protected abstract SK getSearchKey(String uuid);

    protected abstract void doUpdate(Resume r, SK searchKey);

    protected abstract boolean isExist(SK searchKey);

    protected abstract void doSave(Resume r, SK searchKey);

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doDelete(SK searchKey);

    protected abstract List<Resume> doGetCopyAll();

    public void update(Resume r) {
        LOG.info("Update " + r);
        SK searchKey = getExistingSearchKey(r.getUuid());
        doUpdate(r, searchKey);
    }

    public void save(Resume r) {
        LOG.info("Save " + r);
        SK searchKey = getNotExistingSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = getExistingSearchKey(uuid);
        return doGet(searchKey);
    }

    public void delete(String uuid) {
        LOG.info("Update " + uuid);
        SK searchKey = getExistingSearchKey(uuid);
        doDelete(searchKey);
    }

    private SK getExistingSearchKey(String uuid) {
        SK Key = getSearchKey(uuid);
        if (!isExist(Key)) {
            LOG.warning("Uuid " + uuid + " не найден");
            throw new NotExistStorageException(uuid);
        }
        return Key;
    }

    private SK getNotExistingSearchKey(String uuid) {
        SK Key = getSearchKey(uuid);
        if (isExist(Key)) {
            LOG.warning("Uuid " + uuid + " не найден");
            throw new ExistStorageException(uuid);
        }
        return Key;
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> list = doGetCopyAll();
        Collections.sort(list);
        return  list;
    }
}
