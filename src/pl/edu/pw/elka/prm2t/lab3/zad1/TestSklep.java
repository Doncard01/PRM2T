package pl.edu.pw.elka.prm2t.lab3.zad1;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class TestSklep {
    public static void main(String... args) {

        List<Produkt> listaProduktow = new ArrayList<>();
        List<Klient> listaKlientow = new ArrayList<>();
        Deque<Klient> kolejka = new ArrayDeque<>();

        Produkt lampa = new Produkt("lampa", 12);
        Produkt krzeslo = new Produkt("krzesło", 30);
        Produkt stol = new Produkt("stół", 180);
        Produkt szafa = new Produkt("szafa", 500);

        ProduktWKoszyku lampa7 = new ProduktWKoszyku(lampa,  7);
        ProduktWKoszyku lampa5 = new ProduktWKoszyku(lampa,  5);
        ProduktWKoszyku lampa10 = new ProduktWKoszyku(lampa,  10);

        ProduktWKoszyku krzeslo2 = new ProduktWKoszyku(krzeslo, 2);
        ProduktWKoszyku krzeslo4 = new ProduktWKoszyku(krzeslo, 4);
        ProduktWKoszyku krzeslo8 = new ProduktWKoszyku(krzeslo, 8);

        ProduktWKoszyku stol1 = new ProduktWKoszyku(stol, 1);
        ProduktWKoszyku stol2 = new ProduktWKoszyku(stol, 2);
        ProduktWKoszyku stol3 = new ProduktWKoszyku(stol, 3);

        ProduktWKoszyku szafa4 = new ProduktWKoszyku(szafa, 4);
        ProduktWKoszyku szafa6 = new ProduktWKoszyku(szafa, 6);
        ProduktWKoszyku szafa9 = new ProduktWKoszyku(szafa, 9);

        listaProduktow.add(lampa);
        listaProduktow.add(krzeslo);
        listaProduktow.add(stol);
        listaProduktow.add(szafa);
        System.out.println("Lista produktów:");
        System.out.println(listaProduktow);

        Koszyk koszyk1 = new Koszyk("koszyk1");
        Koszyk koszyk2 = new Koszyk("koszyk2");
        Koszyk koszyk3 = new Koszyk("koszyk3");
        Klient Nowak = new Klient("Nowak", koszyk1);
        Klient Kowalski = new Klient("Kowalski", koszyk2);
        Klient Goc = new Klient("Goc", koszyk3);

        listaKlientow.add(Nowak);
        listaKlientow.add(Kowalski);
        listaKlientow.add(Goc);
        System.out.println("Lista klientów:");
        System.out.println(listaKlientow);

        kolejka.add(Nowak);
        Nowak.getKoszyk().dodajDoKoszyka(lampa7);
        Nowak.getKoszyk().dodajDoKoszyka(krzeslo2);
        Nowak.getKoszyk().dodajDoKoszyka(stol1);
        Nowak.getKoszyk().dodajDoKoszyka(szafa4);

        kolejka.add(Kowalski);
        Kowalski.getKoszyk().dodajDoKoszyka(lampa5);
        Kowalski.getKoszyk().dodajDoKoszyka(krzeslo4);
        Kowalski.getKoszyk().dodajDoKoszyka(stol2);
        Kowalski.getKoszyk().dodajDoKoszyka(szafa6);

        kolejka.add(Goc);
        Goc.getKoszyk().dodajDoKoszyka(lampa10);
        Goc.getKoszyk().dodajDoKoszyka(krzeslo8);
        Goc.getKoszyk().dodajDoKoszyka(stol3);
        Goc.getKoszyk().dodajDoKoszyka(szafa9);

        System.out.println("Kolejka: " + kolejka);
        System.out.println("Koszyk klienta " + Nowak.getNazwisko() + ": " + Nowak.getKoszyk());
        kolejka.pop();

        System.out.println("Kolejka: " + kolejka);
        System.out.println("Koszyk klienta " + Kowalski.getNazwisko() + ": " + Kowalski.getKoszyk());
        kolejka.pop();

        System.out.println("Kolejka: " + kolejka);
        System.out.println("Koszyk klienta " + Goc.getNazwisko() + ": " + Goc.getKoszyk());
        kolejka.pop();
        System.out.println("Kolejka: " + kolejka);



    }
}
