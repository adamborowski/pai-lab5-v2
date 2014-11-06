/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai.lab5.observable;

/**
 * Api dla klasy implementującej obserwatora
 * @author adam
 */
public interface IObservableHostApi extends IObservableClientApi {

    void notifyObservers();
    
}
