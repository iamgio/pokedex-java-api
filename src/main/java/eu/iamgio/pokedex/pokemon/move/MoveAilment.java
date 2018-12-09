package eu.iamgio.pokedex.pokemon.move;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * List of available status ailment moves can inflicts on targets
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum MoveAilment {

    UNKNOWN(-1),
    NONE(0),
    PARALYSIS(1),
    SLEEP(2),
    FREEZE(3),
    BURN(4),
    POISON(5),
    CONFUSION(6),
    INFATUATION(7),
    TRAP(8),
    NIGHTMARE(10),
    TORMENT(11),
    DISABLE(12),
    YAWN(13),
    HEAL_BLOCK(14),
    NO_TYPE_IMMUNITY(15),
    LEECH_SEED(16),
    EMBARGO(17),
    PERISH_SONG(18),
    INGRAIN(18),
    SILENCE(19);

    /**
     * The identifier for this resource
     */
    private int id;
}
