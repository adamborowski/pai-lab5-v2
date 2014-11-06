/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai.lab5.car.state;

import pai.lab5.car.CarState;
import pai.lab5.car.StatefulCar;

/**
 *
 * @author adam
 */
public class Idle extends CarState {

    @Override
    public void processTime() {
        if (car.getSpeed() < StatefulCar.DEAD_ZONE) {
            car.setSpeed(0);
        } else {
            car.setSpeed(car.getSpeed() * 0.999f);
        }
    }

}
