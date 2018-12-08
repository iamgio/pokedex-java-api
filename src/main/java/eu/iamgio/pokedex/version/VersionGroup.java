package eu.iamgio.pokedex.version;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
     * Identifier of this language
     */
    private int id;
}
