package rngchess;

public class ChessBoard {

	public static final int SIZE = 8;

	private final Figure[][] board = new Figure[SIZE][SIZE];

	public Figure getFigureAt(int row, int column) {
		if (!isInsideBoard(row, column)) {
			return null;
		}

		return board[row][column];
	}

	public void placeFigure(Figure figure) {
		int row = figure.getRow();
		int column = figure.getColumn();

		board[row][column] = figure;
	}

	public boolean tryMove(int sourceRow, int sourceColumn, int targetRow, int targetColumn) {
		if (!isInsideBoard(sourceRow, sourceColumn) || !isInsideBoard(targetRow, targetColumn)) {
			return false;
		}

		if (sourceRow == targetRow && sourceColumn == targetColumn) {
			return false;
		}

		Figure movingFigure = board[sourceRow][sourceColumn];

		if (movingFigure == null) {
			return false;
		}

		if (!isMoveAllowed(movingFigure, targetRow, targetColumn)) {
			return false;
		}

		board[sourceRow][sourceColumn] = null;
		board[targetRow][targetColumn] = movingFigure;
		movingFigure.moveTo(targetRow, targetColumn);

		return true;
	}

	private boolean isMoveAllowed(Figure movingFigure, int targetRow, int targetColumn) {
		// Add future rules here. For example:
		// if (!movingFigure.canMoveTo(targetRow, targetColumn, board)) {
		// return false;
		// }
		return true;
	}

	private boolean isInsideBoard(int row, int column) {
		return row >= 0 && row < SIZE && column >= 0 && column < SIZE;
	}
}
