package rngchess;

public class Rook extends Figure {

	protected Rook(boolean side, int row, int column) {
		super(side, row, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isValidMovement(int targetRow, int targetColumn, Figure[][] board) {
		int currentRow = getRow();
		int currentColumn = getColumn();

		boolean horizontalMove = currentRow == targetRow;
		boolean verticalMove = currentColumn == targetColumn;

		if (!horizontalMove && !verticalMove) {
			return false;
		}

		int rowStep = Integer.compare(targetRow, currentRow);
		int columnStep = Integer.compare(targetColumn, currentColumn);

		int row = currentRow + rowStep;
		int column = currentColumn + columnStep;

		// Check every square before the destination.
		while (row != targetRow || column != targetColumn) {
			if (board[row][column] != null) {
				return false;
			}

			row += rowStep;
			column += columnStep;
		}

		return true;
	}

	@Override
	public String getImagePath() {
		return side ? "assets/Chess_rlt60.png" : "assets/Chess_rdt60.png";
	}

}
