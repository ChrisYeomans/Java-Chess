package Chess;
import java.util.*;

public class Rook extends Piece {
	public Rook(String position, String colour, Board board) {
		this.position = position;	
		this.symbol = "r";
		this.setColour(colour);
		this.isFiller = false;
		this.board = board;
	}

	public ArrayList<String> getMoveArray() {
		ArrayList<String> out = new ArrayList<String>();
		// s = stop, u = up, d = down, l = left, r = right
		boolean su, sd, sl, sr;
		su = sd = sl = sr = true;
		String tmpPos;
		for (int i=1;i<=8;i++) {
			if (su) {
				tmpPos = Character.toString((char)((int)position.charAt(0) + i))
					+ position.charAt(1);
				if (!board.isValidPosition(tmpPos)) {
					su = false;
				} else {
					Piece a = board.getPieceByPos(tmpPos);
					if (a.isFiller) {
						out.add(tmpPos);
					} else {
						if (!(a.isWhite == isWhite)) {
							out.add(tmpPos);
						}
						su = false;
					}
				}
			}
			if (sd) {
				tmpPos = Character.toString((char)((int)position.charAt(0) - i))
					+ position.charAt(1);
				if (!board.isValidPosition(tmpPos)) {
					sd = false;
				} else {
					Piece a = board.getPieceByPos(tmpPos);
					if (a.isFiller) {
						out.add(tmpPos);
					} else {
						if (!(a.isWhite == isWhite)) {
							out.add(tmpPos);
						}
						sd = false;
					}
				}
			}
			if (sl) {
				tmpPos = position.charAt(0)
					+ Character.toString((char)((int)position.charAt(1)-(int)'1' - i));
				if (!board.isValidPosition(tmpPos)) {
					sl = false;
				} else {
					Piece a = board.getPieceByPos(tmpPos);
					if (a.isFiller) {
						out.add(tmpPos);
					} else {
						if (!(a.isWhite == isWhite)) {
							out.add(tmpPos);
						}
						sl = false;
					}
				}
			}
			if (sr) {
				tmpPos = position.charAt(0)
					+ Character.toString((char)((int)position.charAt(1)-(int)'1' + i));
				if (!board.isValidPosition(tmpPos)) {
					sr = false;
				} else {
					Piece a = board.getPieceByPos(tmpPos);
					if (a.isFiller) {
						out.add(tmpPos);
					} else {
						if (!(a.isWhite == isWhite)) {
							out.add(tmpPos);
						}
						sr = false;
					}
				}
			}
		}
		this.moveArray = out;
		return out;
	}
}