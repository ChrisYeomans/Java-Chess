package Pieces;

public class Pawn extends Piece {
	public Pawn(String position, String colour) {
		this.position = position;	
		this.symbol = "p";
		this.setColour(colour);
		this.isFiller = false;
	}
} 