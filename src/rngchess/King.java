package rngchess;

public class King extends Figure {

	protected King(boolean side, int row, int column) {
		super(side, row, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isValidMovement(int targetRow, int targetColumn, Figure[][] board) {
		int currentRow = getRow();
		int currentColumn = getColumn();

		int distanceRow = Math.abs(targetRow - currentRow);
		int distanceColumn = Math.abs(targetColumn - currentColumn);
		
		return distanceRow == 1 || distanceColumn == 1;
	}

	@Override
	public String getImagePath() {
		return side ? "assets/Chess_klt60.png" : "assets/Chess_kdt60.png";
	}

}
