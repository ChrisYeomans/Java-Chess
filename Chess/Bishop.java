package Chess;
import java.util.*;

public class Bishop extends Piece {
	public Bishop(String position, String colour, Board board) {
		this.position = position;	
		this.symbol = "b";
		this.setColour(colour);
		this.isFiller = false;
		this.board = board;
	}
	public List<String> getMoveArray() {
		ArrayList<String> out = new ArrayList<String>();
		// s = stop, u = up, d = down, l = left, r = right
		boolean sur, sul, sdr, sdl;
		sur = sul = sdr = sdl = false;
		String tmpPos;
		for (int i=1;i<=8;i++) {
			if (!sur) {
				tmpPos = (char)((int)position.charAt(0) + i)
					+ (char)((int)position.charAt(1)-(int)'1' + i);
				if ()
			}
			if (!sul) {

			}
			if (!sdr) {

			}
			if (!sdl) {

			}
		}
		return out;
	}
} 