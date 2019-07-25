package Pieces;

public class Queen extends Piece {
	public Queen(String position, String colour) {
		this.position = position;	
		this.symbol = "q";
		this.set_colour(colour);
		this.is_filler = false;
	}
} 