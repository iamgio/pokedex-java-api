package eu.iamgio.pokedex.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * Represents a pair of two objects
 * @param <F> First object
 * @param <S> Second object
 * @author Gio
 */
@AllArgsConstructor
@Getter
public class Pair<F, S> {

    /**
     * First object
     */
    private F first;

    /**
     * Second object
     */
    private S second;

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Pair
                && ((Pair) obj).getFirst().equals(first) && ((Pair) obj).getSecond().equals(second);
    }
}
