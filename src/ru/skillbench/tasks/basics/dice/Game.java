package ru.skillbench.tasks.basics.dice;

public class Game {
    private final int winCount;
    private final int N;
    private final int K;

    public Game(int winCount, int N, int K) {
        this.winCount = winCount;
        this.N = N;
        this.K = K;
    }

    /**
     * @return Индекс игрока, выигравшего игру.
     */
    public int getWinner() {
        Player[] players = new Player[N];
        for (int i = 0; i < N; i++) {
            players[i] = new Player(K, winCount, i);
        }
        boolean somebodyWins = false;
        int winner = -1;
        while (!somebodyWins) {
            int index = getIndex(players);
            somebodyWins = players[index].increase();
            winner = players[index].getName();
            Player first = players[index];
            Player change = players[0];
            players[0] = first;
            players[index] = change;
        }
        return winner;
    }

    /**
     * @param players Массив игроков.
     * @return Индекс игрока, выигравшего ход.
     */
    private int getIndex(Player[] players) {
        int[] counts = new int[players.length];
        int[] index = new int[players.length];
        int howMany = -1;
        int max = 0;
        for (int i = 0; i < players.length; i++) {
            counts[i] = players[i].rollDice();
            if (counts[i] > max) {
                max = counts[i];
                howMany = 0;
                index[howMany] = i;
            } else if (counts[i] == max) {
                howMany += 1;
                index[howMany] = i;
            }
        }
        while (howMany != 0) {
            max = 0;
            int[] ind = new int[howMany];
            int much = 0;
            for (int i = 0; i < howMany; i++) {
                int val = players[index[i]].rollDice();
                if (val > max) {
                    max = val;
                    much = 0;
                    ind[much] = index[i];
                } else if (val == max) {
                    much += 1;
                    ind[much] = index[i];
                }
            }
            howMany = much;
            index = ind;
        }
        return index[0];
    }
}
