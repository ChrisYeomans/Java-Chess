package Chess;

public class Rook extends Piece {
	public Rook(String position, String colour, Board board) {
		this.position = position;	
		this.symbol = "r";
		this.setColour(colour);
		this.isFiller = false;
		this.board = board;
	}
}