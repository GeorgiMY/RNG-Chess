package rngchess;

public class Pawn extends Figure {

	public Pawn(boolean side, int row, int column) {
		super(side, row, column);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean isValidMovement(int targetRow, int targetColumn, Figure[][] board) {
		int currentRow = getRow();
		int currentColumn = getColumn();
		int allowedStep = 1;

		if (!hasMoved) {
			allowedStep = 2;
		}

		int stepsWanted = Math.abs(currentRow - targetRow);

		if (stepsWanted > allowedStep) {
			return false;
		}

		// white -1 | black 1
		int direction = side ? -1 : 1;
		if (side) {
			if (board[currentRow + direction][currentColumn - 1] != null || board[currentRow + direction][currentColumn + 1] != null) {
				return false;
			}
			
			for (int i = currentRow; i > targetRow; i--) {
				if (board[i + direction][currentColumn] != null) {
					
					return false;
				}
			}
		}
		else {
			for (int i = currentRow; i < targetRow; i++) {
				if (board[i + direction][currentColumn] != null) {
					if (board[i + direction][currentColumn - 1] != null || board[i + direction][currentColumn + 1] != null) {
						break;
					}
					return false;
				}
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
