package eu.iamgio.pokedex.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * List of available Pokémon types
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum PokemonType {

    NORMAL(1),
    FIGHTING(2),
    FLYING(3),
    POISON(4),
    GROUND(5),
    ROCK(6),
    BUG(7),
    GHOST(8),
    STEEL(9),
    FIRE(10),
    WATER(11),
    GRASS(12),
    ELECTRIC(13),
    PSYCHIC(14),
    ICE(15),
    DRAGON(16),
    DARK(17),
    UNKNOWN(10001),
    SHADOW(10002);

    /**
     * Identifier for this type
     */
    private int id;
}
