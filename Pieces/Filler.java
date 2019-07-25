package Pieces;

public class Filler extends Piece {

	public Filler(String position) {
		this.position = position;
		this.is_filler = true;

		this.is_black = false;
		this.is_white = false;

		this.symbol = "O";
	}
}