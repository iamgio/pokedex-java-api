package eu.iamgio.pokedex.pokemon;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents a {@link PokemonAbility} a Pokémon actually has
 * @author Gio
 */
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class PokemonPersonalAbility {

    /**
     * Name of this ability (lower case)
     */
    private String name;

    /**
     * Whether or not this is a hidden ability
     */
    private boolean isHidden;

    /**
     * The slot this ability occupies in this Pokémon species
     */
    private int slot;

    /**
     * @return General {@link PokemonAbility}
     */
    public PokemonAbility toAbility() {
        return PokemonAbility.fromName(name);
    }
}
