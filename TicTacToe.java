import java.util.Scanner;

public class TicTacToe {
    private static String[][] grid = new String[3][3];
    private static int currentPlayer;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        initializeGrid();
        initializeCurrentPlayer();
        mainMenu();
    }

    private static void initializeGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = " ";
            }
        }
    }

    private static void mainMenu() {
        System.out.println("Welcome to Tic Tac Toe.");
        gameMenu();
    }

    private static void gameMenu() {
        printGrid();

        if (getCurrentPlayer() == 1) {
            System.out.println("Player x: chose row");
            int row = input.nextInt() - 1;
            System.out.println("Player x: chose column");
            int col = input.nextInt() - 1;
            if (checkValidMove(row, col)) {
                grid[row][col] = "x";
                checkWin();
                setCurrentPlayer(2);
                gameMenu();
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        } else if (getCurrentPlayer() == 2) {
            System.out.println("Player o: chose row");
            int row = input.nextInt() - 1;
            System.out.println("Player o: chose column");
            int col = input.nextInt() - 1;
            if (checkValidMove(row, col)) {
                grid[row][col] = "o";
                checkWin();
                setCurrentPlayer(1);
                gameMenu();
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        } else {
            System.out.println("System error. Please restart.");
        }
    }

    private static void printGrid() {
        System.out.println("  1 2 3 ");
        System.out.println("  _ _ _ ");
        System.out.println("1|" + grid[0][0] + "|" + grid[0][1] + "|" + grid[0][2] + "|");
        System.out.println("  _ _ _ ");
        System.out.println("2|" + grid[1][0] + "|" + grid[1][1] + "|" + grid[1][2] + "|");
        System.out.println("  _ _ _ ");
        System.out.println("3|" + grid[2][0] + "|" + grid[2][1] + "|" + grid[2][2] + "|");
        System.out.println("  - - - ");
    }

    private static int getCurrentPlayer() {
        return currentPlayer;
    } private static void setCurrentPlayer(int setter) {
        currentPlayer = setter;
    } private static void initializeCurrentPlayer() {
        currentPlayer = 1;
    }

    private static boolean checkValidMove(int moveRow, int moveCol) {
        if (grid[moveRow][moveCol].equals(" ")) {
            return true;
        }

        return false;
    }

    private static void checkWin() {
        if (checkWinXRows() || checkWinXCols() || checkWinXDiags()) {
            endGame("x");
        } else if (checkWinORows() || checkWinOCols() || checkWinODiags()) {
            endGame("o");
        }
    }

    private static boolean checkWinXRows() {
        if (grid[0][0].equals("x") && grid[0][1].equals("x") && grid[0][2].equals("x")) {
            return true;
        } else if (grid[1][0].equals("x") && grid[1][1].equals("x") && grid[1][2].equals("x")) {
            return true;
        } else if (grid[2][0].equals("x") && grid[2][1].equals("x") && grid[2][2].equals("x")) {
            return true;
        }

        return false;
    }

    private static boolean checkWinXCols() {
        if (grid[0][0].equals("x") && grid[1][0].equals("x") && grid[2][0].equals("x")) {
            return true;
        } else if (grid[0][1].equals("x") && grid[1][1].equals("x") && grid[2][1].equals("x")) {
            return true;
        } else if (grid[0][2].equals("x") && grid[1][2].equals("x") && grid[2][2].equals("x")) {
            return true;
        }

        return false;
    }

    private static boolean checkWinXDiags() {
        if (grid[0][0].equals("x") && grid[1][1].equals("x") && grid[2][2].equals("x")) {
            return true;
        } else if (grid[2][0].equals("x") && grid[1][1].equals("x") && grid[0][2].equals("x")) {
            return true;
        }

        return false;
    }

    private static boolean checkWinORows() {
        if (grid[0][0].equals("o") && grid[0][1].equals("o") && grid[0][2].equals("o")) {
            return true;
        } else if (grid[1][0].equals("o") && grid[1][1].equals("o") && grid[1][2].equals("o")) {
            return true;
        } else if (grid[2][0].equals("o") && grid[2][1].equals("o") && grid[2][2].equals("o")) {
            return true;
        }

        return false;
    }

    private static boolean checkWinOCols() {
        if (grid[0][0].equals("o") && grid[1][0].equals("o") && grid[2][0].equals("o")) {
            return true;
        } else if (grid[0][1].equals("o") && grid[1][1].equals("o") && grid[2][1].equals("o")) {
            return true;
        } else if (grid[0][2].equals("o") && grid[1][2].equals("o") && grid[2][2].equals("o")) {
            return true;
        }

        return false;
    }

    private static boolean checkWinODiags() {
        if (grid[0][0].equals("o") && grid[1][1].equals("o") && grid[2][2].equals("o")) {
            return true;
        } else if (grid[2][0].equals("o") && grid[1][1].equals("o") && grid[0][2].equals("o")) {
            return true;
        }

        return false;
    }

    private static void endGame(String winner) {
        System.out.println(winner + " wins!");
        System.exit(0);
    }
}
