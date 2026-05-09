package org.example.observer;

import org.example.models.Meting;

public interface SensorSubject {
    void addObserver(SensorObserver observer);
    void removeObserver(SensorObserver observer);
    void notifyObservers(Meting meting);
}