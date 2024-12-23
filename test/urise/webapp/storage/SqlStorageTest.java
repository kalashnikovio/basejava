package urise.webapp.storage;

import urise.webapp.Config;
import urise.webapp.storage.serializer.XmlStreamSerializer;

public class SqlStorageTest extends AbstractStorageTest {
    public SqlStorageTest() {
        super(Config.get().getStorage());
    }
}
