package ru.skillbench.tasks.fourthTask.countWords;

import java.util.*;

public class countWords extends Counter {

    @Override
    protected void init(String s1, String s2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(s1.split(" ")));
        characterSet2 = new HashSet<>(Arrays.asList(s2.split(" ")));
        result = new HashSet<>(set1);
    }

}
