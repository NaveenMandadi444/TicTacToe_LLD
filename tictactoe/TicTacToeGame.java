package com.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public TicTacToeGame() {
        board = new Board();
        playerX = new Player('X');
        playerO = new Player('O');
        currentPlayer = playerX; // X starts first
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            board.printBoard();
            System.out.println("Player " + currentPlayer.getSymbol() + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Validate and place the move
            if (!board.placeMove(row, col, currentPlayer.getSymbol())) {
                System.out.println("This move is not valid. Try again.");
                continue;
            }

            // Check for a win or draw
            if (board.checkWin(currentPlayer.getSymbol())) {
                board.printBoard();
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                playing = false;
            } else if (board.isFull()) {
                board.printBoard();
                System.out.println("The game is a draw!");
                playing = false;
            }
           else {
            // Switch players
            currentPlayer = (currentPlayer == playerX) ? playerO:playerX;
          }
        }
    }
}