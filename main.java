public class main {
	public static void main(String[] args) {
		Board board = new Board();
		board.print_board();
		System.out.println(board.pos_to_coords("A1"));
	}
}