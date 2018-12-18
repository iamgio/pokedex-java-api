package eu.iamgio.pokedex.item;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 	A list of attributes an item can have
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum ItemAttribute {

    COUNTABLE(1),
    CONSUMABLE(2),
    USABLE_OVERWORLD(3),
    USABLE_IN_BATTLE(4),
    HOLDABLE(5),
    HOLDABLE_PASSIVE(6),
    HOLDABLE_ACTIVE(7),
    UNDERGROUND(8);

    /**
     * The identifier for this resource
     */
    private int id;
}
