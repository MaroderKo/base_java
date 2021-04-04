package ru.javawebinar.basejava.storage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest {
    private Storage storage = new ArrayStorage();

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    @Before
    public void setUp() throws Exception {

        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @After
    public void Down() throws Exception
    {
        storage.clear();
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0,storage.size());
    }

    @Test
    public void update() throws Exception {
        storage.save(new Resume("test"));
        storage.update(new Resume("test"));
        Assert.assertEquals(new Resume("test"), storage.get("test"));
    }

    @Test
    public void getAll() throws Exception {
        Resume[] test = storage.getAll();
        storage.save(new Resume("test"));
        storage.delete("test");
        Assert.assertArrayEquals(test, storage.getAll());
    }

    @Test
    public void save() throws Exception {
        storage.save(new Resume("test"));
        Assert.assertEquals(new Resume("test"),storage.get("test"));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete("uuid1");
        storage.get("uuid1");
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(new Resume("uuid1"), storage.get("uuid1"));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}