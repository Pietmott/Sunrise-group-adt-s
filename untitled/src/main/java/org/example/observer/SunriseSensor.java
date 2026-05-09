package org.example.observer;

import org.example.models.Meting;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class SunriseSensor implements SensorSubject {

    private final List<SensorObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(SensorObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(SensorObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Meting meting) {
        for (SensorObserver observer : observers) {
            observer.update(meting);
        }
    }

    public void nieuweMeting(Meting meting) {
        notifyObservers(meting);
    }
}