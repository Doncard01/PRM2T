package pl.edu.pw.elka.prm2t.lab3.zad2;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class LiczbyLosowe {
    private int MAX, N, S;
    private List<Integer> liczby = new ArrayList<>();

    public LiczbyLosowe(int MAX, int N, int S) {
        this.MAX = MAX;
        this.N = N;
        this.S = S;
    }

    @Override
    public String toString() {
        return "Tablica liczb losowych: " + liczby;
    }

    public List<Integer> losuj() {
        Random rnd = new Random();

        int i = 0;
        do {
            liczby.add(rnd.nextInt(MAX));
        } while (liczby.get(i++) != S); //funkcja liczby.get() najpierw jako argument bierze i, a dopiero potem następuje inkrementacja

        return liczby;
    }

    public List<Integer> getLiczby() {
        return liczby;
    }

    public void wypiszPierszwszeN(List<Integer> lista) {
        int dlugosc;

        dlugosc = N < liczby.size() ? N : liczby.size();
        System.out.println("N pierszych w kolejności losowania liczb:");

        for (int i = 0; i < dlugosc; i++) {
            System.out.println(lista.get(i));
        }
    }

    public void wypiszOstatnieN(List<Integer> lista) {
        int dlugosc;

        dlugosc = N < liczby.size() ? N : liczby.size();
        System.out.println("N ostatnich w kolejności losowania liczb:");

        for (int i = 0; i < dlugosc; i++) {
            System.out.println(lista.get(liczby.size()-i-1));
        }
    }

    public Set<Integer> posortowane(List<Integer> lista) {
        Set<Integer> set = new TreeSet<>();
        for(Integer i : lista) {
            set.add(i);
        }
        return set;
    }
    public static void main(String[] args) {
        LiczbyLosowe l = new LiczbyLosowe(10, 3, 1);
        l.losuj();
        System.out.println(l);
        l.wypiszPierszwszeN(l.getLiczby());
        l.wypiszOstatnieN(l.getLiczby());
        System.out.println(l.posortowane(l.getLiczby()));
    }

}
