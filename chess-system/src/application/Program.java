package application;

import java.util.Scanner;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.chessMatch;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		chessMatch chessmatch = new chessMatch();
		while(true) {
			UI.printBoard(chessmatch.getPieces());
			System.out.println();
			System.out.println("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
			System.out.println();
			System.out.println("Target: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = chessmatch.performChessMove(source, target);
		}
	}

}
