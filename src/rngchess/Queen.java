package rngchess;

public class Queen extends Figure {

	protected Queen(boolean side, int row, int column) {
		super(side, row, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isValidMovement(int targetRow, int targetColumn, Figure[][] board) {
		int currentRow = getRow();
		int currentColumn = getColumn();
		
		boolean isMovementHorizontalOrVertical = false;
		
		if (currentRow == targetRow || currentColumn == targetColumn) {
			isMovementHorizontalOrVertical = true;
		}
		
		if (isMovementHorizontalOrVertical) {
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
		}
		else {
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
		}
		
		return true;
	}

	@Override
	public String getImagePath() {
		return side ? "assets/Chess_qlt60.png" : "assets/Chess_qdt60.png";
	}

}
