package rngchess;

public class Bishop extends Figure {

	protected Bishop(boolean side, int row, int column) {
		super(side, row, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isValidMovement(int targetRow, int targetColumn, Figure[][] board) {
		int currentRow = getRow();
		int currentColumn = getColumn();

		boolean onLine = false;
		
		if (Math.abs(targetColumn - currentColumn) != Math.abs(targetRow - currentRow)) {
			return false;
		} 

		return true;
	}

	@Override
	public String getImagePath() {
		return side ? "assets/Chess_blt60.png" : "assets/Chess_bdt60.png";
	}

}
