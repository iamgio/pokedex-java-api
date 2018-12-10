package eu.iamgio.pokedex.pokemon.move;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import eu.iamgio.pokedex.Generation;
import eu.iamgio.pokedex.connection.HttpConnection;
import eu.iamgio.pokedex.exception.PokedexException;
import eu.iamgio.pokedex.lang.LocalizedNameList;
import eu.iamgio.pokedex.lang.LocalizedNames;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.util.Flavor;
import eu.iamgio.pokedex.util.NamedResource;
import eu.iamgio.pokedex.util.StringUtil;
import eu.iamgio.pokedex.version.VersionGroup;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

/**
 * Represents a move a Pokémon can learn
 * @author Gio
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PokemonMove {

    /**
     * The identifier for this move
     */
    private int id;

    /**
     * Name of the move
     */
    private String name;

    /**
     * The percent value of how likely this move is to be successful
     */
    private int accuracy;

    /**
     * The percent value of how likely it is this moves effect will happen. <tt>null</tt> if no effect
     */
    private Integer effectChance;

    /**
     * The number of times this move can be used
     */
    private int powerPoints;

    /**
     * A value between -8 and 8. Sets the order in which moves are executed during battle
     */
    private byte priority;

    /**
     * The base power of this move
     */
    private int power;

    /**
     * The elemental type of this move
     */
    private PokemonType type;

    /**
     * The status ailment this move inflicts on its target(s)
     */
    private MoveAilment ailment;

    /**
     * The type of damage the move inflicts on the target(s)
     */
    private MoveDamageClass damageClass;

    /**
     * The category of move this move falls under
     */
    private MoveCategory category;

    /**
     * The likelihood this attack will cause an ailment
     */
    private int ailmentChance;

    /**
     * The type of target that will receive the effects of the attack
     */
    private MoveTarget target;

    /**
     * The generation in which this move was introduced
     */
    private Generation generation;

    /**
     * A list of the machines that teach this move as version_group=machine_id
     */
    private HashMap<VersionGroup, Integer> machines;

    /**
     * A list of stats this moves effects and how much it effects them
     */
    private List<MoveStatChange> statChanges;

    /**
     * The name of this move listed in different languages
     */
    private LocalizedNames localizedNames;

    /**
     * The flavor text of this move listed in different languages.
     */
    private LocalizedNameList<Flavor> flavors;

    /**
     * @param name Name of the move
     * @return Move whose name matches <tt>name</tt>
     * @throws PokedexException if <tt>name</tt> doesn't match a move name
     */
    public static PokemonMove fromName(String name) throws PokedexException {
        JsonObject json;
        try {
            json = new HttpConnection("move/" + name + "/").getJson();
        } catch(RuntimeException e) {
            throw new PokedexException("Could not find move with name/ID " + name);
        }
        JsonElement effectChance = json.get("effect_chance");
        HashMap<VersionGroup, Integer> machines = new HashMap<>();
        for(JsonElement machinesJson : json.getAsJsonArray("machines")) {
            String url = machinesJson.getAsJsonObject().getAsJsonObject("machine")
                    .get("url").getAsString();
            machines.put(
                    VersionGroup.valueOf(StringUtil.toEnumName(
                            new NamedResource(machinesJson.getAsJsonObject()
                                    .get("version_group").getAsJsonObject()).getName())),
                    Integer.parseInt(url.substring("https://pokeapi.co/api/v2/machine/".length(), url.length() - 1))
            );
        }
        JsonObject meta = json.getAsJsonObject("meta");
        return new PokemonMove(
                json.get("id").getAsInt(),
                json.get("name").getAsString(),
                json.get("accuracy").getAsInt(),
                effectChance.isJsonNull() ? null : effectChance.getAsInt(),
                json.get("pp").getAsInt(),
                json.get("priority").getAsByte(),
                json.get("power").getAsInt(),
                PokemonType.valueOf(new NamedResource(json.get("type").getAsJsonObject()).getName().toUpperCase()),
                MoveAilment.valueOf(StringUtil.toEnumName(new NamedResource(meta.get("ailment").getAsJsonObject()).getName())),
                MoveDamageClass.valueOf(new NamedResource(json.get("damage_class").getAsJsonObject()).getName().toUpperCase()),
                MoveCategory.valueOf(StringUtil.toEnumName(new NamedResource(meta.get("category").getAsJsonObject()).getName()).replace("+", "_AND_")),
                meta.get("ailment_chance").getAsInt(),
                MoveTarget.valueOf(StringUtil.toEnumName(new NamedResource(json.get("target").getAsJsonObject()).getName())),
                Generation.fromJson(json),
                machines,
                MoveStatChange.fromJson(json.getAsJsonArray("stat_changes")),
                new LocalizedNames(json.getAsJsonArray("names"), "name"),
                new LocalizedNameList<>(json.getAsJsonArray("flavor_text_entries"), "flavor_text", Flavor.class)
        );
    }

    /**
     * @param id Identifier of the move
     * @return Move whose ID matches <tt>id</tt>
     * @throws PokedexException if <tt>id</tt> is 0 or less or doesn't match a move ID
     */
    public static PokemonMove fromId(Number id) throws PokedexException {
        return fromName(String.valueOf(id));
    }
}
