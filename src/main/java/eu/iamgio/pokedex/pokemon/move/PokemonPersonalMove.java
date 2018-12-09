package eu.iamgio.pokedex.pokemon.move;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import eu.iamgio.pokedex.util.NamedResource;
import eu.iamgio.pokedex.util.StringUtil;
import eu.iamgio.pokedex.version.VersionGroup;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a {@link PokemonMove} a Pokémon actually has
 * @author Gio
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class PokemonPersonalMove {

    /**
     * Name of the move
     */
    private String name;

    /**
     * List of details specific to a {@link VersionGroup}
     */
    private List<VersionGroupDetail> groupDetails;

    /**
     * @param json JSON object containing data
     * @return Parsed JSON into {@link PokemonPersonalMove}
     */
    public static PokemonPersonalMove fromJson(JsonObject json) {
        JsonArray details = json.getAsJsonArray("version_group_details");
        List<VersionGroupDetail> groupDetails = new ArrayList<>();
        for(JsonElement detail : details) {
            groupDetails.add(VersionGroupDetail.fromJson(detail.getAsJsonObject()));
        }
        return new PokemonPersonalMove(
                new NamedResource(json.getAsJsonObject("move")).getName(),
                groupDetails
        );
    }

    /**
     * @return General {@link PokemonMove}
     */
    public PokemonMove toAbility() {
        return PokemonMove.fromName(name);
    }

    /**
     * Move details specific to a {@link VersionGroup}
     */
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class VersionGroupDetail {

        /**
         * The method by which the move is learned
         */
        private MoveLearnMethod learnMethod;

        /**
         * The version group in which the move is learned
         */
        private VersionGroup group;

        /**
         * The minimum level to learn the move
         */
        private int levelLearnedAt;

        /**
         * @param json JSON object containing data
         * @return Parsed JSON into {@link VersionGroupDetail}
         */
        static VersionGroupDetail fromJson(JsonObject json) {
            return new VersionGroupDetail(
                    MoveLearnMethod.valueOf(StringUtil.toEnumName(new NamedResource(json.getAsJsonObject("move_learn_method")).getName())),
                    VersionGroup.valueOf(StringUtil.toEnumName(new NamedResource(json.getAsJsonObject("version_group")).getName())),
                    json.get("level_learned_at").getAsInt()
            );
        }
    }
}
