package model;

import Exceptions.NothingFoundException;

import java.util.HashMap;
import java.util.Map;

public abstract class Component {
    /*
    protected String name;
    protected HashMap<Component, Component> map;

    public Component(String name){
        this.name = name;
        map = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public HashMap<Component,Component> getMap(){
        return map;
    }

    public Component lookForComponent(String input) throws NothingFoundException {
        Component returnComp = null;
        for (Component component : this.getMap().keySet()) {
            if (input.equals(component.getName())) {
                returnComp = component;
            }
        }
        if (returnComp == null) {
            throw new NothingFoundException();
        }
        return returnComp;
    }
    */
}
