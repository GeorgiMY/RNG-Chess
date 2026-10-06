package rngchess;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

public class mainWindow {

	private JFrame frame;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 677, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel chessBoard = new JPanel();
		chessBoard.setLayout(new GridLayout(8, 8));
		
		for (int i=0;i<8;i++) {
			for (int j=0;j<8;j++) {
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
		panel.setBounds(168, 11, 345, 346);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel.add(chessBoard);
		
		JPanel letters = new JPanel();
		letters.setBounds(168, 368, 345, 28);
		frame.getContentPane().add(letters);
		letters.setLayout(new GridLayout(1,8));
		for (int i=0;i<8;i++) {
			JLabel ltr = new JLabel(Character.toString((char) 65+i), JLabel.CENTER);
			letters.add(ltr);
		}
		
		
		JPanel numbers = new JPanel();
		numbers.setBounds(133, 11, 25, 346);
		frame.getContentPane().add(numbers);
		numbers.setLayout(new GridLayout(8,1));
		for (int i=8;i>0;i--) {
			JLabel ltr = new JLabel(Integer.toString(i));
			numbers.add(ltr);
		}
	
		
		
		
		
		
			
			
		}
	}

