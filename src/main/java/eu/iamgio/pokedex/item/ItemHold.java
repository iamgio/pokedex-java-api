package eu.iamgio.pokedex.item;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import eu.iamgio.pokedex.util.JsonStream;
import eu.iamgio.pokedex.util.NamedResource;
import eu.iamgio.pokedex.version.Version;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Pokémon that might be found in the wild holding a specific item.
 * @author Gio
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ItemHold {

    /**
     * Name of the Pokémon that holds this item or the item the referenced Pokémon holds
     */
    private String name;

    /**
     * How often the Pokémon holds this item in every version
     */
    private Map<Version, Integer> versionDetails;

    /**
     * @param json JSON containing data
     * @return Parsed JSON into {@link ItemHold}
     */
    public static List<ItemHold> fromJson(JsonArray json, boolean ofPokemon) {
        return new JsonStream(json)
                .stream()
                .map(JsonElement::getAsJsonObject)
                .map(holder -> new ItemHold(
                        new NamedResource(holder.get(ofPokemon ? "item" : "pokemon")).getName(),
                        new JsonStream(holder.getAsJsonArray("version_details"))
                                .stream()
                                .map(JsonElement::getAsJsonObject)
                                .collect(Collectors.toMap(
                                        detail -> Version.valueOf(new NamedResource(detail.get("version")).toEnumName()),
                                        detail -> detail.get("rarity").getAsInt()
                                ))
                ))
                .collect(Collectors.toList());
    }
}