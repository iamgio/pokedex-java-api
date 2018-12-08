package eu.iamgio.pokedex.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Resource with a name and a URL (exluded)
 * @author Gio
 */
public class NamedResource {

    @Getter private String name;

    public NamedResource(JsonObject json) {
        this.name = json.get("name").getAsString();
    }

    /**
     * @param array JSON array
     * @return List of {@link NamedResource}s
     */
    public static List<String> getNames(JsonArray array) {
        List<String> list = new ArrayList<>();
        for(JsonElement jsonElement : array) {
            list.add(new NamedResource(jsonElement.getAsJsonObject()).name);
        }
        return list;
    }
}
