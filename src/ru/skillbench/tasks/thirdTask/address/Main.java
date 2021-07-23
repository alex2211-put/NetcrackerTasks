package ru.skillbench.tasks.thirdTask.address;

public class Main {
    public static void main(String[] args) {
        Address address = new Address();
        address = address.getFromStringAll("Страна; Регион, Город, Улица, Дом. Корпус, Квартира");
        System.out.println(address);
    }
}
