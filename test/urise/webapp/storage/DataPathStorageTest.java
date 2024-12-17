package urise.webapp.storage;

import urise.webapp.storage.serializer.DataStreamSerializer;
import urise.webapp.storage.serializer.ObjectStreamSerializer;

public class DataPathStorageTest extends AbstractStorageTest {
    public DataPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new DataStreamSerializer()));
    }
}
