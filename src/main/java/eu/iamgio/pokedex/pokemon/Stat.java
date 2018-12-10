package eu.iamgio.pokedex.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A list of available stats a Pokémon has
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum Stat {

    HP(1),
    ATTACK(2),
    DEFENSE(3),
    SPECIAL_ATTACK(4),
    SPECIAL_DEFENSE(5),
    SPEED(6),
    ACCURACY(7),
    EVASION(8);

    /**
     * Identifier for this stat
     */
    private int id;
}
