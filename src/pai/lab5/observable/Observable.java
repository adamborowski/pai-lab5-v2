/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai.lab5.observable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adam
 * @param <Subject> obiekt będący właścicielem observable lub on sam
 */
public class Observable<Subject> implements IObservableHostApi {

    private final Subject subject;

    public Observable(Subject subject) {
        this.subject = subject;
    }

    public Observable() {
        this.subject = (Subject) this;
    }

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public final void notifyObservers() {
        observers.stream().forEach((o) -> o.update(subject));
    }

    @Override
    public final void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public final void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public final void removeAllObservers() {
        observers.clear();
    }

}
