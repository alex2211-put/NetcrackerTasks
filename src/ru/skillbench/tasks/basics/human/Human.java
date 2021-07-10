package ru.skillbench.tasks.basics.human;

import java.util.Calendar;

public class Human {
    private final String lastName;
    private final String firstName;
    private final Calendar birthDate;
    private final Address address;

    public Human(String firstName, String lastName, Calendar birthDate, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public Address getAddress() {
        return address;
    }

    static public Human findLastName(String lastName) {
        return null;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + ": " + this.address;
    }
}
