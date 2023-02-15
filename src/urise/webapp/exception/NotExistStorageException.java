package urise.webapp.exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Uuid " + uuid + " не найден", uuid);
    }
}
