package rngchess;

public class Knight extends Figure {

	protected Knight(boolean side, int row, int column) {
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
		return side ? "assets/Chess_nlt60.png" : "assets/Chess_ndt60.png";
	}

}
