package Pieces;

public class Knight extends Piece {
	public Knight(String position, String colour) {
		this.position = position;	
		this.symbol = "n";
		this.set_colour(colour);
		this.is_filler = false;
	}
} 