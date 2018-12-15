package eu.iamgio.pokedex.pokemon;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents a Pokémon that exist within a Pokémon species
 * @author Gio
 */
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class PokemonSpeciesVariety {

    /**
     * Name of the Pokémon variety
     */
    private String name;

    /**
     * Whether this variety is the default variety
     */
    private boolean isDefault;

    /**
     * @return This variety converted into Pokémon
     */
    public Pokemon toPokemon() {
        return Pokemon.fromName(name);
    }
}
