package ru.skillbench.tasks.secondTask.dice;

import ru.skillbench.tasks.basics.dice.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number of players: ");
        int N = in.nextInt();
        System.out.print("Input a number of dice: ");
        int K = in.nextInt();
        ru.skillbench.tasks.basics.dice.Game game = new Game(7, N, K);
        System.out.println("Выиграл игрок № " + game.getWinner());

    }
}
