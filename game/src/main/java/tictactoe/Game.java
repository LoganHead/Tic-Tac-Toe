package tictactoe;
import java.util.Scanner;
import java.util.Random;

public class Game {
    int[][] board = new int[3][3];
    int round = 0;
    
    public Game() {
        
    }

    // Creates the gameplay loop
    public void playGame() {
        boolean complete = false;

        if (initaliseGame()) {
            System.out.println("The game has begun, you are X");
        } else {
            return;
        }

        Player player1 = new Player(1);
        Player player2 = new Player(2);

        initaliseBoard(board);

        while (!complete) {
            printBoard(this.board);
            playersTurn(this.board, player1);
            printBoard(this.board);
            checkForWin(player1);
            playersTurn(this.board, player2);
            printBoard(this.board);
            checkForWin(player2);
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

    public void playersTurn(int[][] board, Player player) {
        Scanner myObj = new Scanner(System.in);

        if (player.playerNumber == 1) {
            while (true) {
                System.out.println("Choose a square by entering a number between 1-9 with 1 representing the top left square and 9 representing the bottom right square");
                String answer = myObj.nextLine();
                if (isValidTurn(answer, board)) {
                    executeBoardUpdate(answer, board, player);
                    return;
                } else {
                    System.out.println("Not a valid move please choose a different number");
                }
            }
        } else {
            while (true) {
                
                String answer = botAnswer();
                
                if (isValidTurn(answer, board)) {
                    executeBoardUpdate(answer, board, player);
                    System.out.println("The bot played in square " + answer);
                    return;
                } 

            }
        }

        

    }

    public boolean isValidTurn(String value, int[][] board) {
        int number = Integer.parseInt(value);
        int i = (number - 1) / 3;
        int j = (number - 1) % 3;

        if (board[i][j] == 0 || (number < 1 || number > 9)) {
            return true;
        } else {
            return false;
        }

    }

    public void executeBoardUpdate(String value, int[][] board, Player player) {
        int number = Integer.parseInt(value);
        int i = (number - 1) / 3;
        int j = (number - 1) % 3;

        if (player.playerNumber == 1) {
            board[i][j] = 1;
        } else {
            board[i][j] = 2;
        }
        

    }

    public void checkForWin(Player player) {

    }

    public String botAnswer() {
        Random rand = new Random();
        String value  = Integer.toString(rand.nextInt(1,9));
        return value;
    }
}
