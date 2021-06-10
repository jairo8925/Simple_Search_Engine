package search;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dataset {
    private final List<String> dataset = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public Dataset() {

    }

    public List<String> getDataset() {
        return this.dataset;
    }

    void inputDataset(String filename) {
        try (FileInputStream fstream = new FileInputStream(filename)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                dataset.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void populateDataset() {
        System.out.println("Enter the number of people:");
        int amount = scanner.nextInt();
        scanner.nextLine(); // consume input
        System.out.println("Enter all people:");
        for (int i = 0; i < amount; i++) {
            dataset.add(scanner.nextLine());
        }
        System.out.println();
    }

}
