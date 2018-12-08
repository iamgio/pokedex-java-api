package eu.iamgio.pokedex.lang;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Class used to represent resources listed in different languages.
 * @author Gio
 */
@AllArgsConstructor
@Getter
public class LocalizedName {

    /**
     * The localized name for an API resource in a specific language
     */
    protected String name;

    /**
     * The language this name is in
     */
    protected Language language;

    /**
     * Loads a {@link LocalizedName} from a JSON
     * @param json JSON containing a localized name
     * @param key Name of the JSON key
     */
    public LocalizedName(JsonObject json, String key) {
        this(
                json.get(key).getAsString(),
                Language.fromName(json.get("language").getAsJsonObject().get("name").getAsString())
        );
    }

    @Override
    public String toString() {
        return "LocalizedName{" + language + "=" + name.replace("\n", "\\n") + "}";
    }

    /**
     * @param array JSON array containing localized names
     * @param key Name of the JSON key
     * @return Parsed JSON into a list of {@link LocalizedName}
     * @see LocalizedNames
     */
    public static LocalizedNames fromJsonArray(JsonArray array, String key) {
        return new LocalizedNames(array, key);
    }
}
