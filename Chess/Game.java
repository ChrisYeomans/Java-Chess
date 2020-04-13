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
		this.isWhiteTurn = true;
		String piecePosition;
		int winner = -1;
		board.updateAttackArrays();
		
		// Game Loop
		while(winner == -1) {
			String player = isWhiteTurn ? "white" : "black";
			System.out.println("\n\n" + player + " turn");
			board.printBoard();
			// TODO: make selection cancellable 
			piecePosition = selectPosition("Select Piece to Move: ", true);
			board.drawMoveLine(board.getPieceByPos(piecePosition));
			board.movePiece(piecePosition,
				selectPosition("Select place to move selected piece: ", false));
			board.updateAttackArrays();
			isWhiteTurn = !isWhiteTurn;
			winner = board.winner();
		};
	}

	private String selectPosition(String message, boolean piecePosition) {
		String pPos;
		while (true) {
			System.out.print(message);
			pPos = s.nextLine().toUpperCase();
			if (board.isValidPosition(pPos) 
				&& (!piecePosition || board.isValidPiecePosition(pPos, isWhiteTurn))) {
				return pPos;
			} else {
				System.out.println("Sorry, that's not a valid position");
			}
		}
	}
}