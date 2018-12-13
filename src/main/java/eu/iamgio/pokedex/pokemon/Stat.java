package eu.iamgio.pokedex.pokemon;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents a stat a Pokémon has
 */
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class Stat {

    /**
     * The stat the Pokémon has
     */
    private Type type;

    /**
     * The effort points (EV) the Pokémon has in the stat
     */
    private int effort;

    /**
     * The base value of the stat
     */
    private int baseStat;

    /**
     * A list of available stats a Pokémon has
     * @author Gio
     */
    @AllArgsConstructor
    @Getter
    public enum Type {

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
}