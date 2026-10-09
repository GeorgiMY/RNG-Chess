package rngchess;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainWindow {

	private JFrame frame;
	private final ChessBoard board = new ChessBoard();
	private final JButton[][] squares = new JButton[8][8];

	private Figure selectedFigure;
	private int selectedRow = -1;
	private int selectedColumn = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		int mainFrameSize = 640;
		int chessBoardSize = 500;

		int windowXPosition = (screenWidth - mainFrameSize) / 2;
		int windowYPosition = (screenHeight - mainFrameSize) / 2;

		frame = new JFrame();
		frame.setBounds(windowXPosition, windowYPosition, mainFrameSize, mainFrameSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.setTitle("RNGChess");

		Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");
		frame.setIconImage(icon);

		JPanel chessBoard = new JPanel();
		chessBoard.setLayout(new GridLayout(8, 8));

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				JButton square = new JButton();

				if ((i + j) % 2 == 0) {
					square.setBackground(Color.DARK_GRAY);
				} else {
					square.setBackground(Color.white);
				}

				square.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
				square.setFocusPainted(false);
				square.setMargin(new Insets(0, 0, 0, 0));
				square.setOpaque(true);

				squares[i][j] = square;

				final int row = i;
				final int column = j;
				square.addActionListener(event -> handleSquareClick(row, column));

				chessBoard.add(square);
			}
		}

		JPanel panel = new JPanel();
		panel.setBounds((mainFrameSize - chessBoardSize) / 2, (mainFrameSize - chessBoardSize) / 2, chessBoardSize,
				chessBoardSize);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		addFiguresToChessBoard();
		renderBoard();

		panel.add(chessBoard);

		JPanel letters = new JPanel();
		letters.setBounds((mainFrameSize - chessBoardSize) / 2, (mainFrameSize - chessBoardSize) / 2 - 30,
				chessBoardSize, 30);
		frame.getContentPane().add(letters);
		letters.setLayout(new GridLayout(1, 8));
		for (int i = 0; i < 8; i++) {
			JLabel ltr = new JLabel(Character.toString((char) 65 + i), JLabel.CENTER);
			letters.add(ltr);
		}

		JPanel numbers = new JPanel();
		numbers.setBounds((mainFrameSize - chessBoardSize) / 2 - 30, (mainFrameSize - chessBoardSize) / 2, 30,
				chessBoardSize);
		frame.getContentPane().add(numbers);
		numbers.setLayout(new GridLayout(8, 1));
		for (int i = 8; i > 0; i--) {
			JLabel ltr = new JLabel(Integer.toString(i));
			numbers.add(ltr);
		}

	}

	private void addFiguresToChessBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Figure figure = null;

				// Pawns
				if (i == 1 || i == 6) {
					boolean pawnColor = i % 2 == 0;
					figure = new Pawn(pawnColor, i, j);
				}

				// Rooks
				if (i == 0 && j == 0 || i == 0 && j == 7 || i == 7 && j == 0 || i == 7 && j == 7) {
					boolean rookColor = i % 6 == 1;
					figure = new Rook(rookColor, i, j);
				}

				// Knights
				if (i == 0 && j == 1 || i == 0 && j == 6 || i == 7 && j == 1 || i == 7 && j == 6) {
					boolean knightColor = i % 5 == 2;
					figure = new Knight(knightColor, i, j);
				}

				// Bishops
				if (i == 0 && j == 2 || i == 0 && j == 5 || i == 7 && j == 2 || i == 7 && j == 5) {
					boolean bishopColor = i % 4 == 3;
					figure = new Bishop(bishopColor, i, j);
				}

				// Queens
				if (i == 0 && j == 3 || i == 7 && j == 3) {
					boolean queenColor = i == 7;
					figure = new Queen(queenColor, i, j);
				}

				// Kings
				if (i == 0 && j == 4 || i == 7 && j == 4) {
					boolean kingColor = i == 7;
					figure = new King(kingColor, i, j);
				}

				if (figure != null) {
					board.placeFigure(figure);
				}
			}
		}
	}

	private void renderBoard() {
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				JButton square = squares[row][column];

				Figure figure = board.getFigureAt(row, column);

				if (figure != null) {
					square.setIcon(new ImageIcon(figure.getImagePath()));
				} else {
					square.setIcon(null);
				}

				square.revalidate();
				square.repaint();
			}
		}
	}

	private void handleSquareClick(int row, int column) {

		// First click: Select a piece.
		if (selectedFigure == null) {
			Figure clickedFigure = board.getFigureAt(row, column);

			// The user clicked an empty square.
			if (clickedFigure == null) {
				return;
			}

			selectedFigure = clickedFigure;
			selectedRow = row;
			selectedColumn = column;

			squares[row][column].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));

			return;
		}

		// Clicking the selected piece again cancels the selection.
		if (row == selectedRow && column == selectedColumn) {
			clearSelection();
			return;
		}

		moveSelectedFigure(row, column);
	}

	private void moveSelectedFigure(int targetRow, int targetColumn) {
		boolean moved = board.tryMove(selectedRow, selectedColumn, targetRow, targetColumn);
		clearSelection();

		if (moved) {
			renderBoard();
		}
	}

	private void clearSelection() {
		if (selectedRow != -1) {
			squares[selectedRow][selectedColumn].setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
			squares[selectedRow][selectedColumn].repaint();
		}

		selectedFigure = null;
		selectedRow = -1;
		selectedColumn = -1;
	}
}
