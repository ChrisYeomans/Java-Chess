package Pieces;

public class Rook extends Piece {
	public Rook(String position, String colour) {
		this.position = position;	
		this.symbol = "r";
		this.set_colour(colour);
		this.is_filler = false;
	}
}