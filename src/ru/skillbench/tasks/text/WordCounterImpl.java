package ru.skillbench.tasks.text;

import java.io.PrintStream;
import java.util.*;

public class WordCounterImpl implements WordCounter {

    private String text = null;
    private Map<String, Long> map = new HashMap<>();

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public Map<String, Long> getWordCounts() {
        if (this.text == null) {
            throw new IllegalStateException();
        }
        for (String word : this.text.split("[^A-Za-zА-Яа-я0-9ё<>]+")) {
            if (word.contains("<") && word.contains(">")) {
                continue;
            }
            if (word.isEmpty())
                continue;
            if (map.containsKey(word.toLowerCase(Locale.ROOT))) {
                map.replace(word.toLowerCase(Locale.ROOT), map.get(word.toLowerCase(Locale.ROOT)) + 1);
            } else {
                map.put(word.toLowerCase(Locale.ROOT), 1L);
            }
        }
        return map;
    }

    @Override
    public List<Map.Entry<String, Long>> getWordCountsSorted() {
        if (this.text != null) {
            return sortWordCounts(getWordCounts());
        } else {
            throw new IllegalStateException();
        }
    }

    public List<Map.Entry<String, Long>> sortWordCounts(Map<String, Long> orig) {
        if (orig == null) {
            return null;
        } else {
            List<Map.Entry<String, Long>> list =
                    new LinkedList<>(orig.entrySet());
            list.sort(new Comparator<Map.Entry<String, Long>>() {
                @Override
                public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                    if ((o1.getValue()).compareTo(o2.getValue()) != 0) {
                        return -1 * (o1.getValue()).compareTo(o2.getValue());
                    } else {
                        return (o1.getKey()).compareTo(o2.getKey());
                    }
                }
            });
            return list;
        }
    }

    @Override
    public <K extends Comparable<K>, V extends Comparable<V>> List<Map.Entry<K, V>> sort(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator) {
        if (map == null) {
            return null;
        } else {
            List<Map.Entry<K, V>> list =
                    new LinkedList<>(map.entrySet());
            list.sort(comparator);
            return list;
        }
    }

    @Override
    public <K, V> void print(List<Map.Entry<K, V>> entries, PrintStream ps) {
        for (Map.Entry<K, V> entry : entries) {
            ps.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
