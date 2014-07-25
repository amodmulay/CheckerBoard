/**
 *
 */
package com.avm.sss.board;

/**
 * @author amodmulay
 */
public class CheckerBoardTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CheckerBoard board = CheckerBoard.getCheckerBoard();
        System.out
                .println("======================================================");
        System.out.println("Bird sorty : 0");
        System.out
                .println("======================================================");
        printAverageBeetlePerSquare(board);
        for (int i = 1; i <= 100; i++) {

            board.getAlert().birdSpotted(i);
            if (i == 25) {
                System.out
                        .println("======================================================");
                System.out.println("Bird sorty : " + i);
                System.out
                        .println("======================================================");
                printBeetlePerSquare(board);
            }
            if (i == 50) {
                System.out
                        .println("======================================================");
                System.out.println("Bird sorty : " + i);
                System.out
                        .println("======================================================");
                printAverageBeetlePerSquare(board);
            }
        }
        System.out
                .println("======================================================");
        System.out.println("Bird sorty : 100");
        System.out
                .println("======================================================");
        findHighestOccupiedSquare(board);

    }

    private static void printBeetlePerSquare(CheckerBoard pBoard) {
        for (int x = 0; x < 15; x++)
            for (int y = 0; y < 15; y++) {
                System.out
                        .println("================Beetles per square====================");
                System.out.print("Square at coordinates : (" + x + "," + y + ")");
                System.out.println("  Number of beetles: "
                        + pBoard.getCheckerBoardSquares()[x][y].getScared()
                        .size());
                System.out
                        .println("======================================================");
            }
    }

    private static void printAverageBeetlePerSquare(CheckerBoard pBoard) {
        int beetlesCount = 0;
        int filledSquares = 0;
        for (int x = 0; x < 15; x++)
            for (int y = 0; y < 15; y++) {
                int beetles = pBoard.getCheckerBoardSquares()[x][y].getScared()
                        .size();
                if (beetles != 0) {
                    beetlesCount = beetlesCount + beetles;
                    filledSquares++;
                }
            }
        System.out
                .println("================Average beetle per square=============");
        System.out.println("Number of beetles : " + beetlesCount);
        System.out.println("Occupied Squares : " + filledSquares);
        System.out.println("Average :" + beetlesCount / filledSquares);
        System.out
                .println("======================================================");
    }

    private static void findHighestOccupiedSquare(CheckerBoard pBoard) {
        int beetlesCount = 0;
        CheckerBoardSquare checkerBoardSquare;
        CheckerBoardSquare checkerBoardSquareMax = null;
        for (int x = 0; x < 15; x++)
            for (int y = 0; y < 15; y++) {
                checkerBoardSquare = pBoard.getCheckerBoardSquares()[x][y];
                int beetles = pBoard.getCheckerBoardSquares()[x][y].getScared()
                        .size();
                if (beetlesCount < beetles) {
                    beetlesCount = beetles;
                    checkerBoardSquareMax = checkerBoardSquare;
                }
            }
        System.out
                .println("==================Highest occupied====================");
        // no need for null check but in real scenario should be done
        System.out.println("Highest occupied square is at : ("
                + checkerBoardSquareMax.getxCoordinate() + ","
                + checkerBoardSquareMax.getyCoordinate() + ")" + " with "
                + beetlesCount + " beetles");
        System.out
                .println("======================================================");
    }
}
