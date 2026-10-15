package rngchess;

public class Knight extends Figure {

	protected Knight(boolean side, int row, int column) {
		super(side, row, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isValidMovement(int targetRow, int targetColumn, Figure[][] board) {
		int currentRow = getRow();
		int currentColumn = getColumn();
		
		int stepsWantedRow = Math.abs(targetRow - currentRow);
		int stepsWantedColumn = Math.abs(targetColumn - currentColumn);

		return (stepsWantedRow == 1 && stepsWantedColumn == 2) || (stepsWantedRow == 2 && stepsWantedColumn == 1);
	}

	@Override
	public String getImagePath() {
		return side ? "assets/Chess_nlt60.png" : "assets/Chess_ndt60.png";
	}

}
