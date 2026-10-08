package rngchess;

public class Queen extends Figure {

	protected Queen(boolean side, int row, int column) {
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
		// TODO Auto-generated method stub
		return null;
	}

}
