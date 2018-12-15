package eu.iamgio.pokedex.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The shape of a Pokémon for Pokédex search
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum PokemonShape {

    BALL(1),
    SQUIGGLE(2),
    FISH(3),
    ARMS(4),
    BLOB(5),
    UPRIGHT(6),
    LEGS(7),
    QUADRUPED(8),
    WINGS(9),
    TENTACLES(9),
    HEADS(11),
    HUMANOID(12),
    BUG_WINGS(13),
    ARMOR(14);

    /**
     * Identifier for this resource
     */
    private int id;
}
