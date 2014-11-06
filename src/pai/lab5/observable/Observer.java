package pai.lab5.observable;

/**
 *
 * @author adam
 * @param <Subject>
 */
public interface Observer<Subject> {

    void update(Subject observable);
}
