package Pieces;
import java.util.*;

public class Bishop extends Piece {
	public Bishop(String position, String colour) {
		this.position = position;	
		this.symbol = "b";
		this.setColour(colour);
		this.isFiller = false;
	}
	public List<String> getMoveArray() {
		ArrayList<String> out = new ArrayList<String>();
		out.add(this.position);
		return out;
	}
} 