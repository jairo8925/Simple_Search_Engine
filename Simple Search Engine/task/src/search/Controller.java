package search;

import java.util.List;
import java.util.Scanner;

public class Controller {

    private static final Scanner scanner = new Scanner(System.in);
    private final List<String> dataset;

    public Controller(List<String> dataset) {
        this.dataset = dataset;
    }

    void startProgram() {
        try {
            while (true) {
                System.out.println("=== Menu ===");
                System.out.println("1. Search information.");
                System.out.println("2. Print all people");
                System.out.println("0. Exit");
                String command = scanner.nextLine();
                System.out.println();
                switch (command) {
                    case "1":
                        findPerson();
                        break;
                    case "2":
                        System.out.println(" === List of people ===");
                        for (String data : dataset) {
                            System.out.println(data);
                        }
                        System.out.println();
                        break;
                    case "0":
                        System.out.println("Bye!");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Incorrect option! Try again.");
                        System.out.println();
                }
            }
        } finally {
            scanner.close();
        }
    }

    private void findPerson() {
        System.out.println("Enter a name or email to search all suitable people.");
        String query = scanner.nextLine();
        boolean found = false;
        for(String data : dataset) {
            if (data.toLowerCase().contains(query.toLowerCase())) {
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
