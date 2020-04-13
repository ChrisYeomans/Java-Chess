package Chess;
import java.util.*;

public class King extends Piece {
	public King(String position, String colour, Board board) {
		this.position = position;	
		this.symbol = "k";
		this.setColour(colour);
		this.isFiller = false;
		this.board = board;
	}

	public ArrayList<String> getMoveArray() {
		// TODO: Add castling move with checks
		ArrayList<String> out = new ArrayList<String>();
		int[][] moves = {{1, 0}, {0, 1}, {1, 1}, {1, -1},
						{-1, -1}, {-1, 1}, {0, -1}, {-1, 0}};
		String tmpPos;
		for (int[] i : moves) {
			tmpPos = Character.toString((char)((int)position.charAt(0) + i[0]))
					+ Character.toString((char)((int)position.charAt(1)-(int)'1' + i[1])); 
			if (board.isValidPosition(tmpPos)) {
				Piece a = board.getPieceByPos(tmpPos);
				if (a.isFiller || a.isWhite == isWhite) {
					out.add(tmpPos);
				}
			}
		}
		this.moveArray = out;
		return out;
	}
} 