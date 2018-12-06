package eu.iamgio.pokedex.exception;

/**
 * Exception thrown when an error during connection or parsing occurs
 * @author Gio
 */
public class PokedexException extends RuntimeException {

    public PokedexException(String message) {
        super(message);
    }
}
