package Questions.Chess.model;

import Questions.Chess.model.piece.*;

public class Board {
    private final Square[][] squares;

    public Board() {
        squares = new Square[8][8];
        initializeBoard();
    }

    private void initializeBoard() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new Square(new Position(i, j), null);
            }
        }

        // initialize white pieces
        squares[0][0].setPiece(new Rook(Color.WHITE));
        squares[0][1].setPiece(new Knight(Color.WHITE));
        squares[0][2].setPiece(new Bishop(Color.WHITE));
        squares[0][3].setPiece(new Queen(Color.WHITE));
        squares[0][4].setPiece(new King(Color.WHITE));
        squares[0][5].setPiece(new Bishop(Color.WHITE));
        squares[0][6].setPiece(new Knight(Color.WHITE));
        squares[0][7].setPiece(new Rook(Color.WHITE));
        for (int i = 0; i < 8; i++) {
            squares[1][i].setPiece(new Pawn(Color.WHITE));
        }

        // initialize black pieces
        squares[7][0].setPiece(new Rook(Color.BLACK));
        squares[7][1].setPiece(new Knight(Color.BLACK));
        squares[7][3].setPiece(new Queen(Color.BLACK));
        squares[7][4].setPiece(new King(Color.BLACK));
        squares[7][5].setPiece(new Bishop(Color.BLACK));
        squares[7][6].setPiece(new Knight(Color.BLACK));
        squares[7][7].setPiece(new Rook(Color.BLACK));
        for (int i = 0; i < 8; i++) {
            squares[6][i].setPiece(new Pawn(Color.BLACK));
        }
    }

    public Square getBlock(Position position) {
        int row = position.getRow();
        int col = position.getCol();
        if (row >= 0 && col >= 0 && row < 8 && col < 8) {
            return squares[row][col];
        }
        return null;
    }


    public void executeMove(Move move) {
        Piece sourcePiece = move.getStart().getPiece();
        Piece destinationPiece = move.getEnd().getPiece();
        if (destinationPiece != null) {
            destinationPiece.setIsCaptured(true);
        }
        move.getEnd().setPiece(sourcePiece);
        move.getStart().setPiece(null);
    }

    public boolean isValidMove(Piece piece, Position from, Position to) {

        return piece.canMove(this, from, to);

    }
}
