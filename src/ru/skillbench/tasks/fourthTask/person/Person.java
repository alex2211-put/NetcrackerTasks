package ru.skillbench.tasks.fourthTask.person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private final LocalDate birthDate;

    public Person(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Задание даты рождения с помощью строки
     *
     * @param birthDate строка с датой
     */
    public Person(String birthDate) {
        birthDate = birthDate.replaceAll("[^0-9]", "-");
        this.birthDate = LocalDate.parse(birthDate);
    }

    /**
     * Вывод даты рождения по формату
     *
     * @param format формат вывода даты
     * @return строка в нужном формате
     */
    public String outFromFormat(String format) {
        return birthDate.format(DateTimeFormatter.ofPattern(format));
    }

    @Override
    public String toString() {
        return "Person{" +
                "birthDate=" + birthDate +
                '}';
    }

    public static void main(String[] args) {
        Person person = new Person("2019.03.29");
        System.out.println(person);
        System.out.println(person.outFromFormat("dd-MM-yyyy"));
        System.out.println(person.outFromFormat("dd-MMM-yyyy"));
        System.out.println(person.outFromFormat("dd-MM-yy"));
    }
}
