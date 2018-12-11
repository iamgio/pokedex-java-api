package eu.iamgio.pokedex.pokemon.encounter;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import eu.iamgio.pokedex.connection.HttpConnection;
import eu.iamgio.pokedex.exception.PokedexException;
import eu.iamgio.pokedex.pokemon.Pokemon;
import eu.iamgio.pokedex.util.NamedResource;
import eu.iamgio.pokedex.util.StringUtil;
import eu.iamgio.pokedex.version.Version;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The location area the referenced Pokémon can be encountered in
 * @author Gio
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Encounter {

    //TODO make LocationArea
    /**
     * The area the Pokémon can be found at
     */
    private String locationArea;

    private List<VersionDetail> details;

    /**
     * @param pokemonName Name of the Pokémon
     * @return Encounter of Pokémon whose name matches <tt>name</tt>
     * @throws PokedexException if <tt>name</tt> doesn't match a Pokémon name
     */
    public static List<Encounter> fromPokemonName(String pokemonName) throws PokedexException {
        JsonArray json;
        try {
            json = new HttpConnection("pokemon/" + pokemonName + "/encounters/").getJsonArray();
        } catch(RuntimeException e) {
            throw new PokedexException("Could not find Pokémon with name/ID " + pokemonName);
        }
        List<Encounter> encounters = new ArrayList<>();
        for(JsonElement encounter : json) {
            List<VersionDetail> versionDetails = new ArrayList<>();
            JsonObject object = encounter.getAsJsonObject();
            for(JsonElement detail : object.getAsJsonArray("version_details")) {
                JsonObject detailObject = detail.getAsJsonObject();
                List<EncounterDetail> encounterDetails = new ArrayList<>();
                for(JsonElement encounterDetail : detailObject.getAsJsonArray("encounter_details")) {
                    encounterDetails.add(EncounterDetail.fromJson(encounterDetail.getAsJsonObject()));
                }
                versionDetails.add(
                        new VersionDetail(
                                Version.valueOf(StringUtil.toEnumName(new NamedResource(detailObject.getAsJsonObject("version")).getName())),
                                detailObject.get("max_chance").getAsInt(),
                                encounterDetails
                        )
                );
            }
            encounters.add(new Encounter(
                    new NamedResource(object.getAsJsonObject("location_area")).getName(),
                    versionDetails
            ));
        }
        return encounters;
    }

    /**
     * @param pokemonId Identifier of the Pokémon
     * @return Encounter of Pokémon whose ID matches <tt>id</tt>
     * @throws PokedexException if <tt>id</tt> is 0 or less or doesn't match a Pokémon ID
     */
    public static List<Encounter> fromPokemonId(Number pokemonId) throws PokedexException {
        return fromPokemonName(String.valueOf(pokemonId));
    }

    /**
     * @param pokemon Pokémon
     * @return Encounter of Pokémon
     * @throws PokedexException if an error occurred
     */
    public static List<Encounter> fromPokemon(Pokemon pokemon) throws PokedexException {
        return fromPokemonId(pokemon.getId());
    }

    /**
     * The chance of the encounter to occur on a version of the game
     */
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class VersionDetail {

        /**
         * The game version this encounter happens in
         */
        private Version version;

        /**
         * The total percentage of all encounter potential
         */
        private int maxChance;

        /**
         * A list of encounters and their specifics
         */
        private List<EncounterDetail> encounterDetails;
    }

    /**
     * Specifics of the encounter
     */
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class EncounterDetail {

        /**
         * Percent chance that this encounter will occur
         */
        private int chance;

        /**
         * A list of condition values that must be in effect for this encounter to occur
         */
        private List<EncounterConditionValue> conditionValues;

        /**
         * The highest level the Pokémon could be encountered at
         */
        private int maxLevel;

        /**
         * The lowest level the Pokémon could be encountered at
         */
        private int minLevel;

        /**
         * The method by which this encounter happens
         */
        private EncounterMethod method;

        /**
         * @param json JSON object containing data
         * @return Parsed JSON into {@link EncounterDetail}
         */
        public static EncounterDetail fromJson(JsonObject json) {
            return new EncounterDetail(
                    json.get("chance").getAsInt(),
                    NamedResource.getNames(json.getAsJsonArray("condition_values"))
                            .stream()
                            .map(StringUtil::toEnumName)
                            .map(EncounterConditionValue::valueOf)
                            .collect(Collectors.toList()),
                    json.get("max_level").getAsInt(),
                    json.get("min_level").getAsInt(),
                    EncounterMethod.valueOf(StringUtil.toEnumName(new NamedResource(json.getAsJsonObject("method")).getName()))
            );
        }
    }
}
