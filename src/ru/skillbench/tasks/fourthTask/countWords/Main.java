package ru.skillbench.tasks.fourthTask.countWords;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter first String: ");
        String s1 = in.nextLine();
        System.out.print("Enter second String: ");
        String s2 = in.nextLine();
        Counter wordsCounter = new countWords();
        Counter symbolsCounter = new countSymbols();

        List<String> list = new ArrayList<String>(wordsCounter.intersection(s1, s2));
        Collections.sort(list);
        System.out.println("Words in first & second (default): " + list);

        list = new ArrayList<String>(wordsCounter.firstNotSecond(s1, s2));
        list.sort(Collections.reverseOrder());
        System.out.println("Words in first not in second (reverse): " + list);


        Comparator<String> comparator = Comparator.comparing(obj -> (obj.hashCode() << 1)); // n = 2
        list = new ArrayList<String>(wordsCounter.union(s1, s2));
        list.sort(comparator);
        System.out.println("Words in first | second (hash code): " + wordsCounter.union(s1, s2));

        List<Character> list2 = new ArrayList<Character>(symbolsCounter.intersection(s1, s2));
        Collections.sort(list2);
        System.out.println("Symbols in first & second (default): " + list2);

        list2 = new ArrayList<Character>(symbolsCounter.firstNotSecond(s1, s2));
        list2.sort(Collections.reverseOrder());
        System.out.println("Symbols in first not in second (reverse): " + list2);

        Comparator<Character> comparator2 = Comparator.comparing(obj -> (obj.hashCode() << 1)); // n = 2
        list2 = new ArrayList<Character>(symbolsCounter.union(s1, s2));
        list2.sort(comparator2);
        System.out.println("Symbols in first | second (hash code): " + symbolsCounter.union(s1, s2));

    }
}
