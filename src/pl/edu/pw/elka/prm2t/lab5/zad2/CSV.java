package pl.edu.pw.elka.prm2t.lab5.zad2;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class CSV {
    private List<String[]> csv = new ArrayList<>();
    private String input;
    private String output;
    private String sep1;
    private String sep2;

    public CSV(String input, String output, String sep1, String sep2) {
        this.input = input;
        this.output = output;
        this.sep1 = sep1;
        this.sep2 = sep2;
    }

    public void read() {
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(sep1);
                csv.add(values);
            }
    } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write() {
        try (FileWriter writer = new FileWriter(output);) {
            for (String[] line : csv) {
                for (String word : line) {
                    writer.append(word).append(sep2);
                }
                writer.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(int row, int column) {
        return csv.get(row)[column];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CSV csv1 = (CSV) o;
        return Objects.equals(csv, csv1.csv) && Objects.equals(input, csv1.input) && Objects.equals(output, csv1.output) && Objects.equals(sep1, csv1.sep1) && Objects.equals(sep2, csv1.sep2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(csv, input, output, sep1, sep2);
    }

    @Override
    public String toString() {
        return "Obiekt klasy CSV, kopiujący zawartość z " + input + ", do"
        + output + " i zmieniająca " + sep1 + " na " + sep2;
    }

    public static void main(String[] args) {
        CSV test = new CSV("resource/ufo.csv", "resource/zmiana.csv", ",", "/");

        test.read();
        test.write();
        System.out.println(test.getValue(3, 1));;

    }
}
