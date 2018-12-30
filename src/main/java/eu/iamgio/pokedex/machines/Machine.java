package eu.iamgio.pokedex.machines;

import com.google.gson.JsonObject;
import eu.iamgio.pokedex.connection.HttpConnection;
import eu.iamgio.pokedex.exception.PokedexException;
import eu.iamgio.pokedex.util.NamedResource;
import eu.iamgio.pokedex.version.VersionGroup;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Representation of items that teach moves to Pokémon. They vary from version to version, so it is not certain that one specific TM or HM corresponds to a single Machine
 * @author Gio
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Machine {

    /**
     * The identifier for this machine
     */
    private int id;

    /**
     * The TM or HM itemName that corresponds to this machine
     */
    private String itemName;

    /**
     * The move that is taught by this machine
     */
    private String moveName;

    /**
     * The version group that this machine applies to
     */
    private VersionGroup versionGroup;

    /**
     * @param id Identifier of the machine
     * @return Machine whose ID matches <tt>id</tt>
     * @throws PokedexException if <tt>id</tt> is 0 or less or doesn't match a machine ID
     */
    public static Machine fromId(Number id) throws PokedexException {
        JsonObject json;
        try {
            json = new HttpConnection("machine/" + id + "/").getJson();
        } catch(RuntimeException e) {
            throw new PokedexException("Could not find machine with ID " + id);
        }
        return new Machine(
                json.get("id").getAsInt(),
                new NamedResource(json.getAsJsonObject("item")).getName(),
                new NamedResource(json.getAsJsonObject("move")).getName(),
                VersionGroup.valueOf(new NamedResource(json.getAsJsonObject("version_group")).toEnumName())
        );
    }
}
