package eu.iamgio.pokedex.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents sprites used in the game
 * @author Gio
 */
@AllArgsConstructor
@Getter
public class Sprite {

    /**
     * The type of the sprite
     */
    private Type type;

    /**
     * URL to the image file
     */
    private String url;

    /**
     * A list of available sprite types
     */
    public enum Type {

        /**
         * The default depiction from the front in battle
         */
        FRONT_DEFAULT,

        /**
         * The shiny depiction from the front in battle
         */
        FRONT_SHINY,

        /**
         * The female depictionfrom the front in battle
         */
        FRONT_FEMALE,

        /**
         * The shiny female depiction from the front in battle.
         */
        FRONT_SHINY_FEMALE,

        /**
         * 	The default depiction from the back in battle
         */
        BACK_DEFAULT,

        /**
         * The shiny depiction from the back in battle
         */
        BACK_SHINY,

        /**
         * The female depiction from the back in battle
         */
        BACK_FEMALE,

        /**
         * The shiny female depiction of this Pokémon from the back in battle
         */
        BACK_SHINY_FEMALE
    }
}
