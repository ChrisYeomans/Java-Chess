public class Game {
	/*The Game() object wil first check the legality
	and type of moves and then call the relevant Board() methods.*/
	Board board;

	public Game() {
		this.board = new Board();
		this.board.print_board();
	}
	
}