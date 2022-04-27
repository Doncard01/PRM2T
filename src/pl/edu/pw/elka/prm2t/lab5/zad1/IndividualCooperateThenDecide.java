package pl.edu.pw.elka.prm2t.lab5.zad1;

import java.util.HashMap;

/**
 * Osobnik realizujący strategię "najpierw współpracuj, potem jeśli 2 ostatnie ruchy przeciwnika to zdrada - zdradź,
 * w przeciwnym przypadku - współpracuj"
 */
public class IndividualCooperateThenDecide extends Individual {
    /**
     * Zapamiętane decyzje innych osobników przy poprzednich spotkaniach.
     */
    private final HashMap<Long, Boolean> memory = new HashMap<>();
    private final HashMap<Long, Boolean> memory2 = new HashMap<>();

    @Override
    public boolean willCooperate(Individual other) {
        if (memory.get(other.id) == null && memory2.get(other.id) == null) {
            return true;
        } else if (memory2.get(other.id) == null) {
            return true;
        } else if (memory.get(other.id) == false && memory2.get(other.id) == false) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    protected void rememberInteraction(Individual other, boolean otherAction) {
        memory2.put(other.id, memory.get(other.id));
        memory.put(other.id, otherAction);
    }

    @Override
    public String getName() {
        return asString();
    }

    public String asString() {
        return "Cooperate once then decide";
    }
}
