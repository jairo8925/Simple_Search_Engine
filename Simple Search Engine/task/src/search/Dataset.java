package search;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dataset {
    private final List<String> dataset = new ArrayList<>();
    private final Map<String, TreeSet<Integer>> wordsToIndices = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private final Scanner scanner = new Scanner(System.in);

    public Dataset() {

    }

    List<String> getDataset() {
        return this.dataset;
    }

    Map<String, TreeSet<Integer>> getWordsToIndices() {
        return this.wordsToIndices;
    }

    /** Populate dataset through text file */
    void inputDataset(String filename) {
        try (FileInputStream fstream = new FileInputStream(filename)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            int index = 0;
            while ((strLine = br.readLine()) != null) {
                dataset.add(strLine);
                String[] words = strLine.trim().split("\\s+");
                for (String word : words) {
                    TreeSet<Integer> indices;
                    if (wordsToIndices.containsKey(word)) {
                        indices = wordsToIndices.get(word);
                    } else {
                        indices = new TreeSet<>();
                    }
                    indices.add(index);
                    wordsToIndices.put(word, indices);
                }
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Manual populating of dataset */
    void populateDataset() {
        System.out.println("Enter the number of people:");
        int amount = scanner.nextInt();
        scanner.nextLine(); // consume input
        System.out.println("Enter all people:");
        for (int i = 0; i < amount; i++) {
            String input = scanner.nextLine();
            dataset.add(input);
            String[] words = input.trim().split("\\s+");
            for (String word : words) {
                TreeSet<Integer> indices;
                if (wordsToIndices.containsKey(word)) {
                    indices = wordsToIndices.get(word);
                } else {
                    indices = new TreeSet<>();
                }
                indices.add(i);
                wordsToIndices.put(word, indices);
            }
        }
        System.out.println();
    }

}
