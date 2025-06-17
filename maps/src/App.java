import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        String fileName = "/home/lecor/Documents/java/oopHomework/maps/maps/src/test.txt";
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Initialize map with letters A-Z
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            frequencyMap.put(ch, 0);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            int c;
            while ((c = br.read()) != -1) {
                char ch = Character.toUpperCase((char) c);
                if (ch >= 'A' && ch <= 'Z') {
                    frequencyMap.put(ch, frequencyMap.get(ch) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort by frequency in descending order
        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Display results
        for (Map.Entry<Character, Integer> entry : sortedList) {
            if (entry.getValue() > 0) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

    }
}
