package eu.iamgio.pokedex;

import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.pokemon.PokemonType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gio
 */
class Tests {

    @Test
    void testBulbasaur() {
        Pokemon bulbasaur = Pokemon.byName("bulbasaur");
        assertEquals("bulbasaur", bulbasaur.getName());
        assertEquals(1, bulbasaur.getId());
        assertEquals(7, bulbasaur.getHeight());
        assertEquals(69, bulbasaur.getWeight());
        assertEquals(64, bulbasaur.getBaseExperience());
        assertArrayEquals(bulbasaur.getTypes(), new PokemonType[] {PokemonType.GRASS, PokemonType.POISON});
    }
}
