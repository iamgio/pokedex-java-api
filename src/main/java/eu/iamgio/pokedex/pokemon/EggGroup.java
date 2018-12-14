package eu.iamgio.pokedex.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A list of egg groups a Pokémon is a member of
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum EggGroup {

    MONSTER(1),
    WATER1(2),
    BUG(3),
    FLYING(4),
    GROUND(5),
    FAIRY(6),
    PLANT(7),
    HUMANSHAPE(8),
    WATER3(9),
    MINERAL(10),
    INDETERMINATE(11),
    WATER2(12),
    DITTO(13),
    DRAGON(14),
    NO_EGGS(15);

    /**
     * The identifier for this group
     */
    private int id;
}
