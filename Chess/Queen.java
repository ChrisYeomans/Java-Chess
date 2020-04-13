package Chess;
import java.util.*;

public class Queen extends Piece {
	public Queen(String position, String colour, Board board) {
		this.position = position;	
		this.symbol = "q";
		this.setColour(colour);
		this.isFiller = false;
		this.board = board;
	}

	public ArrayList<String> getMoveArray() {
		ArrayList<String> out = new ArrayList<String>();
		// s = stop, u = up, d = down, l = left, r = right
		boolean sur, sul, sdr, sdl, su, sd, sl, sr;
		sur = sul = sdr = sdl = su = sd = sl = sr = true;
		String tmpPos;
		for (int i=1;i<=8;i++) {
			if (sur) {
				tmpPos = Character.toString((char)((int)position.charAt(0) + i))
					+ Character.toString((char)((int)position.charAt(1)-(int)'1' + i));
				if (!board.isValidPosition(tmpPos)) {
					sur = false;
				} else {
					Piece a = board.getPieceByPos(tmpPos);
					if (a.isFiller) {
						out.add(tmpPos);
					} else {
						if (!(a.isWhite == isWhite)) {
							out.add(tmpPos);
						}
						sur = false;
					}
				}
			}
			if (sul) {
				tmpPos = Character.toString((char)((int)position.charAt(0) + i))
					+ Character.toString((char)((int)position.charAt(1)-(int)'1' - i));
				if (!board.isValidPosition(tmpPos)) {
					sul = false;
				} else {
					Piece a = board.getPieceByPos(tmpPos);
					if (a.isFiller) {
						out.add(tmpPos);
					} else {
						if (!(a.isWhite == isWhite)) {
							out.add(tmpPos);
						}
						sul = false;
					}
				}
			}
			if (sdr) {
				tmpPos = Character.toString((char)((int)position.charAt(0) - i))
					+ Character.toString((char)((int)position.charAt(1)-(int)'1' + i));
				if (!board.isValidPosition(tmpPos)) {
					sdr = false;
				} else {
					Piece a = board.getPieceByPos(tmpPos);
					if (a.isFiller) {
						out.add(tmpPos);
					} else {
						if (!(a.isWhite == isWhite)) {
							out.add(tmpPos);
						}
						sdr = false;
					}
				}
			}
			if (sdl) {
				tmpPos = Character.toString((char)((int)position.charAt(0) - i))
					+ Character.toString((char)((int)position.charAt(1)-(int)'1' - i));
				if (!board.isValidPosition(tmpPos)) {
					sdl = false;
				} else {
					Piece a = board.getPieceByPos(tmpPos);
					if (a.isFiller) {
						out.add(tmpPos);
					} else {
						if (!(a.isWhite == isWhite)) {
							out.add(tmpPos);
						}
						sdl = false;
					}
				}
			}
			if (su) {
				tmpPos = Character.toString((char)((int)position.charAt(0) + i))
					+ Character.toString(position.charAt(1));
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
					+ Character.toString(position.charAt(1));
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
				tmpPos = Character.toString(position.charAt(0))
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
				tmpPos = Character.toString(position.charAt(0))
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