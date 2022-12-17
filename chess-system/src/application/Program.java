package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.chessMatch;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		chessMatch chessmatch = new chessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		while(!chessmatch.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessmatch, captured);
				System.out.println();
				System.out.println("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessmatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessmatch.getPieces(), possibleMoves);
				
				
				System.out.println();
				System.out.println("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessmatch.performChessMove(source, target);
				
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
				if(chessmatch.getPromoted() != null){
					System.out.print("Enter piece for promotion (Q/R/H/B):");
					String type = sc.nextLine().toUpperCase();
					while(!type.equals("B") && !type.equals("H") && !type.equals("Q") && type.equals("R")) {
						System.out.print("Invalid value! Enter piece for promotion (Q/R/H/B):");
						type = sc.nextLine().toUpperCase();
					}
					chessmatch.replacePromotedPiece(type);
				}
			}
			catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessmatch, captured);
	}

}
