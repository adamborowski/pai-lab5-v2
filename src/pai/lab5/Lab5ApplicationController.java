/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pai.lab5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.util.Duration;
import pai.lab5.car.StatefulCar;
import pai.lab5.car.state.Brake;
import pai.lab5.car.state.Idle;
import pai.lab5.car.state.Throttle;
import pai.lab5.observable.Observer;

/**
 *
 * @author adam
 */
public class Lab5ApplicationController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        car = new StatefulCar();
        //timeline
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(25), ea -> car.processTime()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        //observers
        Observer<StatefulCar> gaugeObserver = (StatefulCar observable) -> gauge.setProgress(observable.getSpeed() / StatefulCar.MAX_SPEED);
        Observer<StatefulCar> barObserver = (StatefulCar observable) -> progressBar.setProgress(observable.getSpeed() / StatefulCar.MAX_SPEED);
        Observer<StatefulCar> sliderObserver = (StatefulCar observable) -> slider.setValue(observable.getSpeed() / StatefulCar.MAX_SPEED * slider.getMax());
        car.addObserver(gaugeObserver);
        car.addObserver(barObserver);
        car.addObserver(sliderObserver);
        //disablers
        gauge.setOnMousePressed((ae) -> car.removeObserver(gaugeObserver));
        progressBar.setOnMousePressed((ae) -> car.removeObserver(barObserver));
        slider.setOnMousePressed((ae) -> car.removeObserver(sliderObserver));
        //enablers
        gauge.setOnMouseReleased((ae) -> car.addObserver(gaugeObserver));
        progressBar.setOnMouseReleased((ae) -> car.addObserver(barObserver));
        slider.setOnMouseReleased((ae) -> car.addObserver(sliderObserver));
    }

    private StatefulCar car;
    @FXML
    public ProgressIndicator gauge;

    @FXML
    public ProgressBar progressBar;

    @FXML
    public Slider slider;

    public void handleThrottle() {
        car.setState(new Throttle());
    }

    public void handleIdle() {
        car.setState(new Idle());
    }

    public void handleBrake() {
        car.setState(new Brake());
    }

}
