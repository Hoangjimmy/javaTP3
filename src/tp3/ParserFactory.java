package tp3;

/**
 * Une factory abstraite
 *
 * @param <T> Le type d'objets fabriqués par cette factory
 */
public interface ParserFactory<T> {

    /**
     * Tries to construct an object of type T from the given arguments
     * @param args The arguments with which to construct the object
     * @return The constructed object, or null if the construction wasn't possible.
     */
    public abstract T tryConstruct(String[] args);
}
