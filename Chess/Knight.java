package Chess;

public class Knight extends Piece {
	public Knight(String position, String colour, Board board) {
		this.position = position;	
		this.symbol = "n";
		this.setColour(colour);
		this.isFiller = false;
		this.board = board;
	}
} 