package eu.iamgio.pokedex.lang;

import com.google.gson.JsonArray;

/**
 * @see eu.iamgio.pokedex.lang.LocalizedNameList
 * @author Gio
 */
public class LocalizedNames extends LocalizedNameList<LocalizedName> {

    public LocalizedNames(JsonArray array, String key) {
        super(array, key, (byte) -1);
    }

    public LocalizedNames() {}
}
