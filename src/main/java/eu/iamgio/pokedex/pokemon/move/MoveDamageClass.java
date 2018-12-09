package eu.iamgio.pokedex.pokemon.move;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The type of damage a move inflicts on target(s)
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum MoveDamageClass {

    STATUS(1),
    PHYSICAL(2),
    SPECIAL(3);

    /**
     * The identifier for this resource
     */
    private int id;
}
