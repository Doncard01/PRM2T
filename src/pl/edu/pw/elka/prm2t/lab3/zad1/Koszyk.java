package pl.edu.pw.elka.prm2t.lab3.zad1;

import java.util.Stack;

public class Koszyk {
    private String id;
    private Stack<ProduktWKoszyku> koszyk = new Stack<>();

    public Koszyk(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /** W tym koszyku obowiązuje reguła LIFO
     *   dodajemy do koszyka produkty w taki sposób, że ostatni dodany element znajduje się na pierwszym indeksie
     *   tego zbioru i jest usuwany jako pierwszy - Last In First Out
     *   **/
    public void dodajDoKoszyka(ProduktWKoszyku o) {
        koszyk.push(o);
    }
    public void usunZKoszyka() {
        koszyk.pop();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n\r");
        int i = 1;
        float wartosc = 0;
        for (ProduktWKoszyku p : koszyk) {
            sb.append(i).append(". ").append(p).append("\n\r");
            wartosc += p.getCena()*p.getLiczbaSztukProduktu();
            i++;
        }
        sb.append("Całkowita wartość koszyka: ").append(wartosc);

        return sb.toString();
    }

    public static void main(String[] args) {
        /**
        Koszyk koszyk = new Koszyk("test");
        koszyk.dodajDoKoszyka("pierwszy");
        koszyk.dodajDoKoszyka("drugi");
        System.out.println(koszyk.toString());
        koszyk.usunZKoszyka();
        System.out.println(koszyk.toString());
         **/

    }
}
