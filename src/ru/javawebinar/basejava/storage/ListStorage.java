package ru.javawebinar.basejava.storage;

import com.sun.istack.internal.Nullable;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListStorage extends AbstractStorage{
    List<Resume> storage = new ArrayList<>();
    public ListStorage(List<Resume> storage) {
        super(storage);
    }

    @Override
    public void update(Resume r) {
        for (int i = 0; i<storage.size(); i++)
        {
            if (storage.get(i).equals(r))
            {
                storage.set(i,r);
            }
        }
    }

    @Override
    @Nullable
    public Resume get(String uuid) {
        for (Resume resume : storage)
        {
            if (resume.equals(new Resume(uuid)))
            {
                return resume;
            }
        }
        return null;
    }

    @Override
    public void delete(String uuid) {
        storage.remove(new Resume(uuid));
    }
}
