package eu.iamgio.pokedex.pokedex;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * TODO
 * @author Gio
 */
public class Pokedex {

    /**
     * A list of available Pokédex types
     */
    @AllArgsConstructor
    @Getter
    public enum Type {

        NATIONAL(1),
        KANTO(2),
        ORIGINAL_JOHTO(3),
        HOENN(4),
        ORIGINAL_SINNOH(5),
        EXTENDED_SINNOH(6),
        UPDATED_JOHTO(7),
        ORIGINAL_UNOVA(8),
        UPDATED_UNOVA(9),
        CONQUEST_GALLERY(11),
        KALOS_CENTRAL(12),
        KALOS_COASTAL(13),
        KALOS_MOUNTAIN(14),
        UPDATED_HOENN(15);

        /**
         * The identifier for this resource
         */
        private int id;
    }
}
