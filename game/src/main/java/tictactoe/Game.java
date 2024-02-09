package tictactoe;
import java.util.Scanner;

public class Game {
    int[][] board = new int[3][3];
    int round = 0;
    
    public Game() {
        
    }

    // Creates the gameplay loop
    public void playGame() {
        boolean complete = false;

        boolean proceed  = initaliseGame();
        if (proceed) {
            System.out.println("The game has begun, you are X");
        } else {
            return;
        }

        initaliseBoard(board);

        while (!complete) {
            printBoard(board);
            complete = true;
        }

    }

    // Creates a simple request asking if the user would like to play
    public boolean initaliseGame() {
        Scanner myObj = new Scanner(System.in);

        while (true) {
            System.out.println("Would you like to play Tic-Tac-Toe: Y/N");
            String answer = myObj.nextLine();
            
            if (answer.equalsIgnoreCase("Y")) {
                return(true);

            } else if (answer.equalsIgnoreCase("N")) {
                return(false);

            } else {
                System.out.println("Please choose one of the options");

            }
        }

    }

    // Creates the boards inital state
    public void initaliseBoard(int[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }

    }

    // Takes in the boards current state and outputs it in the terminal
    public void printBoard(int[][] board) {

        for (int i = 0; i < 3; i++) {
            String line = "|";
            for (int j = 0; j < 3; j++) {

                String displayChar;
                if (board[i][j] == 0) {
                    displayChar = " ";
                } else if (board[i][j] == 1) {
                    displayChar = "X";
                } else {
                    displayChar = "O";
                }

                String value = displayChar + "|";
                line = line + value;
            }
            System.out.println(line);
        }

    }
}
