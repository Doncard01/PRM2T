package pl.edu.pw.elka.prm2t.lab5.zad1;

import javax.imageio.plugins.bmp.BMPImageWriteParam;
import java.util.ArrayList;
import java.util.List;

/**
 * Osobnik w symulacji dotyczącej strategii ewolucyjnie stabilnych.
 */
public abstract class Individual {

    /**
     * Do generowania unikatowych identyfikatorów (kolejne longi).
     */
    private static long nextId = Long.MIN_VALUE;

    /**
     * Numer identyfikacyjny osobnika.
     */
    public final long id;

    /**
     * Bieżąca liczba punktów.
     */
    private int points;

    /**
     * Wybór "współpracy" lub "zdrady" przy spotkaniu z innym osobnikiem.
     * @param other osobnik, z którym następuje spotkanie.
     * @return true, jeśli wybrana "współpraca", lub false, jeśli "zdrada".
     */
    abstract public boolean willCooperate(Individual other);

    /**
     * Zapis informacji o odbyciu spotkania z innym osobnikiem.
     * @param other osobnik, z którym nastąpiło spotkanie.
     * @param otherAction decyzja drugiego osobnika w tym spotkaniu (true, jeśli "współpraca", lub false, jeśli "zdrada").
     */
    abstract protected void rememberInteraction(Individual other, boolean otherAction);

    /**
     * @return Nazwa strategii.
     */
    public abstract String getName();

    public Individual() {
        points = 0;
        id = nextId++;
    }

    /**
     * Dodanie punktów do bieżącej puli osobnika.
     * @param amount Liczba punktów.
     */
    private void addPoints(int amount) {
        points += amount;
    }

    /**
     * @return Liczba aktualnie zdobytych punktów.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Spotkanie z innym osobnikiem.
     * @param other osobnik, z którym następuje spotkanie.
     */
    public void interact(Individual other) {
        // Decyzje o "współpracy" (true) lub "zdradzie" (false)
        final boolean thisCooperate = willCooperate(other);
        final boolean otherCooperate = other.willCooperate(this);

        // Liczba punktów zdobytych lub straconych w wyniku tego spotkania
        int thisOutcome, otherOutcome;
        if (thisCooperate) {
            if (otherCooperate) {
                thisOutcome = StrategyOutcome.COOPERATION_REWARD.points;
                otherOutcome = StrategyOutcome.COOPERATION_REWARD.points;
            }
            else {
                thisOutcome = StrategyOutcome.COOPERATION_PUNISHMENT.points;
                otherOutcome = StrategyOutcome.DEFECTION_REWARD.points;
            }
        }
        else {
            if (otherCooperate) {
                thisOutcome = StrategyOutcome.DEFECTION_REWARD.points;
                otherOutcome = StrategyOutcome.COOPERATION_PUNISHMENT.points;
            }
            else {
                thisOutcome = StrategyOutcome.DEFECTION_PUNISHMENT.points;
                otherOutcome = StrategyOutcome.DEFECTION_PUNISHMENT.points;
            }
        }

        // Przekazanie punktów
        addPoints(thisOutcome);
        other.addPoints(otherOutcome);

        // Zapis informacji o spotkaniu
        rememberInteraction(other, otherCooperate);
        other.rememberInteraction(this, thisCooperate);
    }
}
