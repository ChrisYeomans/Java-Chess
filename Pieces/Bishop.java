package Pieces;

public class Bishop extends Piece {
	public Bishop(String position, String colour) {
		this.position = position;	
		this.symbol = "b";
		this.set_colour(colour);
		this.is_filler = false;
	}
} 