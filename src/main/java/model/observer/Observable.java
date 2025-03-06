package model.observer;

import java.util.ArrayList;
import java.util.List;
import model.interfaces.IObserver;


public class Observable {
    private List<IObserver> observers = new ArrayList<>();
    
    public void addObserver(IObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (IObserver observer : observers){
            observer.update();
        }
    }
}