package ru.skillbench.tasks.secondTask.dice;

public interface Game {
    /**
     * @return Индекс игрока, выигравшего игру.
     */
    int getWinner();
    /**
     * @param playerImpls Массив игроков.
     * @return Индекс игрока, выигравшего ход.
     */
    int getIndex(PlayerImpl[] playerImpls);
}
