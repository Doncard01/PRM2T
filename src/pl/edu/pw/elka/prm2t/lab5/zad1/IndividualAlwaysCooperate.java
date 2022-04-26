package pl.edu.pw.elka.prm2t.lab5.zad1;

/**
 * Osobnik realizujący strategię "zawsze współpracuj"
 */
public class IndividualAlwaysCooperate extends Individual {

    @Override
    public boolean willCooperate(Individual other) {
        return true;
    }

    @Override
    protected void rememberInteraction(Individual other, boolean otherAction) {
        // Decyzje innych osobników nie są zapamiętywane.
    }

    @Override
    public String getName() {
        return asString();
    }

    public String asString() {
        return "Always cooperate";
    }
}
