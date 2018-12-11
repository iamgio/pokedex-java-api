package eu.iamgio.pokedex.pokemon.encounter;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A list of onditions which affect what Pokémon might appear in the wild
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum EncounterConditionValue {

    SWARM_YES(1),
    SWARM_NO(2),
    TIME_MORNING(3),
    TIME_DAY(4),
    TIME_NIGHT(5),
    RADAR_ON(6),
    RADAR_OFF(7),
    SLOT2_NONE(8),
    SLOT2_RUBY(9),
    SLOT2_SAPPHIRE(10),
    SLOT2_EMERALD(11),
    SLOT2_FIRERED(12),
    SLOT2_LEAFGREEN(13),
    RADIO_OFF(14),
    RADIO_HOENN(15),
    RADIO_SINNOH(16),
    SEASON_SPRING(17),
    SEASON_SUMMER(18),
    SEASON_AUTUMN(19),
    SEASON_WINTER(20);

    /**
     * Identifier for this resource
     */
    private int id;
}
