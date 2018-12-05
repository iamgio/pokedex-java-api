package eu.iamgio.pokedex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gio
 */
class Tests {

    @Test
    void testBulbasaur() {
        Pokemon bulbasaur = Pokemon.byName("bulbasaur");
        assertEquals(bulbasaur.getName(), "bulbasaur");
        assertEquals(bulbasaur.getId(), 1);
        assertEquals(bulbasaur.getHeight(), 7);
        assertEquals(bulbasaur.getWeight(), 69);
        assertEquals(bulbasaur.getBaseExperience(), 64);
    }
}
