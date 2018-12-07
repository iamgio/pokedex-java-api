package eu.iamgio.pokedex.lang;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.util.ArrayList;

/**
 * List of localized names
 * @author Gio
 */
public class LocalizedNames extends ArrayList<LocalizedName> {

    /**
     * Loads a list of {@link LocalizedName} from JSON
     * @param array JSON array containing localized names
     */
    public LocalizedNames(JsonArray array) {
        for(JsonElement json : array) {
            add(LocalizedName.fromJson(json.getAsJsonObject()));
        }
    }

    public LocalizedNames() {}

    /**
     * @param language Target language
     * @return {@link LocalizedName} using that language
     */
    public LocalizedName get(Language language) {
        for(LocalizedName name : this) {
            if(name.getLanguage() == language) {
                return name;
            }
        }
        return null;
    }
}
