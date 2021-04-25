package ru.javawebinar.basejava.model;

public class TextSection  implements SectionInterface {

    String text;

    public TextSection() {
        text = "";
    }

    public String getText() {
        return text;
    }

    public TextSection(String text) {
        this.text = text;
    }

    @Override
    public void Print() {
        System.out.println(text);
    }

    @Override
    public void Edit() throws Throwable{
        System.out.print("Введите новую ссылку: ");
        String New = reader.readLine();
        if (New != null)
        {
            text = New;
        }
        System.out.println("Значение обновлено!");
    }

    @Override
    public void Clear() {
        text = "";
    }
}
