package Chess;

public class Piece {
	public String symbol;
	public String position;

	public boolean isBlack;
	public boolean isWhite;
	public boolean isFiller;

	public Board board;

	public Piece() {}

	public String getSymbol() {
		return this.isBlack ? this.symbol.toUpperCase() : this.symbol.toLowerCase(); 
	}

	public void setColour(String colour) {
		this.isBlack = colour == "black";
		this.isWhite = !this.isBlack;
		this.isFiller = false;
	}
}