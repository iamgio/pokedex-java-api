package eu.iamgio.pokedex.pokemon.move;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The category of move this move falls under
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum MoveCategory {

    DAMAGE(0),
    AILMENT(1),
    NET_GOOD_STATS(2),
    HEAL(3),
    DAMAGE_AND_AILMENT(4),
    SWAGGER(5),
    DAMAGE_AND_LOWER(6),
    DAMAGE_AND_RAISE(7),
    DAMAGE_AND_HEAL(8),
    OHKO(9),
    WHOLE_FIELD_EFFECT(10),
    FIELD_EFFECT(11),
    FORCE_SWITCH(12),
    UNIQUE(13);

    /**
     * The identifier for this resource
     */
    private int id;
}
