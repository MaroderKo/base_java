package ru.javawebinar.basejava.storage;

import com.google.gson.Gson;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

/**
 * gkislin
 * 22.07.2016
 */
public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    public void clear() {
        if (directory.list().length != 0)
        {
            for (String path : directory.list())
            {
                File temp = new File(directory+path);
                temp.delete();
            }
        }
    }

    @Override
    public int size() {
        return directory.list().length;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doUpdate(Resume r, File file) {
        throw new NotImplementedException();
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            file.createNewFile();
            doWrite(r, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    abstract protected void doWrite(Resume r, File file) throws IOException;


    abstract protected Resume doGet(File file);
//    protected void doWrite(Resume r, File file) throws IOException
//    {
//
//        Gson gson = new Gson();
//        String str = gson.toJson(r);
//        file.createNewFile();
//        FileOutputStream fis = new FileOutputStream(file.getPath());
//        ObjectOutputStream oos = new ObjectOutputStream(fis);
//        oos.writeBytes(str);
//        oos.close();
//        fis.close();
//
//    }
//
//    @Override
//    protected Resume doGet(File file) {
//        Gson gson = new Gson();
//        Resume resume = null;
//        try(FileInputStream fis = new FileInputStream(file.getPath()); ObjectInputStream oos = new ObjectInputStream(fis)) {
//            String raw = (String) oos.readObject();
//            resume = gson.fromJson(raw,Resume.class);
//
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return resume;
//
//    }
    @Override
    protected void doDelete(File file) {
        file.delete();
    }

    @Override
    protected List<Resume> doCopyAll() {
        return null;
    }
}
