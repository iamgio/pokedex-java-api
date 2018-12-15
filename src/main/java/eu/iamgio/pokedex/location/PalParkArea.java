package eu.iamgio.pokedex.location;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The pal park area where an encounter happens
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum PalParkArea {

    FOREST(1),
    FIELD(2),
    MOUNTAIN(3),
    POND(4),
    SEA(5);

    /**
     * The identifier for this resource
     */
    private int id;
}
