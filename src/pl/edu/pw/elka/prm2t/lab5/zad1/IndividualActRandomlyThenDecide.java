package pl.edu.pw.elka.prm2t.lab5.zad1;

import java.util.HashMap;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

/**
 * Osobnik realizujący strategię "najpierw współpracuj, potem jeśli 2 ostatnie ruchy przeciwnika to zdrada - zdradź,
 * w przeciwnym przypadku - współpracuj"
 */
public class IndividualActRandomlyThenDecide extends Individual {
    /**
     * Zapamiętane decyzje innych osobników przy poprzednich spotkaniach.
     */
    private final HashMap<Long, List<Boolean>> memory = new HashMap<>();

    @Override
    public boolean willCooperate(Individual other) {
        if (memory.get(other.id) == null) {
            Random rd = new Random();
            return rd.nextBoolean();
        } else {
            return false;
        }
    }

    @Override
    protected void rememberInteraction(Individual other, boolean otherAction) {
        other.addToList(otherAction);
        memory.put(other.id, other.getList());
    }

    @Override
    public String getName() {
        return asString();
    }

    public String asString() {
        return "Cooperate once then decide";
    }
}
