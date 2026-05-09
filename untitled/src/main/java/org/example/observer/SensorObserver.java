package org.example.observer;

import org.example.models.Meting;

public interface SensorObserver {
    void update(Meting meting);
}