package eu.iamgio.pokedex;

import com.google.gson.JsonObject;
import eu.iamgio.pokedex.connection.HttpConnection;
import eu.iamgio.pokedex.lang.LocalizedNames;
import eu.iamgio.pokedex.pokemon.PokemonType;
import eu.iamgio.pokedex.util.Loadable;
import eu.iamgio.pokedex.util.NamedResource;
import eu.iamgio.pokedex.util.StringUtil;
import eu.iamgio.pokedex.version.VersionGroup;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * List of available Pokémon generations
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum Generation implements Loadable<Generation.LoadedGeneration> {

    GENERATION_I(1),
    GENERATION_II(2),
    GENERATION_III(3),
    GENERATION_IV(4),
    GENERATION_V(5),
    GENERATION_VI(6),
    SUN_MOON(7);

    /**
     * The identifier for this resource.
     */
    private int id;

    /**
     * @param json Raw JSON
     * @return {@link Generation} contained in JSON
     */
    public static Generation fromJson(JsonObject json) {
        return valueOf(StringUtil.toEnumName(new NamedResource(json.get("generation").getAsJsonObject()).getName()));
    }

    @Override
    public LoadedGeneration load() {
        JsonObject json = new HttpConnection("generation/" + id + "/").getJson();
        return new LoadedGeneration(
                id,
                this,
                NamedResource.getNames(json.getAsJsonArray("pokemon_species")),
                NamedResource.getNames(json.getAsJsonArray("abilities")),
                NamedResource.getNames(json.getAsJsonArray("moves")),
                NamedResource.getNames(json.getAsJsonArray("types")).stream()
                        .map(type -> PokemonType.valueOf(type.toUpperCase()))
                        .collect(Collectors.toList()),
                NamedResource.getNames(json.getAsJsonArray("version_groups")).stream()
                        .map(group -> VersionGroup.valueOf(StringUtil.toEnumName(group)))
                        .collect(Collectors.toList()),
                new NamedResource(json.getAsJsonObject("main_region")).getName(),
                new LocalizedNames(json.getAsJsonArray("names"), "name")
        );
    }

    @AllArgsConstructor(access = AccessLevel.PACKAGE)
    @Getter
    public static class LoadedGeneration {

        /**
         * Identifier of this generation
         */
        private int id;

        /**
         * Generation
         */
        private Generation generation;

        /**
         * A list of Pokémon species that were introduced in this generation
         */
        private List<String> pokemonNames;

        /**
         * A list of abilities that were introduced in this generation
         */
        private List<String> abilityNames;

        /**
         * A list of moves that were introduced in this generation
         */
        private List<String> moveNames;

        /**
         * A list of types that were introduced in this generation
         */
        private List<PokemonType> types;

        /**
         * A list of version groups that were introduced in this generation
         */
        private List<VersionGroup> groups;

        //TODO convert to Region
        /**
         * The main region travelled in this generation
         */
        private String mainRegion;

        /**
         * The name of this generation listed in different languages
         */
        private LocalizedNames localizedNames;
    }
}
