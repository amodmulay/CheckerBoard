/**
 *
 */
package com.avm.sss.actors;


/**
 * @author amodmulay
 */
public class BirdAlertTest {
    public static void main(String[] args) {
        IScaredOfBirds o = new Beetel(13, 0, 1);
        IBirdAlert s = new BirdAlertImpl();
        s.addScared(o);
        s.birdSpotted(1);

    }
}
