package eu.iamgio.pokedex.util;

/**
 * Utility methods for managing strings
 * @author Gio
 */
public final class StringUtil {

    private StringUtil() {}

    public static String toEnumName(String string) {
        return string.replace("-", "_").toUpperCase();
    }
}
