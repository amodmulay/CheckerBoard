/**
 *
 */
package com.avm.sss.board;

import com.avm.sss.actors.Beetel;
import com.avm.sss.actors.BirdAlertImpl;
import com.avm.sss.actors.IBirdAlert;

/**
 * @author amodmulay
 *         Main Board
 */
public class CheckerBoard {

    private static CheckerBoard checkeredBoard;

    private CheckerBoardSquare[][] checkerBoardSquares = new CheckerBoardSquare[15][15];
    private IBirdAlert alert = new BirdAlertImpl();

    private CheckerBoard() {
        //
    }

    /**
     * @return
     */
    public static CheckerBoard getCheckerBoard() {
        if (null == checkeredBoard) {
            checkeredBoard = new CheckerBoard();
            checkeredBoard.createBoard();
        }

        return checkeredBoard;
    }

    /**
     * Creates board with 1 beetel on each square
     */
    private void createBoard() {
        int count = 0;
        for (int x = 0; x < 15; x++)
            for (int y = 0; y < 15; y++) {
                CheckerBoardSquare boardSquare = new CheckerBoardSquare(x, y);
                count = count + 1;
                Beetel beetel = new Beetel(x, y, count);
                boardSquare.addScared(beetel);
                getCheckerBoardSquares()[x][y] = boardSquare;
                alert.addScared(beetel);
            }
    }

    public CheckerBoardSquare getUniqueSquare(int xCoordinate, int yCoordinate) {
        return getCheckerBoardSquares()[xCoordinate][yCoordinate];
    }

    public CheckerBoardSquare[][] getCheckerBoardSquares() {
        return checkerBoardSquares;
    }

    public void setCheckerBoardSquares(CheckerBoardSquare[][] checkerBoardSquares) {
        this.checkerBoardSquares = checkerBoardSquares;
    }

    public IBirdAlert getAlert() {
        return alert;
    }

    public void setAlert(IBirdAlert alert) {
        this.alert = alert;
    }

}
