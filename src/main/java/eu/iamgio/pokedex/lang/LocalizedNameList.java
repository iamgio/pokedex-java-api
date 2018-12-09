package eu.iamgio.pokedex.lang;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import eu.iamgio.pokedex.util.Flavor;

import java.util.ArrayList;

/**
 * List of localized names
 * @author Gio
 */
@SuppressWarnings("unchecked")
public class LocalizedNameList<T extends LocalizedName> extends ArrayList<T> {

    /**
     * Loads a list of {@link LocalizedName} from JSON
     * @param array JSON array containing localized names
     * @param key Name of the JSON key
     */
    public LocalizedNameList(JsonArray array, String key, Class<T> clazz) {
        this();
        if(this instanceof LocalizedNames) {
            for(JsonElement json : array) {
                add((T) new LocalizedName(json.getAsJsonObject(), key));
            }
        } else if(clazz.isAssignableFrom(Flavor.class)) {
            for(JsonElement json : array) {
                add((T) new Flavor(json.getAsJsonObject()));
            }
        }
    }

    public LocalizedNameList() {}

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
