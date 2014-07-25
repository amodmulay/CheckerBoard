/**
 *
 */
package com.avm.sss.actors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author amodmulay
 *         Subject of Observer
 */
public class BirdAlertImpl implements IBirdAlert {
    private List<IScaredOfBirds> observers = new ArrayList<IScaredOfBirds>();

    private int state = 0;

    public int getState() {
        return state;
    }

    public void birdSpotted(int state) {
        this.state = state;
        notifyObservers();
    }

    public void addScared(IScaredOfBirds o) {
        observers.add(o);
    }

    public void removeScared(IScaredOfBirds o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        Iterator<IScaredOfBirds> i = observers.iterator();
        while (i.hasNext()) {
            IScaredOfBirds o = i.next();
            o.jump(this);
        }
    }
}
