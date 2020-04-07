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
		this.isBlack = colour == "black";
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

	public Piece() {}

	public String getSymbol() {
		return this.isBlack ? this.symbol.toUpperCase() : this.symbol.toLowerCase; 
	}

	public void setColour(String colour) {
		this.isBlack = colour == "black";
		this.isWhite = !this.isBlack;
		this.isFiller = false;
	}
}