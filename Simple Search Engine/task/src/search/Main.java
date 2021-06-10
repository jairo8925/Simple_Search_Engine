package search;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Dataset dataset = new Dataset();
        if (args.length == 2) {
            dataset.inputDataset(args[1]);
        } else {
            dataset.populateDataset();
        }
        Controller controller = new Controller(dataset.getDataset());
        controller.startProgram();
    }
}
