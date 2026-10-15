package rngchess;

public class Pawn extends Figure {

	public Pawn(boolean side, int row, int column) {
		super(side, row, column);
	}

	@Override
	protected boolean isValidMovement(int targetRow, int targetColumn, Figure[][] board) {
		int currentRow = getRow();
		int currentColumn = getColumn();
		int allowedSteps = 1;

		if (!hasMoved) {
			allowedSteps = 2;
		}

		int stepsWantedHorizontally = Math.abs(currentRow - targetRow);
		int stepsWantedVertically = Math.abs(currentColumn - targetColumn);

		if (stepsWantedHorizontally > allowedSteps) {
			return false;
		}

		if (stepsWantedVertically > 1) {
			return false;
		}

		if (stepsWantedVertically == 1) {
			if (board[targetRow][targetColumn] == null) {
				return false;
			}
		}

		if (side) {
			if (currentRow < targetRow) {
				return false;
			}
		} else {
			if (currentRow > targetRow) {
				return false;
			}
		}

		int direction = side ? 1 : -1;

		if (allowedSteps == 2 && stepsWantedHorizontally == 2) {
			if (board[targetRow + direction][targetColumn] != null) {
				return false;
			}
		}

		hasMoved = true;
		return true;
	}

	@Override
	public String getImagePath() {
		return side ? "assets/Chess_plt60.png" : "assets/Chess_pdt60.png";
	}

}
