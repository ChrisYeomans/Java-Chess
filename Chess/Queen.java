package Chess;

public class Queen extends Piece {
	public Queen(String position, String colour, Board board) {
		this.position = position;	
		this.symbol = "q";
		this.setColour(colour);
		this.isFiller = false;
		this.board = board;
	}
} 