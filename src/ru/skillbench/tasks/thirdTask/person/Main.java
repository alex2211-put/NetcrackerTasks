package ru.skillbench.tasks.thirdTask.person;

public class Main {
    public static void main(String[] args){
        Person person = new Person("Alexander Putin");
        System.out.println(person.getFullName());
        Person person2 = new Person("Alexander Leonidovich Putin");
        System.out.println(person2.getFullName());
    }
}
