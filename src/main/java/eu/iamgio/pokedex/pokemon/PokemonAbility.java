package eu.iamgio.pokedex.pokemon;

import com.google.gson.JsonObject;
import eu.iamgio.pokedex.Generation;
import eu.iamgio.pokedex.connection.HttpConnection;
import eu.iamgio.pokedex.exception.PokedexException;
import eu.iamgio.pokedex.lang.LocalizedNameList;
import eu.iamgio.pokedex.lang.LocalizedNames;
import eu.iamgio.pokedex.util.Flavor;
import eu.iamgio.pokedex.version.VersionGroup;
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
     * The generation this ability originated in
     */
    private Generation generation;

    /**
     * The name of this ability listed in different languages
     */
    private LocalizedNames localizedNames;

    /**
     * The flavor text of this ability listed in different languages.
     */
    private LocalizedNameList<Flavor<VersionGroup>> flavors;

    /**
     * @param name Name of the ability
     * @return Ability whose name matches <tt>name</tt>
     * @throws PokedexException if <tt>name</tt> doesn't match an ability name
     */
    public static PokemonAbility fromName(String name) throws PokedexException {
        JsonObject json;
        try {
            json = new HttpConnection("ability/" + name + "/").getJson();
        } catch(RuntimeException e) {
            throw new PokedexException("Could not find ability with name/ID " + name);
        }
        return new PokemonAbility(
                json.get("id").getAsInt(),
                json.get("name").getAsString(),
                json.get("is_main_series").getAsBoolean(),
                Generation.fromJson(json),
                new LocalizedNames(json.getAsJsonArray("names"), "name"),
                new LocalizedNameList<>(json.getAsJsonArray("flavor_text_entries"), "flavor_text", (byte) 0)
        );
    }

    /**
     * @param id Identifier of the ability
     * @return Ability whose ID matches <tt>id</tt>
     * @throws PokedexException if <tt>id</tt> is 0 or less or doesn't match an ability ID
     */
    public static PokemonAbility fromId(Number id) throws PokedexException {
        return fromName(String.valueOf(id));
    }
}