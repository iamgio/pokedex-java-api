package eu.iamgio.pokedex.util;

import com.google.gson.JsonObject;
import eu.iamgio.pokedex.lang.LocalizedName;
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
     */
    @SuppressWarnings("unchecked")
    public Flavor(JsonObject json, boolean isVersionGroup) {
        super(json, "flavor_text");
        if(isVersionGroup) {
            this.version = (T) VersionGroup.valueOf(
                    StringUtil.toEnumName(new NamedResource(json.getAsJsonObject("version_group")).getName()));
        } else {
            this.version = (T) Version.valueOf(
                    StringUtil.toEnumName(new NamedResource(json.getAsJsonObject("version")).getName()));
        }
    }

    @Override
    public String toString() {
        return "Flavor{" + language + "=" + name.replace("\n", "\\n") + "; version=" + version + "}";
    }
}
