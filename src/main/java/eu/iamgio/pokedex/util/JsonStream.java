package eu.iamgio.pokedex.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Util class to stream {@link com.google.gson.JsonArray}
 * @author Gio
 */
@Getter
public class JsonStream {

    private List<JsonElement> list = new ArrayList<>();

    public JsonStream(JsonArray array) {
        for(JsonElement element : array) {
            list.add(element);
        }
    }

    public Stream<JsonElement> stream() {
        return list.stream();
    }
}
