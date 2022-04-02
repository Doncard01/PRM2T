package pl.edu.pw.elka.prm2t.lab3.zad1;

public class Klient {
    private String nazwisko;
    private Koszyk koszyk;

    public Klient(String nazwisko, Koszyk koszyk) {
        this.nazwisko = nazwisko;
        this.koszyk = koszyk;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Koszyk getKoszyk() {
        return koszyk;
    }

    @Override
    public String toString() {
        return "Nazwisko: " + nazwisko + ", koszyk: " + koszyk.getId();
    }

}
