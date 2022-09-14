package application;

import chess.chessMatch;

public class Program {

	public static void main(String[] args) {
		chessMatch chessmatch = new chessMatch();
		UI.printBoard(chessmatch.getPieces());
	}

}
