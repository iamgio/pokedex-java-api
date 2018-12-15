package eu.iamgio.pokedex.pokemon.encounter;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import eu.iamgio.pokedex.location.PalParkArea;
import eu.iamgio.pokedex.util.NamedResource;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Encounter that can be had with a Pokémon in pal park
 * @author Gio
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PalParkEncounter {

    /**
     * The base score given to the player when the referenced Pokémon is caught during a pal park run
     */
    private int baseScore;

    /**
     * The base rate for encountering the referenced Pokémon in this pal park area
     */
    private int rate;

    /**
     * The pal park area where this encounter happens
     */
    private PalParkArea area;

    /**
     * @param json Raw JSON containing data
     * @return Parsed JSON into list of {@link PalParkEncounter}
     */
    public static List<PalParkEncounter> fromJson(JsonArray json) {
        List<PalParkEncounter> list = new ArrayList<>();
        for(JsonElement element : json) {
            JsonObject object = element.getAsJsonObject();
            list.add(new PalParkEncounter(
                    object.get("base_score").getAsInt(),
                    object.get("rate").getAsInt(),
                    PalParkArea.valueOf(new NamedResource(object.getAsJsonObject("area")).getName().toUpperCase())
            ));
        }
        return list;
    }
}
