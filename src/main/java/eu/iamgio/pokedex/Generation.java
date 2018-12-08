package eu.iamgio.pokedex;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * List of available Pokémon generations
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum Generation {

    GENERATION_I(1),
    GENERATION_II(2),
    GENERATION_III(3),
    GENERATION_IV(4),
    GENERATION_V(5),
    GENERATION_VI(6),
    SUN_MOON(7);

    /**
     * The identifier for this resource.
     */
    private int id;

    //TODO
}
