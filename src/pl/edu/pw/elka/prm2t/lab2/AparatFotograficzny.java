package pl.edu.pw.elka.prm2t.lab2; //pakiet na labolatorium nr 2
/**
 * @author Adam Staciwa
 * @version 1.0.
 *
 *
 * import klasy Objects, ponieważ niżej wykorzystana będzie jej metoda. hash
 */
import pl.edu.pw.elka.prm2t.testy.Zwierze;

import java.util.Objects;

public class AparatFotograficzny {
    /**
     * prywatne pole marka typu String, przechowujące informacje o marce obiektu(aparatu fotograficznego)
     */
    private String marka;
    /**
     * prywatne pole nazwaModelu typu String, przechowujące informacje o nazwie modelu obiektu
     */
    private String nazwaModelu;
    /**
     * prywatne pole liczbaMegapikseli typu float, przechowujące informacje o liczbie megapikseli obiektu
     */
    private float liczbaMegapikseli;
    /**
     * prywatne pole kolor typu String, przechowujące informacje o kolorze obiektu
     */
    private String kolor;
    /** zmiena logiczna do sprawdzania, czy hash code był już liczony, aby nie powtarzać tej wymagającej operacji **/
    private boolean hashComputed = false;
    /** zmienna przechowująca wartość hash **/
    private int hash = 0;

    /**
     * setter dla pola marka
     * @param marka
     */
    public void setMarka(String marka) {
        this.marka = marka;
    }

    /**
     * setter dla pola nazwaModelu
     * @param nazwaModelu
     */
    public void setNazwaModelu(String nazwaModelu) {
        this.nazwaModelu = nazwaModelu;
    }

    /**
     * setter dla pola liczbaMegapikseli
     * @param liczbaMegapikseli
     */
    public void setLiczbaMegapikseli(float liczbaMegapikseli) {
        this.liczbaMegapikseli = liczbaMegapikseli;
    }

    /**
     * setter dla pola Kolor
     * @param kolor
     */
    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    /**
     * getter dla pola marka
     * @return markę obiektu (Stringa)
     */
    public String getMarka() {
        return marka;
    }

    /**
     * getter dla pola nazwaModelu
     * @return nazwę modelu (String)
     */
    public String getNazwaModelu() {
        return nazwaModelu;
    }

    /**
     * getter dla pola liczbaMegapikseli
     * @return liczbę megapikseli (float)
     */
    public float getLiczbaMegapikseli() {
        return liczbaMegapikseli;
    }

    /**
     * getter dla pola kolor
     * @return kolor (String)
     */
    public String getKolor() {
        return kolor;
    }

    /**
     * Konstruktor z listą paramtetrów, jeśli chcemy utworzyć obiekt i w tym samym czasie podać jego parametry.
     * Może z powodzeniem zastępować settery, jeśli spodziewamy się, żę pola obiektu nie ulegną zmianie.
     * @param marka
     * @param nazwaModelu
     * @param liczbaMegapikseli
     * @param kolor
     */
    public AparatFotograficzny(String marka, String nazwaModelu, String kolor, float liczbaMegapikseli) {
        this.marka = marka;
        this.nazwaModelu = nazwaModelu;
        this.kolor = kolor;
        this.liczbaMegapikseli = liczbaMegapikseli;
    }

    /**
     * Konstruktor "pusty", jeśli chcemy stworzyć obiekt bez podawania parametrów
     */
    public AparatFotograficzny(){

    }
    /** nowa metoda toString **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Marka: ").append(marka).append(", model: ").append(nazwaModelu)
                .append(", kolor: ").append(kolor).append(", liczba megapikseli: ").append(liczbaMegapikseli);
        return sb.toString();
    }
    /** nowa metoda equals **/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AparatFotograficzny)) {
            return false;
        }
        AparatFotograficzny other = (AparatFotograficzny) obj;
        if (marka != other.marka || nazwaModelu != other.nazwaModelu || kolor != other.kolor
                || liczbaMegapikseli != liczbaMegapikseli) {
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
        hash = Objects.hash(marka, nazwaModelu, kolor, liczbaMegapikseli);
        hashComputed = true;
        return hash;
    }

    /**
     * Kod testujący
     */
    public static void main(String[] args) {
        /** tworzenie nowego obiektu klasy AparatFotograficzny **/
        AparatFotograficzny aparat = new AparatFotograficzny();
        /** ustawianie parametrów obiektu aparat przy pomocy setterów  **/
        aparat.setKolor("Czarny");
        aparat.setMarka("Canon");
        aparat.setLiczbaMegapikseli(12.5f);
        aparat.setNazwaModelu("EOS R5");
        /** zwracanie wartości pól obiektu przy pomocy getterów i wypisanie ich na wyjście **/
        String markaAparatu = aparat.getMarka();
        String modelAparatu = aparat.getNazwaModelu();
        String kolorAparatu = aparat.getKolor();
        float pikseleAparatu = aparat.getLiczbaMegapikseli();
        System.out.println("Aparat jest marki " + markaAparatu + ", model " + modelAparatu + ", koloru: "
        + kolorAparatu + " i ma aż " + pikseleAparatu + " megapikseli.");

        /** sprawdzenie działania metody toString **/
        System.out.print(String.format("%s%n%s%n", "Dane z metody toString(): ", aparat.toString()));

        /** tworzenie kolejnych obiektów **/
        AparatFotograficzny aparat2 = new AparatFotograficzny("Sony", "A7R", "Biały", 11.7f);
        AparatFotograficzny aparat3 = new AparatFotograficzny("Canon", "EOS R5", "Czarny", 12.5f);

        /** testowanie metody equals **/
        System.out.println("Czy aparat equals aparat2?");
        System.out.println(aparat.equals(aparat2));
        System.out.println("Czy aparat equals aparat3?");
        System.out.println(aparat.equals(aparat3));
        System.out.println("Czy aparat equals aparat?");
        System.out.println(aparat.equals(aparat));
        System.out.println("Czy aparat2 equals aparat3?");
        System.out.println(aparat2.equals(aparat3));

        /** testowanie metody hashCode **/
        System.out.println("Hash code obiektu aparat: " + aparat.hashCode());
        System.out.println("Hash code obiektu aparat2: " + aparat2.hashCode());
        System.out.println("Hash code obiektu aparat3: " + aparat3.hashCode());
    }
}
