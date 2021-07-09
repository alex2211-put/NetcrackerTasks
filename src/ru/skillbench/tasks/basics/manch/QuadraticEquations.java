package ru.skillbench.tasks.basics.manch;

import ru.skillbench.tasks.basics.math.ComplexNumberImpl;

public class QuadraticEquations {
    private final double a;
    private final double b;
    private final double c;

    /**
     * Конструктор для решения уравнения вида ax^2 + bx + c = 0.
     */
    public QuadraticEquations(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Класс для вычисления дискриминанта исходного уравнения.
     */
    class Discriminant {
        public double calculate() {
            return b * b - 4 * a * c;
        }
    }

    /**
     * @return массив из двух элементов - комплесных корней уравнения.
     */
    public ComplexNumberImpl[] getRoots() {
        ComplexNumberImpl[] ans = new ComplexNumberImpl[2];
        double D = new Discriminant().calculate();
        if (D < 0) {
            ans[0] = new ComplexNumberImpl(-b / (2 * a), Math.sqrt(-D) / (2 * a));
            ans[1] = new ComplexNumberImpl(-b / (2 * a), -Math.sqrt(-D) / (2 * a));
        } else {
            ans[0] = new ComplexNumberImpl(-b / (2 * a) + Math.sqrt(D) / (2 * a), 0);
            ans[1] = new ComplexNumberImpl(-b / (2 * a) - Math.sqrt(D) / (2 * a), 0);
        }
        return ans;
    }

    /**
     * @return дискриминант уравнения.
     */
    public double getDiscriminant() {
        return new Discriminant().calculate();
    }

    /**
     * @return массив из двух элементов - действительных корней уравнения или null, если таковых нет.
     */
    public double[] getRealRoots() {
        ComplexNumberImpl[] ans = getRoots();
        if (ans[1].getIm() == 0) {
            return new double[]{ans[0].getRe(), ans[1].getRe()};
        }
        return null;
    }

}
