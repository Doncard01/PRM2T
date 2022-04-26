package pl.edu.pw.elka.prm2t.lab5.zad1;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Osobnik podejmujący losowe decyzje
 */
public class IndividualActRandomly extends Individual {

    @Override
    public boolean willCooperate(Individual other) {
        return ThreadLocalRandom.current().nextBoolean();
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
        return "Act randomly";
    }
}
