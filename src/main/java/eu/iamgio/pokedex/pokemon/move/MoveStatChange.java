package eu.iamgio.pokedex.pokemon.move;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import eu.iamgio.pokedex.pokemon.Stat;
import eu.iamgio.pokedex.util.NamedResource;
import eu.iamgio.pokedex.util.StringUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a stat a moves effects and how much it effects it
 * @author Gio
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MoveStatChange {

    /**
     * The amount of change
     */
    private int change;

    /**
     * The stat being affected
     */
    private Stat stat;

    /**
     * @param json JSON array containing data
     * @return JSON array to {@link MoveStatChange} list
     */
    public static List<MoveStatChange> fromJson(JsonArray json) {
        List<MoveStatChange> changes = new ArrayList<>();
        for(JsonElement change : json) {
            JsonObject obj = change.getAsJsonObject();
            changes.add(new MoveStatChange(
                    obj.get("change").getAsInt(),
                    Stat.valueOf(StringUtil.toEnumName(new NamedResource(obj.getAsJsonObject("stat")).getName()))
            ));
        }
        return changes;
    }
}
