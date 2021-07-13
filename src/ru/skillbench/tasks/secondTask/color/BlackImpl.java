package ru.skillbench.tasks.secondTask.color;

public class BlackImpl implements Black{
    private String color = "";
    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String  isBlack() {
        return color.equals("black") ? "It's black" : "it isn't black";
    }
}

