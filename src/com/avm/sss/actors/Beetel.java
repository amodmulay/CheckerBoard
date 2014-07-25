/**
 *
 */
package com.avm.sss.actors;

import com.avm.sss.board.CheckerBoard;

/**
 * @author amodmulay
 */
public class Beetel implements IScaredOfBirds {

    private int xCoordinate;
    private int yCoordinate;
    private int beetelNumber = 0;

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public int getBeetelNumber() {
        return beetelNumber;
    }

    public Beetel(int pXCoordinate, int pYCoordinate, int pNumber) {
        xCoordinate = pXCoordinate;
        yCoordinate = pYCoordinate;
        beetelNumber = pNumber;
    }

    /**
     * Trigger method to make the beetel jump
     */
    public void jump(IBirdAlert o) {
        /*
		 * System.out.println("Received BirdAlert :" + o.getState() +
		 * " Scared Beetel at coordinates :" + beetelNumber + "::" + xCoordinate
		 * + "," + yCoordinate);
		 */
        if (isOnEdge()) {
			/*
			 * System.out.println("cannot move Beetel at coordinates :" +
			 * beetelNumber + "::" + xCoordinate + "," + yCoordinate);
			 */
            // Check if beetle can move back
            if (canMoveLeftBackward()) {
                removeFromSquare();
                xCoordinate = xCoordinate - 1;
                yCoordinate = yCoordinate + 1;
                addToSquare();
            } else if (canMoveRightBackward()) {
                removeFromSquare();
                xCoordinate = xCoordinate + 1;
                yCoordinate = yCoordinate + 1;
                addToSquare();
            }
        } else {
            removeFromSquare();
            if (canMoveRightForward()) {
                // System.out.println("Moving right");
                xCoordinate = xCoordinate + 1;
                yCoordinate = yCoordinate - 1;
            } else if (canMoveLeftForward()) {
                // System.out.println("Moving left");
                xCoordinate = xCoordinate - 1;
                yCoordinate = yCoordinate - 1;
            }
            addToSquare();
        }

		/*
		 * System.out.println("Coordinates changed to : " + beetelNumber + "::"
		 * + xCoordinate + "," + yCoordinate);
		 */
    }

    private boolean isOnEdge() {

        if (yCoordinate == 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canMoveRightForward() {
        if (yCoordinate > 0 && xCoordinate < 14) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canMoveLeftForward() {
        if (xCoordinate > 0 && yCoordinate > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canMoveLeftBackward() {
        if (xCoordinate > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canMoveRightBackward() {
        if (xCoordinate < 14) {
            return true;
        } else {
            return false;
        }
    }

    private void removeFromSquare() {
        CheckerBoard.getCheckerBoard()
                .getUniqueSquare(xCoordinate, yCoordinate).removeScared(this);
    }

    private void addToSquare() {
        CheckerBoard.getCheckerBoard()
                .getUniqueSquare(xCoordinate, yCoordinate).addScared(this);
    }
}
