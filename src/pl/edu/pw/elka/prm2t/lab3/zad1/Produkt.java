package pl.edu.pw.elka.prm2t.lab3.zad1;

public class Produkt {
    private String nazwa;
    private double cena;

    public Produkt(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return "Produkt: " + nazwa + ", cena: " + cena + "PLN";
    }
}
