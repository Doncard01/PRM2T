package pl.edu.pw.elka.prm2t.lab5.zad1;

import java.util.HashMap;

/**
 * Osobnik realizujący strategię "najpierw zdradź, potem naśladuj"
 */
public class IndividualDefectThenRepeat extends Individual {

    /**
     * Zapamiętane decyzje innych osobników przy poprzednich spotkaniach.
     */
    private final HashMap<Long, Boolean> memory = new HashMap<>();

    @Override
    public boolean willCooperate(Individual other) {

        // Jeśli z danym osobnikiem nastąpiło już spotkanie, wybierz to samo, co on przy ostatnim spotkaniu.
        // W przeciwnym przypadku - wybierz "zdradę".
        return memory.getOrDefault(other.id, false);
    }

    @Override
    protected void rememberInteraction(Individual other, boolean otherAction) {
        memory.put(other.id, otherAction);
    }

    @Override
    public String getName() {
        return asString();
    }

    public String asString() {
        return "Defect once then repeat";
    }
}
