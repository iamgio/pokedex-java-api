package eu.iamgio.pokedex.version;

import com.google.gson.JsonObject;
import eu.iamgio.pokedex.Generation;
import eu.iamgio.pokedex.connection.HttpConnection;
import eu.iamgio.pokedex.move.MoveLearnMethod;
import eu.iamgio.pokedex.util.NamedResource;
import eu.iamgio.pokedex.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * List of available version groups of the game
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum VersionGroup {

    RED_BLUE(1),
    YELLOW(2),
    GOLD_SILVER(3),
    CRYSTAL(4),
    RUBY_SAPPHIRE(5),
    EMERALD(6),
    FIRERED_LEAFGREEN(7),
    DIAMOND_PEARL(8),
    PLATINUM(9),
    HEARTGOLD_SOULSILVER(10),
    BLACK_WHITE(11),
    COLOSSEUM(12),
    XD(13),
    BLACK_2_WHITE_2(14),
    X_Y(15),
    OMEGA_RUBY_ALPHA_SAPPHIRE(16),
    SUN_MOON(17);

    /**
     * Identifier of this group
     */
    private int id;

    /**
     * Loads information
     * @return {@link VersionGroup} with additional information
     */
    public LoadedVersionGroup load() {
        JsonObject json = new HttpConnection("version-group/" + id + "/").getJson();
        return new LoadedVersionGroup(
                id,
                json.get("order").getAsInt(),
                Generation.valueOf(StringUtil.toEnumName(new NamedResource(json.get("generation").getAsJsonObject()).getName())),
                NamedResource.getNames(json.getAsJsonArray("versions"))
                        .stream()
                        .map(StringUtil::toEnumName)
                        .map(Version::valueOf)
                        .toArray(Version[]::new),
                NamedResource.getNames(json.getAsJsonArray("move_learn_methods"))
                        .stream()
                        .map(StringUtil::toEnumName)
                        .map(MoveLearnMethod::valueOf)
                        .collect(Collectors.toList())
        );
    }

    @AllArgsConstructor
    @Getter
    public static class LoadedVersionGroup {

        /**
         * Identifier of this group
         */
        private int id;

        /**
         * Order for sorting. Almost by date of release, except similar versions are grouped together
         */
        private int order;

        /**
         * The generation this version was introduced in
         */
        private Generation generation;

        /**
         * Versions this group contains
         */
        private Version[] versions;

        /**
         * A list of methods in which Pokémon can learn moves in this version group
         */
        private List<MoveLearnMethod> moveLearnMethods;
    }
}
