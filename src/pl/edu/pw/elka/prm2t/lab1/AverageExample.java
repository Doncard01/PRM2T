package pl.edu.pw.elka.prm2t.lab1;

import java.util.ArrayList;
import java.util.List;

public class AverageExample {

    private List<Integer> values = new ArrayList<>();

    public AverageExample(String[] args) {
        parseArgs(args);
    }

    private void parseArgs(String[] args) {
        for (int i = 0; i < args.length; ++i) {
            values.add(Integer.parseInt(args[i]));
        }
        /* try alternatively:
        for (String arg : args) {
            values.add(Integer.parseInt(arg));
        }*/
    }

    public double calculateAverage() {
        float sum = 0;
        for (Integer value : values) {
            sum += value;
        }
        return sum / values.size();
    }

    public static void main(String[] args) {
        AverageExample averageExample = new AverageExample(args);
        System.out.println(averageExample.calculateAverage());
    }
}
