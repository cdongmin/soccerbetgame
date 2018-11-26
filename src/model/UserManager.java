package model;

import Exceptions.NothingFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserManager {
    private Set<Observer> observers;
    private List<User> users;

    public UserManager(){
        observers = new HashSet<>();
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addObserver(Observer o) {
        if (!observers.contains(o))
            observers.add(o);
    }

    public void removeObserver(Observer o){
        if(observers.contains(o))
            observers.remove(o);
    }

    public void addUser(User user){
        users.add(user);
    }


    public void notifyObservers(Team t, Bet b){
        for(Observer o:observers)
            o.update(t,b);
    }

    public void notifyObserversResult(Game b){
        for(Observer o:observers)
            o.updateResult(b);
    }

    public User lookForUser(String input) throws NothingFoundException {
        User aUser = null;
        for (User user: users) {
            if (input.equals(user.getName()))
                aUser = user;
        }
        if (aUser == null) {
            throw new NothingFoundException();
        }
        return aUser;
    }
}
