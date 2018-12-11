package eu.iamgio.pokedex.pokemon.encounter;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Methods by which the player might can encounter Pokémon in the wild
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum EncounterMethod {

    WALK(1),
    OLD_ROD(2),
    GOOD_ROD(3),
    SUPER_ROD(4),
    SURF(5),
    ROCK_SMASH(6),
    HEADBUTT(7),
    DARK_GRASS(8),
    GRASS_SPOTS(9),
    CAVE_SPOTS(10),
    BRIDGE_SPOTS(11),
    SUPER_ROD_SPOTS(12),
    SURF_SPOTS(13),
    YELLOW_FLOWERS(14),
    PURPLE_FLOWERS(15),
    RED_FLOWERS(16),
    ROUGH_TERRAIN(17);

    /**
     * Indentifier for this method
     */
    private int id;
}
