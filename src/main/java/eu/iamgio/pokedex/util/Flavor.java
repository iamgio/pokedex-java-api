package eu.iamgio.pokedex.util;

import com.google.gson.JsonObject;
import eu.iamgio.pokedex.lang.LocalizedName;
import eu.iamgio.pokedex.version.VersionGroup;
import lombok.Getter;

/**
 * @author Gio
 */
public class Flavor extends LocalizedName {

    /**
     * The version group that uses this flavor text
     */
    @Getter
    private VersionGroup group;

    /**
     * Loads a {@link LocalizedName} from a JSON
     * @param json JSON containing a localized name
     */
    public Flavor(JsonObject json) {
        super(json, "flavor_text");
        this.group = VersionGroup.valueOf(StringUtil.toEnumName(json.get("version_group").getAsJsonObject()
                .get("name").getAsString()));
    }

    @Override
    public String toString() {
        return "Flavor{" + language + "=" + name.replace("\n", "\\n") + "; version=" + group + "}";
    }
}
