package search;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> dataset = new ArrayList<>();
        System.out.println("Enter the number of people:");
        int amount = scanner.nextInt();
        scanner.nextLine(); // consume input
        System.out.println("Enter all people:");
        for (int i = 0; i < amount; i++) {
            dataset.add(scanner.nextLine());
        }
        System.out.println();

        System.out.println("Enter the number of search queries:");
        amount = scanner.nextInt();
        System.out.println();
        scanner.nextLine(); // consume input
        for (int i = 0; i < amount; i++) {
            System.out.println("Enter data to search people:");
            String query = scanner.next();
            boolean found = false;
            for(String data : dataset) {
                if (data.toLowerCase().contains(query.toLowerCase())) {
                    if (!found) {
                        System.out.println();
                        System.out.println("Found people:");
                    }
                    System.out.println(data);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No matching people found.");
            }
            System.out.println();
        }
    }
}
