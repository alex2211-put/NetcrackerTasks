package ru.skillbench.tasks.secondTask.dice;

import java.util.Random;

public class PlayerImpl implements Player{
    private int round;
    private final int countDice;
    private final int winCount;
    private final int name;

    public PlayerImpl(int countDice, int winCount, int name) {
        this.countDice = countDice;
        this.round = 0;
        this.winCount = winCount;
        this.name = name;
    }

    @Override
    public int rollDice() {
        int sum = 0;
        Random random = new Random();
        for (int i = 0; i < this.countDice; i++) {
            sum += random.nextInt(6) + 1;
        }
        return sum;
    }

    @Override
    public boolean increase() {
        round += 1;
        return round == this.winCount;
    }

    @Override
    public int getName() {
        return this.name;
    }
}
