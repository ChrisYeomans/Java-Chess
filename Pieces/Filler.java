package Pieces;

public class Filler extends Piece {

	public Filler(String position) {
		this.position = position;
		this.isFiller = true;

		this.isBlack = false;
		this.isWhite = false;

		this.symbol = "O";
	}
}