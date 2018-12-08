package eu.iamgio.pokedex;

import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.pokemon.PokemonAbility;
import eu.iamgio.pokedex.pokemon.PokemonType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gio
 */
class Tests {

    @Test
    void testBulbasaur() {
        Pokemon bulbasaur = Pokemon.fromName("bulbasaur");
        assertEquals("bulbasaur", bulbasaur.getName());
        assertEquals(1, bulbasaur.getId());
        assertEquals(7, bulbasaur.getHeight());
        assertEquals(69, bulbasaur.getWeight());
        assertEquals(64, bulbasaur.getBaseExperience());
        assertArrayEquals(new PokemonType[] {PokemonType.GRASS, PokemonType.POISON}, bulbasaur.getTypes());
    }

    @Test
    void testLevitate() {
        PokemonAbility levitate = PokemonAbility.fromName("levitate");
        assertEquals(26, levitate.getId());
        assertEquals(true, levitate.isMainSeries());
        assertEquals(Generation.GENERATION_III, levitate.getGeneration());
        assertNotEquals("[]", levitate.getLocalizedNames().toString());
        assertNotEquals("[]", levitate.getFlavors().toString());
    }
}
