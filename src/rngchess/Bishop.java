package rngchess;

public class Bishop extends Figure {

	protected Bishop(boolean side, int row, int column) {
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
		return side ? "assets/Chess_blt60.png" : "assets/Chess_bdt60.png";
	}

}
