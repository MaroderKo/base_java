package ru.javawebinar.basejava.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class URLSection implements SectionInterface {

    String URL;

    public URLSection(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    public URLSection() {
        URL = "";
    }

    @Override
    public void Print() {
        System.out.println(URL);
    }

    @Override
    public void Edit() throws Throwable{
        System.out.print("Введите новую ссылку: ");
        String New = reader.readLine();
        if (New != null)
        {
            URL = New;
        }
        System.out.println("Значение обновлено!");
    }

    @Override
    public void Clear() {
        URL = "";
    }
}
