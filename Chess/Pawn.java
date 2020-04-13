package Chess;
import java.util.*;

public class Pawn extends Piece {
	String startPosition;

	public Pawn(String position, String colour, Board board) {
		this.startPosition = position;
		this.position = position;	
		this.symbol = "p";
		this.setColour(colour);
		this.isFiller = false;
	}

	public ArrayList<String> getMoveArray() {
		// TODO: Add en passent
		// TODO: Add diagonal piece taking
		ArrayList<String> out = new ArrayList<String>();
		if (position == startPosition) {
			if (this.isBlack) {
				out.add(Character.toString(this.position.charAt(0))
					+ Character.toString((char)((int)this.position.charAt(1)-2)));
			} else {
				out.add(Character.toString(this.position.charAt(0))
					+ Character.toString((char)((int)this.position.charAt(1)+2)));
			}
		}
		if (this.isBlack) {
			out.add(Character.toString(this.position.charAt(0))
				+ Character.toString((char)((int)this.position.charAt(1)-1)));
		} else {
			out.add(Character.toString(this.position.charAt(0))
				+ Character.toString((char)((int)this.position.charAt(1)+1)));
		}
		this.moveArray = out;
		return out;
	}
} 