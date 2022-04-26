package pl.edu.pw.elka.prm2t.lab5.zad1;

/**
 * Osobnik realizujący strategię "zawsze zdradzaj"
 */
public class IndividualAlwaysDefect extends Individual {

    @Override
    public boolean willCooperate(Individual other) {
        return false;
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
        return "Always defect";
    }
}
