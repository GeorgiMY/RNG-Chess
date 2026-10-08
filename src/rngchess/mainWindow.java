package rngchess;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class mainWindow {

	private JFrame frame;
	private ArrayList<Figure> figures;

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
				JPanel square = new JPanel();

				if ((i + j) % 2 == 0) {
					square.setBackground(Color.DARK_GRAY);
				} else {
					square.setBackground(Color.white);
				}
				square.setVisible(true);
				chessBoard.add(square);
			}
		}

		JPanel panel = new JPanel();
		panel.setBounds((mainFrameSize - chessBoardSize) / 2, (mainFrameSize - chessBoardSize) / 2, chessBoardSize,
				chessBoardSize);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0 };
		gbl_panel.rowHeights = new int[] { 0 };
		gbl_panel.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { Double.MIN_VALUE };
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		addFiguresToChessBoard(chessBoard);

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

	private void addFiguresToChessBoard(JPanel chessBoard) {
		figures = new ArrayList<Figure>();
		ImageIcon whitePawn = new ImageIcon("assets/Chess_plt60.png");
		ImageIcon whiteRook = new ImageIcon("assets/Chess_rlt60.png");
		ImageIcon whiteKnight = new ImageIcon("assets/Chess_nlt60.png");
		ImageIcon whiteBishop = new ImageIcon("assets/Chess_blt60.png");
		ImageIcon whiteQueen = new ImageIcon("assets/Chess_qlt60.png");
		ImageIcon whiteKing = new ImageIcon("assets/Chess_klt60.png");

		ImageIcon blackPawn = new ImageIcon("assets/Chess_pdt60.png");
		ImageIcon blackRook = new ImageIcon("assets/Chess_rdt60.png");
		ImageIcon blackKnight = new ImageIcon("assets/Chess_ndt60.png");
		ImageIcon blackBishop = new ImageIcon("assets/Chess_bdt60.png");
		ImageIcon blackQueen = new ImageIcon("assets/Chess_qdt60.png");
		ImageIcon blackKing = new ImageIcon("assets/Chess_kdt60.png");

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				JPanel square = (JPanel) chessBoard.getComponent(i * 8 + j);
				Figure figure = null;
				JLabel label = null;
				// Pawns
				if (i == 1 || i == 6) {
					boolean pawnColor = i % 2 == 0;
					figure = new Pawn(pawnColor, i, j);
					label = new JLabel(pawnColor ? whitePawn : blackPawn);

				}

				// Rooks
				if (i == 0 && j == 0 || i == 0 && j == 7 || i == 7 && j == 0 || i == 7 && j == 7) {
					boolean rookColor = i % 6 == 1;
					figure = new Rook(rookColor, i, j);
					label = new JLabel(rookColor ? whiteRook : blackRook);
				}

				// Knights
				if (i == 0 && j == 1 || i == 0 && j == 6 || i == 7 && j == 1 || i == 7 && j == 6) {
					boolean knightColor = i % 5 == 2;
					figure = new Knight(knightColor, i, j);
					label = new JLabel(knightColor ? whiteKnight : blackKnight);
				}

				// Bishops
				if (i == 0 && j == 2 || i == 0 && j == 5 || i == 7 && j == 2 || i == 7 && j == 5) {
					boolean bishopColor = i % 4 == 3;
					figure = new Bishop(bishopColor, i, j);
					label = new JLabel(bishopColor ? whiteBishop : blackBishop);
				}

				// Queens
				if (i == 0 && j == 3 || i == 7 && j == 3) {
					boolean queenColor = i == 7;
					figure = new Queen(queenColor, i, j);
					label = new JLabel(queenColor ? whiteQueen : blackQueen);
				}

				// Kings
				if (i == 0 && j == 4 || i == 7 && j == 4) {
					boolean kingColor = i == 7;
					figure = new King(kingColor, i, j);
					label = new JLabel(kingColor ? whiteKing : blackKing);
				}

				if (label != null) {
					square.add(label);
					figures.add(figure);
				}
			}
		}

	}
}
