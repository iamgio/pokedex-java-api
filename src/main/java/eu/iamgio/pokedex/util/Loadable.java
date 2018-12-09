package eu.iamgio.pokedex.util;

/**
 * Interface implemented by classes that, via a method, load additional information
 * @author Gio
 */
public interface Loadable<T> {

    T load();
}
