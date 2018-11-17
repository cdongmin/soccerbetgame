package model;

import java.util.HashSet;
import java.util.Set;

public class UserManager {
    private Set<Observer> observers;

    public UserManager(){
        observers = new HashSet<>();
    }

    public void addObserver(Observer o) {
        if (!observers.contains(o))
            observers.add(o);
    }

    public void removeObserver(Observer o){
        if(observers.contains(o))
            observers.remove(o);
    }

    public void notifyObservers(Team t, Bet b){
        for(Observer o:observers)
            o.update(t,b);
    }

    public void notifyObserversResult(Game b){
        for(Observer o:observers)
            o.updateResult(b);
    }
}
