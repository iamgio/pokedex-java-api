package eu.iamgio.pokedex.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The rate at which a Pokémon gains levels
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum GrowthRate {

    SLOW(1),
    MEDIUM(2),
    FAST(3),
    MEDIUM_SLOW(4),
    SLOW_THEN_VERY_FAST(5),
    FAST_THEN_VERY_SLOW(6);

    /**
     * The identifier for this resource
     */
    private int id;
}
