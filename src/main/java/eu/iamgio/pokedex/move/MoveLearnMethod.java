package eu.iamgio.pokedex.move;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A list of methods in which Pokémon can learn moves
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum MoveLearnMethod {

    LEVEL_UP(1),
    EGG(2),
    TUTOR(3),
    MACHINE(4),
    STADIUM_SURFING_PIKACHU(5),
    LIGHT_BALL_EGG(6),
    COLOSSEUM_PURIFICATION(7),
    XD_SHADOW(8),
    XD_PURIFICATION(9),
    FORM_CHANGE(10);

    /**
     * The identifier for this method
     */
    private int id;
}
