
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MainWindow {
	private JFrame frame;
	private JButton selectionsort, quicksort, mergesort, insertionsort;
	public SortPanel sp;

	public MainWindow() {
		frame = new JFrame("Sorting Algorithms Visualizer");
		frame.setBounds(100, 100, 692, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		MainListener mainListener = new MainListener();

		JLabel lblNewLabel = new JLabel("Algorithm Visualizer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(211, 40, 335, 39);
		frame.getContentPane().add(lblNewLabel);

		selectionsort = new JButton("Selection Sort");
		selectionsort.addActionListener(mainListener);

		selectionsort.setBounds(53, 218, 138, 55);
		frame.getContentPane().add(selectionsort);

		quicksort = new JButton("Quick Sort");
		quicksort.addActionListener(mainListener);

		quicksort.setBounds(421, 218, 138, 55);
		frame.getContentPane().add(quicksort);

		insertionsort = new JButton("Insertion Sort");
		insertionsort.addActionListener(mainListener);

		insertionsort.setBounds(53, 351, 138, 55);
		frame.getContentPane().add(insertionsort);

		mergesort = new JButton("Merge Sort");
		mergesort.addActionListener(mainListener);
		mergesort.setBounds(421, 351, 138, 55);
		frame.getContentPane().add(mergesort);

	}

	public void startDisplay() {
		frame.setVisible(true);
	}

	/** Interprets button events */
	private class MainListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == selectionsort) {
				SelectionMainWindow select = new SelectionMainWindow();
			}
			else if (event.getSource() == mergesort) {
				MergeMainWindow merge = new MergeMainWindow();
			}
			else if (event.getSource() == quicksort) {
				QuickMainWindow quick = new QuickMainWindow();
			}
			else if (event.getSource() == insertionsort) {
				InsertionMainWindow insertion = new InsertionMainWindow();
			}

		}
	}



	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainWindow mw = new MainWindow();
				mw.startDisplay();
			}
		});
	}

}
