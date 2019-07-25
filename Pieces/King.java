package Pieces;

public class King extends Piece {
	public King(String position, String colour) {
		this.position = position;	
		this.symbol = "k";
		this.set_colour(colour);
		this.is_filler = false;
	}
} 