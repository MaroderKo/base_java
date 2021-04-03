package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{
    @Override
    public void clear() {
        Arrays.fill(storage,0,size,null);
        size = 0;
    }

    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        storage[index] = r;
    }

    @Override
    public void save(Resume r) {
        int index = -1;
        for (int i = 0; i < size; i++)
        {
            if (r.compareTo(storage[i]) < 0)
            {
                index = i;
                break;
            }
        }
        if(index == -1)
        {
            storage[size] = r;

        }
        else
        {

            Resume buf = r, buf_new;
            for (int i = index; i<size+1;i++)
            {
                buf_new = storage[i];
                storage[i] = buf;
                buf = buf_new;

            }
        }
        size++;
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1)
        {
            for (int i = index; i<size; i++)
            {
                storage[i] = storage[i+1];
            }
            size--;
        }
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage,0,size);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
