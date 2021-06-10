package search;

public class Main {
    public static void main(String[] args) {
        Dataset dataset = new Dataset();
        if (args.length == 2) {
            dataset.inputDataset(args[1]);
        } else {
            dataset.populateDataset();
        }
        Controller controller = new Controller(dataset.getDataset(), dataset.getWordsToIndices());
        controller.startProgram();
    }
}
