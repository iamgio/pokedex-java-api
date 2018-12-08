package eu.iamgio.pokedex.version;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * List of available versions of the game
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum Version {

    RED(1, VersionGroup.RED_BLUE),
    BLUE(2, VersionGroup.RED_BLUE),
    YELLOW(3, VersionGroup.YELLOW),
    GOLD(4, VersionGroup.GOLD_SILVER),
    SILVER(5, VersionGroup.GOLD_SILVER),
    CRYSTAL(6, VersionGroup.CRYSTAL),
    RUBY(7, VersionGroup.RUBY_SAPPHIRE),
    SAPPHIRE(8, VersionGroup.RUBY_SAPPHIRE),
    EMERALD(9, VersionGroup.EMERALD),
    FIRERED(10, VersionGroup.FIRERED_LEAFGREEN),
    LEAFGREEN(11, VersionGroup.FIRERED_LEAFGREEN),
    DIAMOND(12, VersionGroup.DIAMOND_PEARL),
    PEARL(13, VersionGroup.DIAMOND_PEARL),
    PLATINUM(14, VersionGroup.PLATINUM),
    HEARTGOLD(15, VersionGroup.HEARTGOLD_SOULSILVER),
    SOULSILVER(16, VersionGroup.HEARTGOLD_SOULSILVER),
    BLACK(17, VersionGroup.BLACK_WHITE),
    WHITE(18, VersionGroup.BLACK_WHITE),
    COLOSSEUM(19, VersionGroup.COLOSSEUM),
    XD(20, VersionGroup.XD),
    BLACK_2(21, VersionGroup.BLACK_2_WHITE_2),
    WHITE_2(22, VersionGroup.BLACK_2_WHITE_2),
    X(23, VersionGroup.X_Y),
    Y(24, VersionGroup.X_Y),
    OMEGA_RUBY(25, VersionGroup.OMEGA_RUBY_ALPHA_SAPPHIRE),
    ALPHA_SAPPHIRE(26, VersionGroup.OMEGA_RUBY_ALPHA_SAPPHIRE),
    SUN(27, VersionGroup.SUN_MOON),
    MOON(28, VersionGroup.SUN_MOON);

    /**
     * The identifier for this version
     */
    private int id;

    /**
     * Group the version is in
     */
    private VersionGroup group;
}
