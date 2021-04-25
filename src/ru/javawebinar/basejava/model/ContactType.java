package ru.javawebinar.basejava.model;

public enum ContactType {
    TELEPHONE("Телефонный номер"),
    SKYPE("Скайп"),
    MAIL("Почта"),
    LINKEDIN("Линкедин"),
    GITHUB("Гитхаб"),
    STUCKOVERFLOW("Стэковерфлов"),
    HOMEPAGE("Домашняя страница");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
