package eu.iamgio.pokedex;

import eu.iamgio.pokedex.lang.Language;
import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.pokemon.PokemonAbility;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.pokemon.Sprite;
import eu.iamgio.pokedex.pokemon.move.*;
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
        assertEquals("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
                bulbasaur.getSprite(Sprite.Type.FRONT_DEFAULT).getUrl());
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

    @Test
    void testBodySlam() {
        PokemonMove move = PokemonMove.fromName("body-slam");
        assertEquals(100, move.getAccuracy());
        assertEquals(30, (int) move.getEffectChance());
        assertEquals(85, move.getPower());
        assertEquals(15, move.getPowerPoints());
        assertEquals(0, move.getPriority());
        assertEquals(120, (int) move.getMachines().get(VersionGroup.RED_BLUE));
        assertEquals(Generation.GENERATION_I, move.getGeneration());
        assertNotEquals("[]", move.getFlavors().toString());
        assertEquals("Body Slam", move.getLocalizedNames().get(Language.ENGLISH).getName());
        assertEquals(PokemonType.NORMAL, move.getType());
        assertEquals(MoveAilment.PARALYSIS, move.getAilment());
        assertEquals(30, move.getAilmentChance());
        assertEquals(MoveTarget.SELECTED_POKEMON, move.getTarget());
        assertEquals(MoveCategory.DAMAGE_AND_AILMENT, move.getCategory());
        assertEquals(MoveDamageClass.PHYSICAL, move.getDamageClass());
    }
}
