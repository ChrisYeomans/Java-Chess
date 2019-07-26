package Pieces;
import java.util.*;

public class Bishop extends Piece {
	public Bishop(String position, String colour) {
		this.position = position;	
		this.symbol = "b";
		this.set_colour(colour);
		this.is_filler = false;
	}
	public List<String> get_move_array() {
		ArrayList<String> out = new ArrayList<String>();
		out.add(this.position);
		return out;

	}
} 