package Chess;

public class King extends Piece {
	public King(String position, String colour, Board board) {
		this.position = position;	
		this.symbol = "k";
		this.setColour(colour);
		this.isFiller = false;
		this.board = board;
	}
} 