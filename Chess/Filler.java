package Chess;

public class Filler extends Piece {

	public Filler(String position, Board board) {
		this.position = position;
		this.isFiller = true;
		this.isBlack = false;
		this.isWhite = false;
		this.symbol = "O";
		this.board = board;
	}
}