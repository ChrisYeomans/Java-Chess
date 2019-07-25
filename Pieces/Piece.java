package Pieces;

public class Piece {
	public String symbol;
	public String position;

	public boolean is_black;
	public boolean is_white;
	public boolean is_filler;

	public Piece(String symbol, String position, String colour) {
		// r = rook, b = bishop, n = knight, q = queen, k = king, p = pawn, o = filler
		this.symbol = symbol; 
		this.position = position;

		if (colour == "black") {
			this.is_black = true;
		} else {
			this.is_black = false;
		}
		this.is_white = !this.is_black;

		this.is_filler = false;
	}

	public Piece(String position) {
		this.is_filler = true;
		this.position = position;

		this.is_black = false;
		this.is_white = false;
		this.symbol = "O";
	}

	public Piece() {} // empty constructor

	public String get_symbol() {
		if (!this.is_black) {
			return this.symbol.toLowerCase(); // white is lower case
		} else {
			return this.symbol.toUpperCase();
		}
	}

	public void set_colour(String colour) {
		if (colour == "black") {
			this.is_black = true;
		} else {
			this.is_black = false;
		}
		this.is_white = !this.is_black;

		this.is_filler = false;
	}
}