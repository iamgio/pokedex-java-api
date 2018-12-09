package eu.iamgio.pokedex.pokemon.move;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import eu.iamgio.pokedex.connection.HttpConnection;
import eu.iamgio.pokedex.exception.PokedexException;
import eu.iamgio.pokedex.util.NamedResource;
import eu.iamgio.pokedex.util.StringUtil;
import eu.iamgio.pokedex.version.VersionGroup;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

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
     * A list of the machines that teach this move as version_group=machine_id
     */
    private HashMap<VersionGroup, Integer> machines;

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
        return new PokemonMove(
                json.get("id").getAsInt(),
                json.get("name").getAsString(),
                json.get("accuracy").getAsInt(),
                effectChance.isJsonNull() ? null : effectChance.getAsInt(),
                json.get("pp").getAsInt(),
                json.get("priority").getAsByte(),
                json.get("power").getAsInt(),
                machines
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
