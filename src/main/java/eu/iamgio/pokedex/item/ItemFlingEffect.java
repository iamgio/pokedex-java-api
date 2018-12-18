package eu.iamgio.pokedex.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The effect of the move Fling when used with an item
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum ItemFlingEffect {

    BADLY_POISON(1),
    BURN(2),
    BERRY_EFFECT(3),
    HERB_EFFECT(4),
    PARALYZE(5),
    POISON(6),
    FLINCH(7);

    /**
     * The identifier for this resource
     */
    private int id;
}
