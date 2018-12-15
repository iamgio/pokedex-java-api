package eu.iamgio.pokedex.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The color of a Pokémon for Pokédex search
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum PokemonColor {

    BLACK(1),
    BLUE(2),
    BROWN(3),
    GRAY(4),
    GREEN(5),
    PINK(6),
    PURPLE(7),
    RED(8),
    WHITE(9),
    YELLOW(10);

    /**
     * Identifier for this resource
     */
    private int id;
}
