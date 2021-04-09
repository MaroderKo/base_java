package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;

public abstract class AbstractStorage implements Storage {
    Collection<Resume > storage;

    public AbstractStorage(Collection storage)
    {
        this.storage = storage;
    }
    public void clear() {
        storage.clear();
    }

    public void save(Resume r) {
        storage.add(r);
    }

    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    public int size() {
        return storage.size();
    }
}
