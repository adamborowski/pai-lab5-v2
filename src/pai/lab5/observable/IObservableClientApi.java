package pai.lab5.observable;

/**
 * Api dla klienta - observatora
 *
 * @author adam
 */
public interface IObservableClientApi {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void removeAllObservers();

//    void notifyObservers();//to nie bo to jest wewnętrzna sprawa
}
