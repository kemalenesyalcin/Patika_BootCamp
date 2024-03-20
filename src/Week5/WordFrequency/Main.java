package Week5.WordFrequency;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Metni girin:");
        String text = scanner.nextLine().toLowerCase();


        Map<String, Integer> wordCounts = new HashMap<>();

        // Metni kelimelere ayırıyoruz
        String[] words = text.split("\\s+");


        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                // Kelime zaten varsa, sayısını bir artır
                int count = wordCounts.get(word);
                wordCounts.put(word, count + 1);
            } else {
                // Kelime yoksa, yeni olarak ekle ve sayısını 1 yap
                wordCounts.put(word, 1);
            }
        }

        String mostFrequentWord = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }

        if (!mostFrequentWord.isEmpty()) {
            System.out.println("En çok geçen kelime: " + mostFrequentWord);
            System.out.println("Bu kelime metinde " + maxCount + " kez geçiyor.");
        } else {
            System.out.println("Metinde herhangi bir kelime bulunamadı!");
        }
    }
}
