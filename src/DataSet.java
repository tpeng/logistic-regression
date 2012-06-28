import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: tpeng
 * Date: 6/22/12
 * Time: 11:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataSet {

    public static List<Instance> readDataSet(String file) throws FileNotFoundException {
        List<Instance> dataset = new ArrayList<Instance>();
        Scanner scanner = new Scanner(new File(file));
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.startsWith("#")) {
                continue;
            }
            String[] columns = line.split("\\s+");

            // skip first column and last column is the label
            int i = 1;
            int[] data = new int[columns.length-2];
            for (i=1; i<columns.length-1; i++) {
                data[i-1] = Integer.parseInt(columns[i]);
            }
            int label = Integer.parseInt(columns[i]);
            Instance instance = new Instance(label, data);
            dataset.add(instance);
        }
        return dataset;
    }
}
