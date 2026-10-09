package rngchess;

public abstract class Figure {
	protected final boolean side;
	private int row;
	private int column;
	private boolean hasMoved;

	protected Figure(boolean side, int row, int column) {
		this.side = side;
		this.row = row;
		this.column = column;
	}

	public boolean getSide() {
		return side;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public boolean hasMoved() {
		return hasMoved;
	}

	public boolean canMoveTo(int targetRow, int targetColumn, Figure[][] board) {
		if (targetRow < 0 || targetRow >= 8 || targetColumn < 0 || targetColumn >= 8) {
			return false;
		}

		// A piece cannot move to its own position
		if (row == targetRow && column == targetColumn) {
			return false;
		}

		Figure destination = board[targetRow][targetColumn];

		// A piece cannot capture another piece on its own side.
		if (destination != null && destination.getSide() == side) {
			return false;
		}

		return isValidMovement(targetRow, targetColumn, board);
	}

	void moveTo(int targetRow, int targetColumn) {
		row = targetRow;
		column = targetColumn;
		hasMoved = true;
	}

	protected abstract boolean isValidMovement(int targetRow, int targetColumn, Figure[][] board);

	public abstract String getImagePath();
}
