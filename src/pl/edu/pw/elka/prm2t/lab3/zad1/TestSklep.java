package pl.edu.pw.elka.prm2t.lab3.zad1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class TestSklep {
    public static void main(String... args) {

        ArrayList<Produkt> listaProduktow = new ArrayList<>();
        ArrayList<Klient> listaKlientow = new ArrayList<>();
        Deque<Klient> kolejka = new ArrayDeque<>();

        Produkt lampa = new Produkt("lampa", 12);
        Produkt krzeslo = new Produkt("krzesło", 30);
        Produkt stol = new Produkt("stół", 180);
        Produkt szafa = new Produkt("szafa", 500);

        ProduktWKoszyku lampa7 = new ProduktWKoszyku(lampa.getNazwa(), lampa.getCena(),  7);
        ProduktWKoszyku lampa5 = new ProduktWKoszyku(lampa.getNazwa(), lampa.getCena(),  5);
        ProduktWKoszyku lampa10 = new ProduktWKoszyku(lampa.getNazwa(), lampa.getCena(),  10);

        ProduktWKoszyku krzeslo2 = new ProduktWKoszyku(krzeslo.getNazwa(), krzeslo.getCena(), 2);
        ProduktWKoszyku krzeslo4 = new ProduktWKoszyku(krzeslo.getNazwa(), krzeslo.getCena(), 4);
        ProduktWKoszyku krzeslo8 = new ProduktWKoszyku(krzeslo.getNazwa(), krzeslo.getCena(), 8);

        ProduktWKoszyku stol1 = new ProduktWKoszyku(stol.getNazwa(), stol.getCena(), 1);
        ProduktWKoszyku stol2 = new ProduktWKoszyku(stol.getNazwa(), stol.getCena(), 2);
        ProduktWKoszyku stol3 = new ProduktWKoszyku(stol.getNazwa(), stol.getCena(), 3);

        ProduktWKoszyku szafa4 = new ProduktWKoszyku(szafa.getNazwa(), szafa.getCena(), 4);
        ProduktWKoszyku szafa6 = new ProduktWKoszyku(szafa.getNazwa(), szafa.getCena(), 6);
        ProduktWKoszyku szafa9 = new ProduktWKoszyku(szafa.getNazwa(), szafa.getCena(), 9);

        listaProduktow.add(lampa);
        listaProduktow.add(krzeslo);
        listaProduktow.add(stol);
        listaProduktow.add(szafa);
        System.out.println("Lista produktów:");
        System.out.println(listaProduktow);

        Koszyk<ProduktWKoszyku> koszyk1 = new Koszyk<>("koszyk1");
        Koszyk<ProduktWKoszyku> koszyk2 = new Koszyk<>("koszyk2");
        Koszyk<ProduktWKoszyku> koszyk3 = new Koszyk<>("koszyk3");
        Klient Nowak = new Klient("Nowak", koszyk1);
        Klient Kowalski = new Klient("Kowalski", koszyk2);
        Klient Goc = new Klient("Goc", koszyk3);

        listaKlientow.add(Nowak);
        listaKlientow.add(Kowalski);
        listaKlientow.add(Goc);
        System.out.println("Lista klientów:");
        System.out.println(listaKlientow);

        kolejka.add(Nowak);
        System.out.println("Kolejka: " + kolejka);
        koszyk1.dodajDoKoszyka(lampa7);
        koszyk1.dodajDoKoszyka(krzeslo2);
        koszyk1.dodajDoKoszyka(stol1);
        koszyk1.dodajDoKoszyka(szafa4);

        System.out.println("Koszyk klienta " + Nowak.getNazwisko() + ": " + Nowak.getKoszyk());



    }
}
