package Chess;
import java.util.*;

public class Game {
	/*The Game() object wil first check the legality
	and type of moves and then call the relevant Board() methods.
	Also running the Game loop*/
	Board board;
	boolean isWhiteTurn;
	Scanner s;

	public Game() {
		this.s = new Scanner(System.in);
		this.board = new Board();
		this.board.printBoard();
		this.isWhiteTurn = true;
		String piecePosition;
		
		// Game Loop
		while(!board.isWon()) {
			String player = isWhiteTurn ? "white" : "black";
			System.out.println(player + " turn");
			piecePosition = selectPosition();
		};
	}

	private String selectPosition() {
		String pPos;
		while (true) {
			System.out.print("Select Piece Position: ");
			pPos = s.nextLine().toUpperCase();
			if (isValidPiecePosition(pPos)) {
				return pPos;
			} else {
				System.out.println("Sorry, that's not a valid position");
			}
		}
	}

	private boolean isValidPiecePosition(String position) {
		return isValidPosition(position)
			&& ((isWhiteTurn && board.getPieceByPos(position).isWhite)
			|| (!isWhiteTurn && board.getPieceByPos(position).isBlack));
	}

	private boolean isValidPosition(String position) {
		return position.length() == 2 && (int)position.charAt(0) >= 65
			&& (int)position.charAt(0) <= 72 && Character.isDigit(position.charAt(0));
	}
}