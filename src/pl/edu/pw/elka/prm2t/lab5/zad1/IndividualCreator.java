package pl.edu.pw.elka.prm2t.lab5.zad1;

import java.util.function.Supplier;

/**
 * Interfejs konstruktorów bezparametrowych, tu: osobników z konkretnymi strategiami.
 * @param <T>
 */
@FunctionalInterface
interface IndividualCreator<T> extends Supplier<T> {
    /**
     * Zwraca nowo utworzony obiekt, tu: osobnika z konkretną strategią.
     * @return nowo utworzony obiekt osobnika
     */
    default T create() {
        return get();
    }

    @Override
    T get();
}
