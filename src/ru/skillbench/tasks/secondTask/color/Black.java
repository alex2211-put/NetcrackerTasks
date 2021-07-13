package ru.skillbench.tasks.secondTask.color;

public interface Black {
    /**
     * Устанавливает текущий цвет в color
     *
     * @param color цвет
     */
    void setColor(String color);

    /**
     * @return "It is black", если текущий цвет == "black", и "it isn't black"
     */
    String isBlack();
}
