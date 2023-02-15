package urise.webapp.exception;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Uuid " + uuid + " уже существует", uuid);
    }
}
