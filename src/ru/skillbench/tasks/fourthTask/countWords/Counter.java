package ru.skillbench.tasks.fourthTask.countWords;

import java.util.HashSet;
import java.util.Set;

public abstract class Counter {
    protected static Set characterSet2;
    protected static Set result;

    /**
     * Инициализация полей в зависимости от класса - строки или символы
     *
     * @param s1 первая строка
     * @param s2 вторая строка
     */
    protected void init(String s1, String s2) {
    }

    /**
     * Расчет пересечения множеств
     *
     * @param s1 первая строка
     * @param s2 вторая строка
     * @return пересечение множеств
     */
    public HashSet intersection(String s1, String s2) {
        init(s1, s2);
        result.retainAll(characterSet2);
        return (HashSet) result;
    }

    /**
     * Нахождение элементов из первого множества, которых нет во втором
     *
     * @param s1 первая строка
     * @param s2 вторая строка
     * @return искомое множество
     */
    public HashSet firstNotSecond(String s1, String s2) {
        init(s1, s2);
        result.removeAll(characterSet2);
        return (HashSet) result;
    }

    /**
     * Рассчет объединения множеств
     *
     * @param s1 первая строка
     * @param s2 вторая строка
     * @return искомое множество
     */
    public HashSet union(String s1, String s2) {
        init(s1, s2);
        result.addAll(characterSet2);
        return (HashSet) result;
    }

}
