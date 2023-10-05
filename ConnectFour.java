import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY = ' ';
    private static char[][] board = new char[ROWS][COLUMNS];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int column = getColumnChoice(scanner);
            if (isValidMove(column)) {
                dropPiece(column);
                displayBoard();
                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                } else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    break;
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void displayBoard() {
        System.out.println("  1 2 3 4 5 6 7");
        System.out.println("---------------");
        for (int i = 0; i < ROWS; i++) {
            System.out.print("|");
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
            System.out.println("---------------");
        }
    }

    private static int getColumnChoice(Scanner scanner) {
        int column;
        while (true) {
            System.out.print("Player " + currentPlayer + ", enter a column (1-7): ");
            if (scanner.hasNextInt()) {
                column = scanner.nextInt();
                if (column >= 1 && column <= COLUMNS) {
                    break;
                } else {
                    System.out.println("Invalid column. Try again.");
                }
            } else {
                System.out.println("Invalid input. Enter a number (1-7).");
                scanner.next();
            }
        }
        return column - 1;
    }

    private static boolean isValidMove(int column) {
        return column >= 0 && column < COLUMNS && board[0][column] == EMPTY;
    }

    private static void dropPiece(int column) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][column] == EMPTY) {
                board[i][column] = currentPlayer;
                break;
            }
        }
    }

    private static boolean checkWin() {
        
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
