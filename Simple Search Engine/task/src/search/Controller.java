package search;

import java.util.*;

public class Controller {

    private final Scanner scanner = new Scanner(System.in);
    private final List<String> dataset;
    private final Map<String, TreeSet<Integer>> wordsToIndices;

    public Controller(List<String> dataset, Map<String, TreeSet<Integer>> wordsToIndices) {
        this.dataset = dataset;
        this.wordsToIndices = wordsToIndices;
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
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String strategy = scanner.nextLine();
        System.out.println();
        System.out.println("Enter a name or email to search all suitable people.");
        String query = scanner.nextLine();
        System.out.println();

        List<String> results;

        switch (strategy) {
            case "ALL":
                results = findAll(query);
                break;
            case "ANY":
                results = findAny(query);
                break;
            case "NONE":
                results = findNone(query);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + strategy);
        }

        if (results.size() > 0) {
            System.out.println(results.size() + " persons found:");
            for (String result : results) {
                System.out.println(result);
            }
        } else {
            System.out.println("No matching people found.");
        }
        System.out.println();
    }

    private List<String> findAll(String query) {
        String[] words = query.trim().split("\\s+");
        List<String> results = new ArrayList<>();

        if (wordsToIndices.containsKey(words[0])) {
            TreeSet<Integer> indices = wordsToIndices.get(words[0]);
            for (Integer i : indices) {
                String result = dataset.get(i);
                results.add(result);
                List<String> wordsInResult = Arrays.asList(result.trim().split("\\s+"));
                for (String word : words) {
                    if (!wordsInResult.contains(word)) {
                        results.remove(result);
                        break;
                    }
                }
            }
        }

        return results;
    }

    private List<String> findAny(String query) {
        String[] words = query.trim().split("\\s+");
        List<String> results = new ArrayList<>();

        for (String word : words) {
            if (wordsToIndices.containsKey(word)) {
                TreeSet<Integer> indices = wordsToIndices.get(word);
                for (Integer i : indices) {
                    results.add(dataset.get(i));
                }
            }
        }

        return results;
    }

    private List<String> findNone(String query) {
        String[] words = query.trim().split("\\s+");
        List<String> results = new ArrayList<>(dataset);

        for (String word : words) {
            if (wordsToIndices.containsKey(word)) {
                TreeSet<Integer> indices = wordsToIndices.get(word);
                for (Integer i : indices) {
                    results.remove(dataset.get(i));
                }
            }
        }

        return results;
    }
}
