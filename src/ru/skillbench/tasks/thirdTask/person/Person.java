package ru.skillbench.tasks.thirdTask.person;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Person {
    private String firstName = "";
    private String middleName = "";
    private String lastName = "";

    /**
     * Задает значения полей по входящей строке. В ней должно быть более 1 слова.
     * Порядок ввода: И.О.Ф.; или И.Ф.; или Ф. Отделяются любыми символами, отличными от букв
     *
     * @param fullName полное имя
     */
    public Person(String fullName) {
        String[] name = fullName.split("[^A-Za-zа-яА-Я]");
        switch (name.length) {
            case 3 -> {
                this.firstName = name[0];
                this.middleName = name[1];
                this.lastName = name[2];
            }
            case 2 -> {
                this.firstName = name[0];
                this.lastName = name[1];
            }
            case 1 -> this.lastName = name[0];
            default -> throw new InputMismatchException();
        }
    }

    /**
     * Задает полям объекта соответствующие параметры, принимаемые на вход
     *
     * @param firstName  имя
     * @param middleName отчество
     * @param lastName   фамилия
     */
    public Person(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    /**
     * @return полное имя
     */
    public String getFullName() {
        if (this.lastName.equals("")) {
            throw new NoSuchElementException();
        }
        return (this.firstName + " " + this.middleName + " " + this.lastName).replace("  ", " ").strip();
    }

}
