/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai.lab5.car;

import pai.lab5.statful.AbstractState;
import pai.lab5.statful.AbstractStateful;

/**
 *
 * @author adam
 */
public abstract class CarState extends AbstractState<CarState> implements CarApi {

    protected StatefulCar car;

    @Override
    public void onEnterState(AbstractStateful<CarState> stateful) {
        car = (StatefulCar) stateful;
    }
    
    

}
