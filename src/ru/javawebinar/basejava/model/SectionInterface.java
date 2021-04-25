package ru.javawebinar.basejava.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public interface SectionInterface {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    class GetType
    void Print();
    void Edit() throws Throwable;
    void Clear();
}
