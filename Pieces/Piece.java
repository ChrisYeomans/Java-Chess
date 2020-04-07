package Pieces;

public class Piece {
	public String symbol;
	public String position;

	public boolean isBlack;
	public boolean isWhite;
	public boolean isFiller;

	public Piece(String symbol, String position, String colour) {
		// r = rook, b = bishop, n = knight, q = queen, k = king, p = pawn, o = filler
		this.symbol = symbol; 
		this.position = position;

		if (colour == "black") {
			this.isBlack = true;
		} else {
			this.isBlack = false;
		}
		this.isWhite = !this.isBlack;

		this.isFiller = false;
	}

	public Piece(String position) {
		this.isFiller = true;
		this.position = position;

		this.isBlack = false;
		this.isWhite = false;
		this.symbol = "O";
	}

	public Piece() {} // empty constructor

	public String getSymbol() {
		if (!this.isBlack) {
			return this.symbol.toLowerCase(); // white is lower case
		} else {
			return this.symbol.toUpperCase();
		}
	}

	public void setColour(String colour) {
		if (colour == "black") {
			this.isBlack = true;
		} else {
			this.isBlack = false;
		}
		this.isWhite = !this.isBlack;

		this.isFiller = false;
	}
}