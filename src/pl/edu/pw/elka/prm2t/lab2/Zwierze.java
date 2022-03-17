package pl.edu.pw.elka.prm2t.lab2;

public class Zwierze {
    private String imie;
    private int liczbaKonczyn;
    private String kolor;

    public void setImie(String noweImie) {
        imie = noweImie;
    }

    public void setLiczbaKonczyn(int ile) {
        liczbaKonczyn = ile;
    }

    public void setKolor(String nowyKolor) {
        kolor = nowyKolor;
    }

    public String getImie(){
        return imie;
    }

    public int getLiczbaKonczyn(){
        return liczbaKonczyn;
    }

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

    public static void main(String[] args) {
        Zwierze kot = new Zwierze();
        kot.setImie("Mruczek");
        kot.setKolor("Czarny");
        kot.setLiczbaKonczyn(4);
        String imieKotka = kot.getImie();
        String kolorKotka = kot.getKolor();
        int kocieLapki = kot.getLiczbaKonczyn();
        System.out.println("Kot ma na imie " + imieKotka + ", kolor " + kolorKotka
                + " i " + kocieLapki + " łapki.");
    }
}


