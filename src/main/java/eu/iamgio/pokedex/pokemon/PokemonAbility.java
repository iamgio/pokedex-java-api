package eu.iamgio.pokedex.pokemon;

import eu.iamgio.pokedex.exception.PokedexException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents an ability a Pokémon could have
 * @author Gio
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PokemonAbility {

    /**
     * The identifier for this ability
     */
    private int id;

    /**
     * The name for this ability
     */
    private String name;

    /**
     * Whether or not this ability originated in the main series of the video games
     */
    private boolean isMainSeries;

    /**
     * @param name Name of the ability
     * @return Ability whose name matches <tt>name</tt>
     * @throws PokedexException if <tt>name</tt> doesn't match an ability name
     */
    public static PokemonAbility fromName(String name) throws PokedexException {
        //todo
        return null;
    }

    /**
     * @param id Identifier of the ability
     * @return Ability whose ID matches <tt>id</tt>
     * @throws PokedexException if <tt>id</tt> is 0 or less or doesn't match an ability ID
     */
    public static PokemonAbility fromId(int id) throws PokedexException {
        return fromName(String.valueOf(id));
    }
}