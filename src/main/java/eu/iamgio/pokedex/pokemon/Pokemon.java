package eu.iamgio.pokedex.pokemon;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import eu.iamgio.pokedex.connection.HttpConnection;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a Pokémon from the Pokédex
 * @author Gio
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Pokemon {

    /**
     * Name of this Pokémon (lower case)
     */
    private String name;

    /**
     * Identifier of this Pokémon
     */
    private int id;

    /**
     * Order for sorting. Almost national order, except families are grouped together
     */
    private int order;

    /**
     * The height of this Pokémon in decimetres
     */
    private int height;

    /**
     * The weight of this Pokémon in hectograms
     */
    private int weight;

    /**
     * Base experience gained for defeating this Pokémon
     */
    private int baseExperience;

    /**
     * A list of types this Pokémon has
     */
    private PokemonType[] types;

    /**
     * @param name Name of the Pokémon
     * @return Pokémon whose name matches <tt>name</tt>
     */
    public static Pokemon byName(String name) {
        JsonObject json = new HttpConnection("pokemon/" + name + "/").getJson();
        List<PokemonType> types = new ArrayList<>();
        for(JsonElement type : json.getAsJsonArray("types")) {
            types.add(PokemonType.valueOf(type.getAsJsonObject()
                    .get("type").getAsJsonObject()
                    .get("name").getAsString().toUpperCase()));
        }
        Collections.reverse(types);
        return new Pokemon(
                json.get("name").getAsString(),
                json.get("id").getAsInt(),
                json.get("order").getAsInt(),
                json.get("height").getAsInt(),
                json.get("weight").getAsInt(),
                json.get("base_experience").getAsInt(),
                types.toArray(new PokemonType[types.size()])
        );
    }

    /**
     * @param id Identifier of the Pokémon
     * @return Pokémon whose ID matches <tt>id</tt>
     */
    public static Pokemon byId(int id) {
        return byName(String.valueOf(id));
    }
}
