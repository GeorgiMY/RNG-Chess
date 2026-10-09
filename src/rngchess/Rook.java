package rngchess;

public class Rook extends Figure {

	protected Rook(boolean side, int row, int column) {
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
		return side ? "assets/Chess_rlt60.png" : "assets/Chess_rdt60.png";
	}

}
