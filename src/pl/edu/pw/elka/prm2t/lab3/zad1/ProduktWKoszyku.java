package pl.edu.pw.elka.prm2t.lab3.zad1;

public class ProduktWKoszyku extends Produkt {
    private int liczbaSztukProduktu;

    public ProduktWKoszyku(String nazwa, double cena, int liczbaSztukProduktu) {
        super(nazwa, cena);
        this.liczbaSztukProduktu = liczbaSztukProduktu;
    }

    public int getLiczbaSztukProduktu() {
        return liczbaSztukProduktu;
    }
    @Override //metoda do zwracania listy w koszyku
    public String toString(){
        return "Nazwa: " + getNazwa() + ", ilość: " + liczbaSztukProduktu;
    }
}
