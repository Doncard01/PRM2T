package pl.edu.pw.elka.prm2t.lab5.zad1;

import java.util.*;

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
        long ileTrue = 0;
        long ileFalse = 0;

        if (memory.get(other.id) == null) {
            Random rd = new Random();
            return rd.nextBoolean();
        } else
        {
            List<Boolean> temp = memory.get(other.id);
            for (Boolean b : temp) {
                if (b == true) {
                    ileTrue++;
                } else if (b == false) {
                    ileFalse++;
                }
            }
        }

        if (ileTrue > ileFalse) {
            return true;
        } else if (ileFalse > ileTrue) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    protected void rememberInteraction(Individual other, boolean otherAction) {
        if (!memory.containsKey(other.id)) {
            memory.put(other.id, new ArrayList<>());
            memory.get(other.id).add(otherAction);
        } else {
            memory.get(other.id).add(otherAction);
        }
    }

    @Override
    public String getName() {
        return asString();
    }

    public String asString() {
        return "Act randomly once then decide";
    }
}
