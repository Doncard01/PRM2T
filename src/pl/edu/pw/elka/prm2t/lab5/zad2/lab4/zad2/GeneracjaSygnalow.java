package pl.edu.pw.elka.prm2t.lab5.zad2.lab4.zad2;

import java.util.List;
import java.util.ArrayList;

public class GeneracjaSygnalow {

    private List<Double> param = new ArrayList<>();
    private List<Double> xList = new ArrayList<>();
    private int N;

    public GeneracjaSygnalow(List<Double> param, int N) {
        this.param = param;
        this.N = N;
    }

    public void generujX() {
        for (int n=0; n<N; n++) {
            double xn = java.util.concurrent.ThreadLocalRandom.current().nextGaussian();

            for (int k=1; k<=param.size(); k++) {
                if (n - k < 0) {
                    break;
                } else {
                    xn += param.get(k-1) * xList.get(n - k);
                }
            }
            xList.add(xn);
        }
    }

    public double wartoscSrednia() {
        double mikro = 0;
        for (int n=0; n<N; n++) {
            mikro += xList.get(n);
        }
        mikro /= N;
        return mikro;
    }

    public double wariancja() {
        double war = 0;
        double srednia = wartoscSrednia();
        for (int n=0; n<N; n++) {
            war += (xList.get(n)-srednia)*(xList.get(n)-srednia);
        }
        war /= (N-1);
        return war;
    }



    public static void main(String[] args) {
        double p1 = 0.9;
        double p2 = -0.5;
        int N = 100000;
        List<Double> param = new ArrayList<>();
        param.add(p1);
        param.add(p2);
        GeneracjaSygnalow generator = new GeneracjaSygnalow(param, N);
        generator.generujX();
        //System.out.println(generator.xList);
        System.out.printf("%.50f", generator.wartoscSrednia());
        System.out.println("");
        System.out.printf("%.50f", generator.wariancja());




    }
}
