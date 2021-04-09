package ru.javawebinar.basejava.storage;

import org.junit.After;
import org.junit.Before;
import ru.javawebinar.basejava.model.Resume;

public class ArrayStorageTest extends AbstractArrayStorageTest{

    public ArrayStorageTest()
    {
        super(new ArrayStorage());
    }
}