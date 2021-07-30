package ru.skillbench.tasks.fourthTask.countWords;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class countSymbols extends Counter {

    @Override
    protected void init(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Set<Character> set1 = new HashSet<>(Arrays.asList(IntStream.range(0, ch1.length)
                .mapToObj(i -> ch1[i])
                .toArray(Character[]::new)));
        characterSet2 = new HashSet<>(Arrays.asList(IntStream.range(0, ch2.length)
                .mapToObj(i -> ch2[i])
                .toArray(Character[]::new)));
        result = new HashSet<>(set1);
    }
}
