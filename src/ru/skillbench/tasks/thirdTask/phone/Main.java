package ru.skillbench.tasks.thirdTask.phone;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone("89175655655");
        System.out.println(phone);
        Phone phone1 = new Phone("+79175655655");
        System.out.println(phone1);
        Phone phone2 = new Phone("+104289652211");
        System.out.println(phone2);
    }
}
