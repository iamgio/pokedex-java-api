package eu.iamgio.pokedex.item;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import eu.iamgio.pokedex.Generation;
import eu.iamgio.pokedex.connection.HttpConnection;
import eu.iamgio.pokedex.exception.PokedexException;
import eu.iamgio.pokedex.lang.FlavorList;
import eu.iamgio.pokedex.lang.LocalizedNames;
import eu.iamgio.pokedex.util.NamedResource;
import eu.iamgio.pokedex.util.StringUtil;
import eu.iamgio.pokedex.version.VersionGroup;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An item is an object in the games which the player can pick up, keep in their bag, and use in some manner. They have various uses, including healing, powering up, helping catch Pokémon, or to access a new area
 * @author Gio
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Item {

    /**
     * 	The identifier for this resource
     */
    private int id;

    /**
     * The name for this item
     */
    private String name;

    /**
     * The price of this item in stores
     */
    private int cost;

    /**
     * A list of attributes this item has
     */
    private List<ItemAttribute> attributes;

    /**
     * The power of the move Fling when used with this item. Null if no fling
     */
    private Integer flingPower;

    /**
     * The effect of the move Fling when used with this item. Null if no fling
     */
    private ItemFlingEffect flingEffect;

    /**
     * The category of items this item falls into
     */
    private ItemCategory category;

    /**
     * The sprite used to depict this item in the game
     */
    private String sprite;

    /**
     * A list of Pokémon that might be found in the wild holding this item
     */
    private List<ItemHold> heldByPokemon;

    //TODO babyTriggerFor

    /**
     * A list of game indices relevent to this item by generation
     */
    private HashMap<Generation, Integer> gameIndices;

    /**
     * A list of the machines (as IDs) related to this item
     */
    private HashMap<VersionGroup, Integer> machines;

    /**
     * The name of this item listed in different languages
     */
    private LocalizedNames localizedNames;

    /**
     * The flavor text of this item listed in different languages
     */
    private FlavorList<VersionGroup> flavors;

    /**
     * @param name Name of the item
     * @return Item whose name matches <tt>name</tt>
     * @throws PokedexException if <tt>name</tt> doesn't match an item name
     */
    public static Item fromName(String name) throws PokedexException {
        JsonObject json;
        try {
            json = new HttpConnection("item/" + name + "/").getJson();
        } catch(RuntimeException e) {
            throw new PokedexException("Could not find item with name/ID " + name);
        }
        HashMap<Generation, Integer> gameIndices = new HashMap<>();
        for(JsonElement gameIndice : json.getAsJsonArray("game_indices")) {
            JsonObject object = gameIndice.getAsJsonObject();
            gameIndices.put(Generation.fromJson(object), object.get("game_index").getAsInt());
        }
        HashMap<VersionGroup, Integer> machines = new HashMap<>();
        for(JsonElement machine : json.getAsJsonArray("machines")) {
            JsonObject object = machine.getAsJsonObject();
            String url = object.getAsJsonObject("machine").get("url").getAsString();
            machines.put(
                    VersionGroup.valueOf(new NamedResource(object.get("version_group")).toEnumName()),
                    Integer.parseInt(url.substring("https://pokeapi.co/api/v2/machine/".length(), url.length() - 1))
            );
        }
        JsonElement flingPower = json.get("fling_power");
        JsonElement flingEffect = json.get("fling_effect");
        return new Item(
                json.get("id").getAsInt(),
                json.get("name").getAsString(),
                json.get("cost").getAsInt(),
                NamedResource.getNames(json.getAsJsonArray("attributes"))
                    .stream()
                    .map(StringUtil::toEnumName)
                    .map(ItemAttribute::valueOf)
                    .collect(Collectors.toList()),
                flingPower.isJsonNull() ? null : flingPower.getAsInt(),
                flingEffect.isJsonNull() ? null :
                        ItemFlingEffect.valueOf(new NamedResource(flingEffect).toEnumName()),
                ItemCategory.valueOf(new NamedResource(json.get("category")).toEnumName()),
                json.getAsJsonObject("sprites").get("default").getAsString(),
                ItemHold.fromJson(json.getAsJsonArray("held_by_pokemon"), false),
                gameIndices,
                machines,
                new LocalizedNames(json.getAsJsonArray("names"), "name"),
                new FlavorList<>(json.getAsJsonArray("flavor_text_entries"), "text", true)
        );
    }

    /**
     * @param id Identifier of the item
     * @return Item whose ID matches <tt>id</tt>
     * @throws PokedexException if <tt>id</tt> is 0 or less or doesn't match an item ID
     */
    public static Item fromId(Number id) throws PokedexException {
        return fromName(String.valueOf(id));
    }
}
