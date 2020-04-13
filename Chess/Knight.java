package Chess;
import java.util.*;

public class Knight extends Piece {
	public Knight(String position, String colour, Board board) {
		this.position = position;	
		this.symbol = "n";
		this.setColour(colour);
		this.isFiller = false;
		this.board = board;
	}

	public ArrayList<String> getMoveArray() {
		ArrayList<String> out = new ArrayList<String>();
		int[][] moves = {{2, -1}, {1, -2}, {2, 1}, {1, 2},
						{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}};
		String tmpPos;
		for (int[] i : moves) {
			tmpPos = Character.toString((char)((int)position.charAt(0) + i[0]))
					+ Character.toString((char)((int)position.charAt(1) + i[1])); 
			if (board.isValidPosition(tmpPos)) {
				Piece a = board.getPieceByPos(tmpPos);
				if (a.isFiller || (a.isWhite == isWhite)) {
					out.add(tmpPos);
				}
			}
		}
		this.moveArray = out;
		return out;
	}
} 