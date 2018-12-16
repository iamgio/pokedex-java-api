package eu.iamgio.pokedex.lang;

import com.google.gson.JsonArray;
import eu.iamgio.pokedex.version.IVersion;

import java.util.List;
import java.util.stream.Collectors;

/**
 * List of {@link Flavor}s
 * @author Gio
 */
public class FlavorList<T extends IVersion> extends LocalizedNameList<Flavor<T>> {

    /**
     * Loads a list of {@link Flavor} from JSON
     * @param array JSON array containing localized names
     * @param key Name of the JSON key
     * @param isVersionGroup Whether or not the flavors are based on version groups
     */
    public FlavorList(JsonArray array, String key, boolean isVersionGroup) {
        super(array, key, (byte) (isVersionGroup ? 0 : 1));
    }

    /**
     * Loads a list of {@link Flavor} from another list
     * @param flavors List
     */
    public FlavorList(List<Flavor<T>> flavors) {
        super(flavors);
    }

    public FlavorList() {}

    /**
     * Filters the list by version
     * @param version {@link eu.iamgio.pokedex.version.Version} or {@link eu.iamgio.pokedex.version.VersionGroup}
     * @return Filtered copy of this list with flavors matching this version
     */
    public FlavorList filterVersion(T version) {
        return this.stream().filter(flavor -> flavor.getVersion().equals(version))
                .collect(Collectors.toCollection(FlavorList::new));
    }
}
