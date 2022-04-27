package pl.edu.pw.elka.prm2t.lab5.zad1;

import java.util.HashMap;
import java.util.Random;

/**
 * Osobnik realizujący strategię "najpierw zachowaj się losowo, potem naśladuj"
 */
public class IndividualActRandomlyThenRepeat extends Individual {

    /**
     * Zapamiętane decyzje innych osobników przy poprzednich spotkaniach.
     */
    private final HashMap<Long, Boolean> memory = new HashMap<>();

    @Override
    public boolean willCooperate(Individual other) {
        // Jeśli z danym osobnikiem nastąpiło już spotkanie, wybierz to samo, co on przy ostatnim spotkaniu.
        // W przeciwnym przypadku - zachowaj się losowo.

        Random rd = new Random();
        return memory.getOrDefault(other.id, rd.nextBoolean());
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
        return "Act randomly once then then repeat";
    }
}
