/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai.lab5.car;

import pai.lab5.car.state.Idle;
import pai.lab5.observable.Observable;
import pai.lab5.observable.IObservableClientApi;
import pai.lab5.observable.Observer;
import pai.lab5.statful.AbstractStateful;

/**
 *
 * @author adam
 */
public class StatefulCar extends AbstractStateful<CarState> implements CarApi, IObservableClientApi {

    public final Observable observable;

    public final static float DEAD_ZONE = 0.01f;
    public final static float MAX_SPEED = 1.00f;

    public StatefulCar() {
        super(new Idle());
        observable = new Observable(this);
    }

    @Override
    public void processTime() {
        getState().processTime();
    }

    private float speed = 0;

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }
        this.speed = speed;
        System.out.println("Zmiana prędkości: " + speed);
        observable.notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observable.addObserver(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observable.removeObserver(observer);
    }

    @Override
    public void removeAllObservers() {
        observable.removeAllObservers();
    }

}
