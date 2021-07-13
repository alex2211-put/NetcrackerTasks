package ru.skillbench.tasks.secondTask.color;

public class Main {
    public static void main(String[] args) {
        BlackImpl black = new BlackImpl();
        System.out.println(black.isBlack());
        black.setColor("yellow");
        System.out.println(black.isBlack());
        black.setColor("black");
        System.out.println(black.isBlack());
    }
}
