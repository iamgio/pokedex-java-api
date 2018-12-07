package eu.iamgio.pokedex.lang;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * List of available game languages
 * @author Gio
 */
@AllArgsConstructor
@Getter
public enum Language {

    JAPANESE("ja-Hrkt", 1, true),
    ROOMAJI("roomaji", 2, true),
    KOREAN("ko", 3, true),
    CHINESE("zh-Hant", 4, true),
    FRENCH("fr", 5, true),
    GERMAN("de", 6, true),
    SPANISH("es", 7, true),
    ITALIAN("it", 8, true),
    ENGLISH("en", 9, true),
    CZECH("cs", 10, false),
    JAPANESE2("ja", 11, true),
    CHINESE2("zh-Hans", 12, true);

    /**
     * API name of this language
     */
    private String name;

    /**
     * Identifier of this language
     */
    private int id;

    /**
     * Whether or not this language is official
     */
    private boolean official;

    /**
     * @param name Language name
     * @return {@link Language} from name
     */
    public static Language fromName(String name) {
        for(Language language : values()) {
            if(language.getName().equals(name)) {
                return language;
            }
        }
        return null;
    }
}
