package rngchess;

public class Pawn extends Figure {

	public Pawn(boolean side, int row, int column) {
		super(side, row, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isValidMovement(int targetRow, int targetColumn, Figure[][] board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getImagePath() {
		return side ? "assets/Chess_plt60.png" : "assets/Chess_pdt60.png";
	}

}
