/**
 *
 */
package com.avm.sss.board;

import com.avm.sss.actors.IScaredOfBirds;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amodmulay
 */
public class CheckerBoardSquare {

    private int xCoordinate;
    private int yCoordinate;
    private List<IScaredOfBirds> scared = new ArrayList<IScaredOfBirds>();

    public CheckerBoardSquare(int pXCoordinate, int pYCoordinate) {
        setxCoordinate(pXCoordinate);
        setyCoordinate(pYCoordinate);
    }

    public void addScared(IScaredOfBirds pScaredofBirds) {
        scared.add(pScaredofBirds);
    }

    public void removeScared(IScaredOfBirds pScaredofBirds) {
        scared.remove(pScaredofBirds);
    }

    public List<IScaredOfBirds> getScared() {
        return scared;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
