package eu.iamgio.pokedex.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The habitat a Pokémon species can be encountered in
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum PokemonHabitat {

    CAVE(1),
    FOREST(2),
    GRASSLAND(3),
    MOUNTAIN(4),
    RARE(5),
    ROUGH_TERRAIN(6),
    SEA(7),
    URBAN(8),
    WATERS_EDGE(9);

    /**
     * Identifier for this resource
     */
    private int id;
}
