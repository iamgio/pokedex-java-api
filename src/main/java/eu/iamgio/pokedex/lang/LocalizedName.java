package eu.iamgio.pokedex.lang;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Class used to represent resources listed in different languages.
 * @author Gio
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class LocalizedName {

    /**
     * The localized name for an API resource in a specific language
     */
    private String name;

    /**
     * The language this name is in
     */
    private Language language;

    /**
     * @param json JSON containing a localized name
     * @return Parsed JSON into {@link LocalizedName}
     */
    public static LocalizedName fromJson(JsonObject json) {
        return new LocalizedName(
                json.get("name").getAsString(),
                Language.fromName(json.get("language").getAsJsonObject().get("name").getAsString())
        );
    }

    /**
     * @param array JSON array containing localized names
     * @return Parsed JSON into a list of {@link LocalizedName}
     * @see LocalizedNames
     */
    public static LocalizedNames fromJsonArray(JsonArray array) {
        return new LocalizedNames(array);
    }
}
