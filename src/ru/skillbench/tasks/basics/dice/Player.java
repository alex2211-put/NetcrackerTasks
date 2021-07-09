package ru.skillbench.tasks.basics.dice;

import java.util.Random;

public class Player {
    private int round;
    private final int countDice;
    private final int winCount;
    private final int name;

    public Player(int countDice, int winCount, int name) {
        this.countDice = countDice;
        this.round = 0;
        this.winCount = winCount;
        this.name = name;
    }

    /**
     * @return Сумма очков, которую выкинул игрок.
     */
    public int rollDice() {
        int sum = 0;
        Random random = new Random();
        for (int i = 0; i < this.countDice; i++) {
            sum += random.nextInt(6) + 1;
        }
        return sum;
    }

    /**
     * Увеличивает число выигранных матчей на 1.
     *
     * @return Выиграл игрок или нет.
     */
    public boolean increase() {
        round += 1;
        return round == this.winCount;
    }

    public int getName() {
        return this.name;
    }
}
