
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MainWindow {
	private JFrame frame;
	private JButton selectionsort, quicksort, mergesort, insertionsort, result;
	public SortPanel sp;
	//private compare_result cr;

	public MainWindow() {
		frame = new JFrame("Sorting Algorithms Visualizer");
		frame.setBounds(100, 100, 753, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		MainListener mainListener = new MainListener();

		JLabel lblNewLabel = new JLabel("Algorithm Visualizer");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(211, 40, 335, 39);
		frame.getContentPane().add(lblNewLabel);

		selectionsort = new JButton("Selection Sort");
		selectionsort.addActionListener(mainListener);

		selectionsort.setBounds(52, 158, 138, 55);
		frame.getContentPane().add(selectionsort);

		quicksort = new JButton("Quick Sort");
		quicksort.addActionListener(mainListener);

		quicksort.setBounds(282, 294, 138, 55);
		frame.getContentPane().add(quicksort);

		insertionsort = new JButton("Insertion Sort");
		insertionsort.addActionListener(mainListener);

		insertionsort.setBounds(529, 158, 138, 55);
		frame.getContentPane().add(insertionsort);

		mergesort = new JButton("Merge Sort");
		mergesort.addActionListener(mainListener);
		mergesort.setBounds(52, 425, 138, 55);
		frame.getContentPane().add(mergesort);
		
		result = new JButton("Time Analysis");
		result.setBounds(529, 425, 138, 55);
		result.addActionListener(mainListener);
		frame.getContentPane().add(result);
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
			else if(event.getSource() == result){
				ResultMainWindow res = new ResultMainWindow();
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
