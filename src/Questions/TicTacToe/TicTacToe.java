package Questions.TicTacToe;


/*
*  Board - 3x3
*  Piece - X, O
*
*
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.startGame();
    }

    void startGame() {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter the size of the board you want to play!!!");
        int n = cin.nextInt();
        int m = cin.nextInt();
        Board board = new Board(n, m);
        List<Piece> pieceList = new ArrayList<>();
        System.out.println("Enter the number of players: ");
        int numOfPlayers = cin.nextInt();
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Choose a piece and enter the player name.");
            String piece = cin.next();
            String playerName = cin.next();
            Piece p = new Piece(piece.charAt(0), playerName);
            pieceList.add(p);
        }
        while(true) {
            for (Piece piece: pieceList) {
                board.move(piece);
                if (board.check(piece.piece)) {
                    System.out.println("Player: " + piece.playerName + " wins the Game.......");
                    System.out.println("Exiting.....");
                    return;
                }
            }
        }

    }

}

class Board {
    char[][] board;
    int win;
    Board(int n, int m) {
        board = new char[n][m];
        for (int i = 0;i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = '-';
            }
        }
        this.win = n;
    }

    public void print() {
        System.out.println("---------------------------------------");
        for (char[] chars : board) {
            for (char ch: chars) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    public void move(Piece piece) {
        System.out.println("Player: " + piece.playerName + ", Please enter the move!!!");
        Scanner cin = new Scanner(System.in);
        int x = cin.nextInt();
        int y = cin.nextInt();
        if (validMove(x, y)) {
            board[x][y] = piece.piece;
            print();
        } else {
            System.out.println("Invalid Move. Enter again!!!");
            move(piece);
        }
    }

    boolean validMove(int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == '-';
    }

    boolean check(char ch) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (board[i][j] == ch) {
                    cnt++;
                    if (cnt == win) {
                        return true;
                    }
                } else {
                    cnt = 0;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (board[i][j] == ch) {
                    cnt++;
                    if (cnt == win) {
                        return true;
                    }
                } else {
                    cnt = 0;
                }
            }
        }
        for (int i = 0, j = 0, cnt = 0; i < n && j < m; i++, j++) {
            if (board[i][j] == ch) {
                cnt++;
                if (cnt == win) {
                    return true;
                }
            } else {
                cnt = 0;
            }
        }
        for (int i = n - 1, j = 0, cnt = 0; i >= 0 && j < m; i--, j++) {
            if (board[i][j] == ch) {
                cnt++;
                if (cnt == win) {
                    return true;
                }
            } else {
                cnt = 0;
            }
        }
        return false;
    }
}

class Piece {
    char piece;
    String playerName;

    Piece(char piece, String playerName) {
        this.piece = piece;
        this.playerName = playerName;
    }
}
