package Chess;
import java.util.*;

public class Board {
	/*
	The Board is just a 2D array of Pieces and also
	acts as a translation layer between array coordinates
	and chess coordinates and also has methods to make changes
	which will be called by the Game() object.
	*/
	Piece[][] layout = {
		{new Filler("H1", this), new Filler("H2", this), new Filler("H3", this), new Filler("H4", this), new Filler("H5", this), new Filler("H6", this), new Filler("H7", this), new Filler("H8", this)},
		{new Filler("G1", this), new Filler("G2", this), new Filler("G3", this), new Filler("G4", this), new Filler("G5", this), new Filler("G6", this), new Filler("G7", this), new Filler("G8", this)},
		{new Filler("F1", this), new Filler("F2", this), new Filler("F3", this), new Filler("F4", this), new Filler("F5", this), new Filler("F6", this), new Filler("F7", this), new Filler("F8", this)},
		{new Filler("E1", this), new Filler("E2", this), new Filler("E3", this), new Filler("E4", this), new Filler("E5", this), new Filler("E6", this), new Filler("E7", this), new Filler("E8", this)},
		{new Filler("D1", this), new Filler("D2", this), new Filler("D3", this), new Filler("D4", this), new Filler("D5", this), new Filler("D6", this), new Filler("D7", this), new Filler("D8", this)},
		{new Filler("C1", this), new Filler("C2", this), new Filler("C3", this), new Filler("C4", this), new Filler("C5", this), new Filler("C6", this), new Filler("C7", this), new Filler("C8", this)},
		{new Filler("B1", this), new Filler("B2", this), new Filler("B3", this), new Filler("B4", this), new Filler("B5", this), new Filler("B6", this), new Filler("B7", this), new Filler("B8", this)},
		{new Filler("A1", this), new Filler("A2", this), new Filler("A3", this), new Filler("A4", this), new Filler("A5", this), new Filler("A6", this), new Filler("A7", this), new Filler("A8", this)}
	};
	HashMap<String, Integer> getRow = new HashMap<String, Integer>();

	public Board() {
		Piece[][] layout = {
			{new Rook("H1", "black", this), new Bishop("H2", "black", this), new Knight("H3", "black", this), new Queen("H4", "black", this), new King("H5", "black", this), new Knight("H6", "black", this), new Bishop("H7", "black", this), new Rook("H8", "black", this)},
			{new Pawn("G1", "black", this), new Pawn("G2", "black", this), new Pawn("G3", "black", this), new Pawn("G4", "black", this), new Pawn("G5", "black", this), new Pawn("G6", "black", this), new Pawn("G7", "black", this), new Pawn("G8", "black", this)},
			{new Filler("F1", this), new Filler("F2", this), new Filler("F3", this), new Filler("F4", this), new Filler("F5", this), new Filler("F6", this), new Filler("F7", this), new Filler("F8", this)},
			{new Filler("E1", this), new Filler("E2", this), new Filler("E3", this), new Filler("E4", this), new Filler("E5", this), new Filler("E6", this), new Filler("E7", this), new Filler("E8", this)},
			{new Filler("D1", this), new Filler("D2", this), new Filler("D3", this), new Filler("D4", this), new Filler("D5", this), new Filler("D6", this), new Filler("D7", this), new Filler("D8", this)},
			{new Filler("C1", this), new Filler("C2", this), new Filler("C3", this), new Filler("C4", this), new Filler("C5", this), new Filler("C6", this), new Filler("C7", this), new Filler("C8", this)},
			{new Pawn("A1", "white", this), new Pawn("A2", "white", this), new Pawn("A3", "white", this), new Pawn("A4", "white", this), new Pawn("A5", "white", this), new Pawn("A6", "white", this), new Pawn("A7", "white", this), new Pawn("A8", "white", this)},
			{new Rook("B1", "white", this), new Bishop("B2", "white", this), new Knight("B3", "white", this), new Queen("B4", "white", this), new King("B5", "white", this), new Knight("B6", "white", this), new Bishop("B7", "white", this), new Rook("B8", "white", this)},
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
		out[1] = 7 - Integer.parseInt(pos.substring(1));
		return out;
	}

	public String coordsToPos(int[] coords) {
		String out = "";
		out += (char)(coords[0] + (int)'A');
		out += 7 - Integer.toString(coords[1]);
		return out;
	}

	public Piece getPieceByPos(String pos) {
		int[] coords = this.posToCoords(pos);
		return this.layout[coords[0]][coords[1]];
	}

	public void movePiece(String start, String end) {
		int[] startPos = this.posToCoords(start);
		int[] endPos = this.posToCoords(end);
		Piece pieceToMove = this.layout[startPos[0]][startPos[1]];

		pieceToMove.position = end;
		this.layout[endPos[0]][endPos[1]] = pieceToMove;
		this.layout[startPos[0]][startPos[1]] = new Filler(start, this);
	}

	public void drawMoveLine(Piece p) {
		/*
		This will usw a function called
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
				System.out.print(this.layout[i][j].getSymbol() + "   ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
}