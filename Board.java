import Pieces.*;
import java.util.*;

public class Board {
	/*
	The Board is just a 2D array of Pieces and also
	acts as a translation layer between array coordinates
	and chess coordinates and also has methods to make changes
	which will be called by the Game() object.
	*/
	Piece[][] layout = {
		{new Filler("H1"), new Filler("H2"), new Filler("H3"), new Filler("H4"), new Filler("H5"), new Filler("H6"), new Filler("H7"), new Filler("H8")},
		{new Filler("G1"), new Filler("G2"), new Filler("G3"), new Filler("G4"), new Filler("G5"), new Filler("G6"), new Filler("G7"), new Filler("G8")},
		{new Filler("F1"), new Filler("F2"), new Filler("F3"), new Filler("F4"), new Filler("F5"), new Filler("F6"), new Filler("F7"), new Filler("F8")},
		{new Filler("E1"), new Filler("E2"), new Filler("E3"), new Filler("E4"), new Filler("E5"), new Filler("E6"), new Filler("E7"), new Filler("E8")},
		{new Filler("D1"), new Filler("D2"), new Filler("D3"), new Filler("D4"), new Filler("D5"), new Filler("D6"), new Filler("D7"), new Filler("D8")},
		{new Filler("C1"), new Filler("C2"), new Filler("C3"), new Filler("C4"), new Filler("C5"), new Filler("C6"), new Filler("C7"), new Filler("C8")},
		{new Filler("B1"), new Filler("B2"), new Filler("B3"), new Filler("B4"), new Filler("B5"), new Filler("B6"), new Filler("B7"), new Filler("B8")},
		{new Filler("A1"), new Filler("A2"), new Filler("A3"), new Filler("A4"), new Filler("A5"), new Filler("A6"), new Filler("A7"), new Piece("A8")}
	};
	HashMap<String, Integer> getRow = new HashMap<String, Integer>();

	public Board() {
		Piece[][] layout = {
			{new Rook("H1", "black"), new Bishop("H2", "black"), new Knight("H3", "black"), new Queen("H4", "black"), new King("H5", "black"), new Knight("H6", "black"), new Bishop("H7", "black"), new Rook("H8", "black")},
			{new Pawn("G1", "black"), new Pawn("G2", "black"), new Pawn("G3", "black"), new Pawn("G4", "black"), new Pawn("G5", "black"), new Pawn("G6", "black"), new Pawn("G7", "black"), new Pawn("G8", "black")},
			{new Filler("F1"), new Filler("F2"), new Filler("F3"), new Filler("F4"), new Filler("F5"), new Filler("F6"), new Filler("F7"), new Filler("F8")},
			{new Filler("E1"), new Filler("E2"), new Filler("E3"), new Filler("E4"), new Filler("E5"), new Filler("E6"), new Filler("E7"), new Filler("E8")},
			{new Filler("D1"), new Filler("D2"), new Filler("D3"), new Filler("D4"), new Filler("D5"), new Filler("D6"), new Filler("D7"), new Filler("D8")},
			{new Filler("C1"), new Filler("C2"), new Filler("C3"), new Filler("C4"), new Filler("C5"), new Filler("C6"), new Filler("C7"), new Piece("C8")},
			{new Pawn("A1", "white"), new Pawn("A2", "white"), new Pawn("A3", "white"), new Pawn("A4", "white"), new Pawn("A5", "white"), new Pawn("A6", "white"), new Pawn("A7", "white"), new Pawn("A8", "white")},
			{new Rook("B1", "white"), new Bishop("B2", "white"), new Knight("B3", "white"), new Queen("B4", "white"), new King("B5", "white"), new Knight("B6", "white"), new Bishop("B7", "white"), new Rook("B8", "white")},
		};
		this.layout = layout;

		// setting up row conversion hash map
		this.getRow.put("A", 0); this.getRow.put("B", 1); this.getRow.put("C", 2); this.getRow.put("D", 3);
		this.getRow.put("E", 4); this.getRow.put("F", 5); this.getRow.put("G", 6); this.getRow.put("H", 7);
	}

	public void printBoard() {
		System.out.println();
		for (int i=0;i<8;i++) {
			System.out.println("");
			System.out.print("     ");
			for (int j=0;j<8;j++) {
				System.out.print(this.layout[i][j].getSymbol() + "   ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}

	public int[] posToCoords(String pos) {
		int[] out = new int[2];
		out[0] = (int)pos.toUpperCase().charAt(0) - (int)'A';
		out[1] = Integer.parseInt(pos.substring(1));
		return out;
	}

	public String coordsToPos(int[] coords) {
		return "out";	
	}

	public void move_piece(String start, String end) {
		int[] startPos = this.posToCoords(start);
		int[] endPos = this.posToCoords(end);
		Piece pieceToMove = this.layout[startPos[0]][startPos[1]];

		pieceToMove.position = end;
		this.layout[endPos[0]][endPos[1]] = pieceToMove;
		this.layout[startPos[0]][startPos[1]] = new Filler(start);
	}

	public void drawMoveLine(Piece p) {
		/*
		This will us a function called
		get_move_array in each of the
		piece objects to draw a grid that
		shows all possible moves for a
		particular piece.
		*/
		// TODO: Finish this to highlight
		// filler squares properly.
		//String[] move_arr = p.get_move_array();
		System.out.println();
		for (int i=0;i<8;i++) {
			System.out.println("");
			System.out.print("     ");
			for (int j=0;j<8;j++) {
				System.out.print(this.layout[i][j].get_symbol() + "   ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
}