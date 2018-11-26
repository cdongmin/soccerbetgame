package model;

import Exceptions.NothingFoundException;

import java.util.*;

public class UserManager {
    private Set<Observer> observers;
    private HashMap<String, User> users;

    public UserManager() {
        observers = new HashSet<>();
        users = new HashMap<>();
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }

    public void addObserver(Observer o) {
        if (!observers.contains(o))
            observers.add(o);
    }

    public void removeObserver(Observer o) {
        if (observers.contains(o))
            observers.remove(o);
    }

    public void addUser(User user) {
        if (!users.containsKey(user.getName()))
            users.put(user.getName(), user);
    }


    public void notifyObservers(Team t, Bet b) {
        for (Observer o : observers)
            o.update(t, b);
    }

    public void notifyObserversResult(Game b) {
        for (Observer o : observers)
            o.updateResult(b);
    }

    public User lookForUser(String input) throws NothingFoundException {
        if (users.containsKey(input))
            return users.get(input);
        else
            throw new NothingFoundException();
        /*
        User aUser = null;
        for (User user : users) {
            if (input.equals(user.getName()))
                aUser = user;
        }
        if (aUser == null) {
            throw new NothingFoundException();
        }
        return aUser;
        */
    }
}
