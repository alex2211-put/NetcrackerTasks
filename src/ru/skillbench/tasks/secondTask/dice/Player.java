package ru.skillbench.tasks.secondTask.dice;

public interface Player {
    /**
     * @return Сумма очков, которую выкинул игрок.
     */
    int rollDice();

    /**
     * Увеличивает число выигранных матчей на 1.
     *
     * @return Выиграл игрок или нет.
     */
    boolean increase();

    int getName();
}
