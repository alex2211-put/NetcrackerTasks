package ru.skillbench.tasks.basics.equations;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        QuadraticEquations eq = new QuadraticEquations(1, -2, 6);
        System.out.println(Arrays.toString(eq.getRealRoots()));
        System.out.println(Arrays.toString(eq.getRoots()));
        System.out.println(eq.getDiscriminant());
    }
}
