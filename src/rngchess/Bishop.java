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

		if (Math.abs(targetColumn - currentColumn) != Math.abs(targetRow - currentRow)) {
			return false;
		}

		int rowDirection = targetRow > currentRow ? 1 : -1;
		int columnDirection = targetColumn > currentColumn ? 1 : -1;

		while (targetRow != currentRow && targetColumn != currentColumn) {
			currentRow += rowDirection;
			currentColumn += columnDirection;
			if (board[currentRow][currentColumn] != null) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String getImagePath() {
		return side ? "assets/Chess_blt60.png" : "assets/Chess_bdt60.png";
	}

}
