package eu.iamgio.pokedex;

import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.pokemon.PokemonAbility;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.pokemon.move.MoveLearnMethod;
import eu.iamgio.pokedex.pokemon.move.PokemonPersonalMove;
import eu.iamgio.pokedex.version.Version;
import eu.iamgio.pokedex.version.VersionGroup;
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
        assertEquals(153, (int) bulbasaur.getGameIndices().get(Version.YELLOW));
        PokemonPersonalMove.VersionGroupDetail leechSeed = bulbasaur.getMove("leech-seed").getGroupDetails().get(0);
        assertEquals(VersionGroup.OMEGA_RUBY_ALPHA_SAPPHIRE, leechSeed.getGroup());
        assertEquals(MoveLearnMethod.LEVEL_UP, leechSeed.getLearnMethod());
        assertEquals(7, leechSeed.getLevelLearnedAt());
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

    @Test
    void testDiamondPearl() {
        VersionGroup.LoadedVersionGroup group = VersionGroup.DIAMOND_PEARL.load();
        assertEquals(Generation.GENERATION_IV, group.getGeneration());
        assertEquals(8, group.getId());
        assertEquals(10, group.getOrder());
        assertArrayEquals(new Version[] {Version.DIAMOND, Version.PEARL}, group.getVersions());
        assertNotEquals("[]", group.getMoveLearnMethods());
    }
}
