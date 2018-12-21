package eu.iamgio.pokedex.lang;

import com.google.gson.JsonObject;
import eu.iamgio.pokedex.util.NamedResource;
import eu.iamgio.pokedex.version.IVersion;
import eu.iamgio.pokedex.version.Version;
import eu.iamgio.pokedex.version.VersionGroup;
import lombok.Getter;

/**
 * @author Gio
 */
public class Flavor<T extends IVersion> extends LocalizedName {

    /**
     * The version that uses this flavor text
     */
    @Getter
    private T version;

    /**
     * Loads a {@link LocalizedName} from a JSON
     * @param json JSON containing a localized name
     * @param key Name of the JSON key
     */
    @SuppressWarnings("unchecked")
    public Flavor(JsonObject json, String key, boolean isVersionGroup) {
        super(json, key);
        if(isVersionGroup) {
            this.version = (T) VersionGroup.valueOf(
                    new NamedResource(json.get("version_group")).toEnumName());
        } else {
            this.version = (T) Version.valueOf(
                    new NamedResource(json.get("version")).toEnumName());
        }
    }

    @Override
    public String toString() {
        return "Flavor{" + language + "=" + name.replace("\n", "\\n") + "; version=" + version + "}";
    }
}
