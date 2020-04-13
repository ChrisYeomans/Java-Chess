package Chess;
import java.util.*;

public class Board {
	/*
	The Board is just a 2D array of Pieces and also
	acts as a translation layer between array coordinates
	and chess coordinates and also has methods to make changes
	which will be called by the Game() object.
	*/
	Piece[][] layout = new Piece[8][8];
	boolean[][] blackAttack = new boolean[8][8];
	boolean[][] whiteAttack = new boolean[8][8];
	Piece blackKing, whiteKing;

	public Board() {
		Piece[][] layout = {
			{new Rook("A8", "black", this), new Bishop("B8", "black", this), new Knight("C8", "black", this), new Queen("D8", "black", this), new King("E8", "black", this), new Knight("F8", "black", this), new Bishop("G8", "black", this), new Rook("H8", "black", this)},
			{new Pawn("A7", "black", this), new Pawn("B7", "black", this), new Pawn("C7", "black", this), new Pawn("D7", "black", this), new Pawn("E7", "black", this), new Pawn("F7", "black", this), new Pawn("G7", "black", this), new Pawn("H7", "black", this)},
			{new Filler("A6", this), new Filler("B6", this), new Filler("C6", this), new Filler("D6", this), new Filler("E6", this), new Filler("F6", this), new Filler("G6", this), new Filler("H6", this)},
			{new Filler("A5", this), new Filler("B5", this), new Filler("C5", this), new Filler("D5", this), new Filler("E5", this), new Filler("F5", this), new Filler("G5", this), new Filler("H5", this)},
			{new Filler("A4", this), new Filler("B4", this), new Filler("C4", this), new Filler("D4", this), new Filler("E4", this), new Filler("F4", this), new Filler("G4", this), new Filler("H4", this)},
			{new Filler("A3", this), new Filler("B3", this), new Filler("C3", this), new Filler("D3", this), new Filler("E3", this), new Filler("F3", this), new Filler("G3", this), new Filler("H3", this)},
			{new Pawn("A2", "white", this), new Pawn("B2", "white", this), new Pawn("C2", "white", this), new Pawn("D2", "white", this), new Pawn("E2", "white", this), new Pawn("F2", "white", this), new Pawn("G2", "white", this), new Pawn("H2", "white", this)},
			{new Rook("A1", "white", this), new Bishop("B1", "white", this), new Knight("C1", "white", this), new Queen("D1", "white", this), new King("E1", "white", this), new Knight("F1", "white", this), new Bishop("G1", "white", this), new Rook("H1", "white", this)},
		};
		this.layout = layout;
		blackKing = this.layout[0][4];
		whiteKing = this.layout[7][4];

		for (int i=0;i<8;i++) {
			for (int j=0;j<8;j++) {
				blackAttack[i][j] = false;
				whiteAttack[i][j] = false;
			}
		}
	}

	public void updateAttackArrays() {
		for (int i=0;i<8;i++) {
			for (int j=0;j<8;j++) {
				blackAttack[i][j] = false;
				whiteAttack[i][j] = false;
			}
		}

		Piece p;
		ArrayList<String> pMoveArray;
		int[] coords;
		for (int i=0;i<8;i++) {
			for (int j=0;j<8;j++) {
				p = layout[i][j];
				pMoveArray = p.getMoveArray();
				if (!p.isFiller) {
					if (p.isWhite) {
						for (String m : pMoveArray) {
							coords = posToCoords(m);
							whiteAttack[coords[0]][coords[1]] = true;
						}
					} else {
						for (String m : pMoveArray) {
							coords = posToCoords(m);
							blackAttack[coords[0]][coords[1]] = true;
						}
					}
				}
			}
		}
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
		out[1] = (int)pos.toUpperCase().charAt(0) - (int)'A';
		out[0] = 8 - Integer.parseInt(pos.substring(1));
		return out;
	}

	public String coordsToPos(int[] coords) {
		String out = "";
		out += (char)(coords[1] + (int)'A');
		out += Integer.toString(8 - coords[0]);
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
		This will use a function called
		get_move_array in each of the
		piece objects to draw a grid that
		shows all possible moves for a
		particular piece.
		*/
		// TODO: Finish this to highlight
		// filler squares properly.
		ArrayList<String> moveArr = p.moveArray;
		for (String s : moveArr) {System.out.println(s + "\n");}
		System.out.println(moveArr.size());
		String pos;
		System.out.println();
		for (int i=0;i<8;i++) {
			System.out.println("");
			System.out.print("     ");
			for (int j=0;j<8;j++) {
				pos = coordsToPos(new int[] {i, j});
				if (moveArr.contains(pos)) {
					System.out.print(this.layout[i][j].getSymbol() + "|  ");
				} else {
					System.out.print(this.layout[i][j].getSymbol() + "   ");
				}
			}
			System.out.println();
		}
		System.out.println("\n");
	}


	public boolean isBlackMate() {
		int[] posCoords;
		boolean out = true;
		for (String m : blackKing.getMoveArray()) {
			posCoords = posToCoords(m);
			if (!whiteAttack[posCoords[0]][posCoords[1]]) {
				out = false;
				break;
			}
		}
		return out;
	}

	public boolean isWhiteMate() {
		int[] posCoords;
		boolean out = true;
		for (String m : whiteKing.getMoveArray()) {
			posCoords = posToCoords(m);
			if (!blackAttack[posCoords[0]][posCoords[1]]) {
				out = false;
				break;
			}
		}
		return out;
	}

	public int winner() {
		// -1 = no winner; 0 = white wins; 1 = black wins
		int[] blackKingCoords = posToCoords(blackKing.position);
		int[] whiteKingCoords = posToCoords(whiteKing.position);
		if (whiteAttack[blackKingCoords[0]][blackKingCoords[1]]) {
			if (this.isBlackMate()) {
				return 0;
			}
		}
		if (blackAttack[whiteKingCoords[0]][whiteKingCoords[1]]) {
			if (this.isWhiteMate()) {
				return 1;
			}
		}
		return -1;
	}

	public boolean isValidPiecePosition(String position, boolean isWhiteTurn) {
		return isValidPosition(position)
			&& ((isWhiteTurn && getPieceByPos(position).isWhite)
			|| (!isWhiteTurn && getPieceByPos(position).isBlack));
	}

	public boolean isValidPosition(String position) {
		return position.length() == 2
			&& (int)position.charAt(0) >= (int)'A' && (int)position.charAt(0) <= (int)'H'
			&& (int)position.charAt(1) >= (int)'1' && (int)position.charAt(1) <= (int)'8';
	}
}