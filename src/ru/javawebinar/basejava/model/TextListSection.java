package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public class TextListSection implements SectionInterface  {

    List<String> list;

    public TextListSection() {
        list = new ArrayList<>();
    }

    public TextListSection(List<String> list) {
        this.list = list;
    }

    @Override
    public void Print() {
        System.out.println(list.toString());
    }

    @Override
    public void Edit() throws Throwable {
        System.out.println("Редактирование: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1)+list.get(i));
        }
        System.out.println("Выбор: ");
        System.out.println("1: Добавить строку");
        System.out.println("2: Изменить строку");
        System.out.println("3: Удалить строку");
        System.out.println("4: Выйти");
        int ans = Integer.parseInt(reader.readLine());
        switch (ans){
            case 1:
                list.add("");
                break;
            case 2:
                System.out.print("Введите индекс редактируемой строки: ");
                int index = Integer.parseInt(reader.readLine());
                if (index > 0 && index < list.size())
                {
                    StringEdit(index);
                }
                break;
            case 3:
                System.out.print("Введите индекс удаляемой строки: ");
                int index1 = Integer.parseInt(reader.readLine());
                if (index1 > 0 && index1 < list.size())
                {
                    list.remove(index1);
                }
                break;
            default:
                return;

        }
    }

    @Override
    public void Clear() {
        list.clear();
    }

    public void StringEdit(int index) throws Throwable{

        System.out.print("Введите новую строку: ");
        String New = reader.readLine();
        if (New != null)
        {
            list.set(index,New);
        }
        System.out.println("Значение обновлено!");
    }
}
