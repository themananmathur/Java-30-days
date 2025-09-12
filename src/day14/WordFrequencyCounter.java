package day14;

import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String text = "hello good morning teacher hello good morning students hello";

        String[] words = text.split("\\s+");

        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("HashMap - no order:");
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        Map<String, Integer> sortedMap = new TreeMap<>(freqMap);
        System.out.println("\nTreeMap - sorted by word:");
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));

        pq.addAll(freqMap.entrySet());

        System.out.println("\nPriorityQueue - sorted by frequency:");
        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> entry = pq.poll();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
