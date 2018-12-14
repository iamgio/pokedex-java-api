package eu.iamgio.pokedex.pokemon;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import eu.iamgio.pokedex.connection.HttpConnection;
import eu.iamgio.pokedex.exception.PokedexException;
import eu.iamgio.pokedex.pokedex.Pokedex;
import eu.iamgio.pokedex.util.NamedResource;
import eu.iamgio.pokedex.util.StringUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A Pokémon Species forms the basis for at least one Pokémon. Attributes of a Pokémon species are shared across all varieties of Pokémon within the species
 * @author Gio
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PokemonSpecies {

    /**
     * The identifier for this resource
     */
    private int id;

    /**
     * The order in which species should be sorted. Based on National Dex order, except families are grouped together and sorted by stage
     */
    private int order;

    /**
     * The chance of this Pokémon being female, in eighths; or -1 for genderless
     */
    private byte genderRate;

    /**
     * The base capture rate; up to 255. The higher the number, the easier the catch
     */
    private int captureRate;

    /**
     * The happiness when caught by a normal Pokéball; up to 255. The higher the number, the happier the Pokémon
     */
    private int baseHappiness;

    /**
     * Whether or not this is a baby Pokémon
     */
    private boolean baby;

    /**
     * Initial hatch counter: one must walk 255 × (hatch_counter + 1) steps before this Pokémon's egg hatches, unless utilizing bonuses like Flame Body's
     */
    private int hatchCounter;

    /**
     * Whether or not this Pokémon has visual gender differences
     */
    @Getter(AccessLevel.PRIVATE)
    private boolean genderDifferences;

    /**
     * Whether or not this Pokémon has multiple forms and can switch between them
     */
    private boolean formsSwitchable;

    /**
     * The rate at which this Pokémon species gains levels
     */
    private GrowthRate growthRate;

    /**
     * A list of Pokedexes and the indexes reserved within them for this Pokémon species
     */
    private HashMap<Pokedex.Type, Integer> pokedexNumbers;

    /**
     * A list of egg groups this Pokémon species is a member of
     */
    private List<EggGroup> eggGroups;

    //TODO others

    /**
     * Whether or not this Pokémon has visual gender differences
     */
    public boolean hasGenderDifferences() {
        return genderDifferences;
    }

    /**
     * @param pokemonName Name of the Pokémon
     * @return Species of Pokémon whose name matches <tt>name</tt>
     * @throws PokedexException if <tt>name</tt> doesn't match a Pokémon name
     */
    public static PokemonSpecies fromPokemonName(String pokemonName) throws PokedexException {
        JsonObject json;
        try {
            json = new HttpConnection("pokemon-species/" + pokemonName + "/").getJson();
        } catch(RuntimeException e) {
            throw new PokedexException("Could not find Pokémon with name/ID " + pokemonName);
        }
        HashMap<Pokedex.Type, Integer> pokedexNumbers = new HashMap<>();
        for(JsonElement pokedex : json.getAsJsonArray("pokedex_numbers")) {
            JsonObject pokedexObj = pokedex.getAsJsonObject();
            pokedexNumbers.put(
                    Pokedex.Type.valueOf(StringUtil.toEnumName(new NamedResource(pokedexObj.getAsJsonObject("pokedex")).getName())),
                    pokedexObj.get("entry_number").getAsInt()
            );
        }
        return new PokemonSpecies(
                json.get("id").getAsInt(),
                json.get("order").getAsInt(),
                json.get("gender_rate").getAsByte(),
                json.get("capture_rate").getAsInt(),
                json.get("base_happiness").getAsInt(),
                json.get("is_baby").getAsBoolean(),
                json.get("hatch_counter").getAsInt(),
                json.get("has_gender_differences").getAsBoolean(),
                json.get("forms_switchable").getAsBoolean(),
                GrowthRate.valueOf(StringUtil.toEnumName(new NamedResource(json.getAsJsonObject("growth_rate")).getName())),
                pokedexNumbers,
                NamedResource.getNames(json.getAsJsonArray("egg_groups"))
                    .stream()
                    .map(StringUtil::toEnumName)
                    .map(EggGroup::valueOf)
                    .collect(Collectors.toList())
        );
    }

    /**
     * @param pokemonId Identifier of the Pokémon
     * @return Species of Pokémon whose ID matches <tt>id</tt>
     * @throws PokedexException if <tt>id</tt> is 0 or less or doesn't match a Pokémon ID
     */
    public static PokemonSpecies fromPokemonId(Number pokemonId) throws PokedexException {
        return fromPokemonName(String.valueOf(pokemonId));
    }

    /**
     * @param pokemon Pokémon
     * @return Species of Pokémon
     * @throws PokedexException if an error occurred
     */
    public static PokemonSpecies fromPokemon(Pokemon pokemon) throws PokedexException {
        return fromPokemonId(pokemon.getId());
    }
}
