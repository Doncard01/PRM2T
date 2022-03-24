package pl.edu.pw.elka.prm2t.testy;

import java.util.Objects;
/**
 * @author Adam Staciwa
 * @version 1.0.
 * **/
public class Zwierze {
    private String imie;
    private int liczbaKonczyn;
    private String kolor;
    private boolean hashComputed = false;
    private int hash = 0;

    public void setImie(String noweImie) {
        imie = noweImie;
    }

    public void setLiczbaKonczyn(int ile) {

        liczbaKonczyn = ile;
    }

/** @param nowyKolor zostanie przypisany do pola kolor obiektu **/
    public void setKolor(String nowyKolor) {
        kolor = nowyKolor;
    }

    public String getImie(){
        return imie;
    }

    public int getLiczbaKonczyn(){
        return liczbaKonczyn;
    }
/** @return kolor obiektu **/
    public String getKolor(){
        return kolor;
    }
/** 3 poniższe metody robią to samo, co settery, ale nazywają się bardziej znacząco **/
    public void nadajImie(String noweImie){
        imie = noweImie;
    }

    public void policzKonczyny(int ile) {
        liczbaKonczyn = ile;
    }

    public void okreslKolor(String nowyKolor) {
        kolor = nowyKolor;
    }
/** nowa metoda toString **/
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Imię: ").append(imie).append(", liczba kończyn: ").append(liczbaKonczyn)
                .append(", kolor: ").append(kolor);
        return sb.toString();
    }
/** nowa metoda equals **/
    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof Zwierze)) {
            return false;
        }
        Zwierze other = (Zwierze) obj;
        if(imie != other.imie || liczbaKonczyn != other.liczbaKonczyn || kolor != other.kolor){
            return false;
        }
        return true;
    }
/** nowa metoda hashCode **/
    @Override
    public int hashCode(){
        if(hashComputed) {
            return hash;
        }
        hash = Objects.hash(imie, kolor, liczbaKonczyn);
        hashComputed = true;
        return hash;
    }

    public static void main(String[] args) {
        /** tworzeie obiektu klasy Zwierze i testowanie setterów i getterów **/
        Zwierze kot = new Zwierze();
        kot.setImie("Mruczek");
        kot.setKolor("Czarny");
        kot.setLiczbaKonczyn(4);
        String imieKotka = kot.getImie();
        String kolorKotka = kot.getKolor();
        int kocieLapki = kot.getLiczbaKonczyn();
        System.out.println("Kot ma na imie " + imieKotka + ", kolor " + kolorKotka
                + " i " + kocieLapki + " łapki.");

        /** sprawdzenie działania metody toString **/
        System.out.print(String.format("%s%n%s%n", "Dane z metody toString(): ", kot.toString()));

        Zwierze kot2 = new Zwierze();
        kot2.setImie("Mruczek");
        kot2.setKolor("Czarny");
        kot2.setLiczbaKonczyn(4);

        Zwierze pies = new Zwierze();
        pies.setImie("Azor");
        pies.setKolor("Czarny");
        pies.setLiczbaKonczyn(4);

        /** sprawdzenie działania funkcji equals **/
        System.out.println("Czy kot equals kot?");
        System.out.println(kot.equals(kot));
        System.out.println("Czy kot equals kot2?");
        System.out.println(kot.equals(kot2));
        System.out.println("Czy kot equals pies?");
        System.out.println(kot.equals(pies));
    }


}


