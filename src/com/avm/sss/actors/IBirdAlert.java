/**
 *
 */
package com.avm.sss.actors;

/**
 * @author amodmulay
 *         Using observer pattern
 */
public interface IBirdAlert {
    public void addScared(IScaredOfBirds o);

    public void removeScared(IScaredOfBirds o);

    public int getState();

    public void birdSpotted(int state);
}
