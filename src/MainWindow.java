import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

public class MainWindow {
	private JFrame frame;
	private JButton  selectionsort;
	


	//private State state = State.STOPPED;
	private int delay;
	public SortPanel sp;

	public MainWindow(){
		frame = new JFrame();
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
		
		JButton quicksort = new JButton("Quick Sort");
		quicksort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		quicksort.setBounds(421, 218, 138, 55);
		frame.getContentPane().add(quicksort);
		
		JButton insertionsort = new JButton("Insertion Sort");
		insertionsort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		insertionsort.setBounds(53, 351, 138, 55);
		frame.getContentPane().add(insertionsort);
		
		JButton mergesort = new JButton("Merge Sort");
		mergesort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		mergesort.setBounds(421, 351, 138, 55);
		frame.getContentPane().add(mergesort);
		
	}

	public void startDisplay() {
		frame.setVisible(true);
	}

	/** Sets delay between sort actions */
	// private void setDelay(int delay) {
	// 	this.delay = delay;
	// 	delayLabel.setText("Delay = " + delay + " ms");
	// 	if (selectionSortThread.isAlive()) {
	// 		selectionSortThread.setDelay(delay);
	// 	}
	// 	if (insertionSortThread.isAlive()) {
	// 		insertionSortThread.setDelay(delay);
	// 	}
	// 	if (mergeSortThread.isAlive()) {
	// 		mergeSortThread.setDelay(delay);
	// 	}
	// 	if (quickSortThread.isAlive()) {
	// 		quickSortThread.setDelay(delay);
	// 	}
	// }

	// /** Sets the values in the four lists to the values in the JEditorPane */
	// private void setValues(String nums) {
	// 	String[] numArray = nums.split(" ");
	// 	selectionList.clear();
	// 	insertionList.clear();
	// 	mergeList.clear();
	// 	quickList.clear();
	// 	for (String s : numArray) {
	// 		if (s.matches("^[0-9]*$") && s.length() > 0) {
	// 			int num = Integer.parseInt(s);
	// 			selectionList.add(num);
	// 			insertionList.add(num);
	// 			mergeList.add(num);
	// 			quickList.add(num);
	// 		}
	// 	}
	// 	selectionSort.setColorRange(0, selectionList.size(), Colors.ACTIVE);
	// 	insertionSort.setColorRange(0, insertionList.size(), Colors.ACTIVE);
	// 	mergeSort.setColorRange(0, mergeList.size(), Colors.ACTIVE);
	// 	quickSort.setColorRange(0, quickList.size(), Colors.ACTIVE);
	// }

	// /** Fills the JEditorPane with numbers 1 to 35 */
	// private void fillSorted() {
	// 	if (checkAllSorted() || isPaused() || isStopped()) {
	// 		String s = "";
	// 		for (int i = 1; i <= 35; i++) {
	// 			s += i + " ";
	// 		}
	// 		numbersPane.setText(s);
	// 		setValues(s);
	// 	}
	// }

	// /** Fills the JEditorPane with numbers 35 to 1 */
	// private void fillReversed() {
	// 	if (checkAllSorted() || isPaused() || isStopped()) {
	// 		String s = "";
	// 		for (int i = 35; i >= 1; i--) {
	// 			s += i + " ";
	// 		}
	// 		numbersPane.setText(s);
	// 		setValues(s);
	// 	}
	// }

	// /** Fills the JEditorPane with numbers randomly from 1 to 35 */
	// private String fillRandomized() {
	// 	String s = "";
	// 	if (checkAllSorted() || isPaused() || isStopped()) {
	// 		for (int i = 1; i <= 35; i++) {
	// 			s += Math.round(Math.random() * 35 + 1) + " ";
	// 			// s += Math.round(Math.random() * 35 + 1) + " ";
	// 		}
	// 		numbersPane.setText(s);
	// 		setValues(s);
	// 	}
	// 	return s;
	// }

	// private static String GetStringArray(ArrayList<String> arr) {
		
	// 	//String str[] = new String[arr.size()];
	// 	String str = "";
	// 	// declaration and initialise String Array
	// 	// Collections.shuffle(arr, new Random());
	// 	// System.out.println(arr);
		
	// 	// ArrayList to Array Conversion
	// 	for (int j = 0; j < arr.size(); j++) {
			
	// 		// Assign each value to String array
	// 		str+= arr.get(j) + " ";
	// 	}
		

	// 	//String str1 = Arrays.toString(str);
		
	// 	return str;
	// }
	
	// private void makeRandomized() {
	// 	ArrayList<String> a = new ArrayList<String>(40);
	// 	if (checkAllSorted() || isPaused() || isStopped()) {
			
	// 		String[] values = numbersPane.getText().split(" ");

			
	// 		for(int i = 0; i < values.length; i++){
	// 			a.add(values[i]);
				
	// 		}
			
	// 		Collections.shuffle(a, new Random());

	// 		//System.out.println(a);
		
	// 		numbersPane.setText(GetStringArray(a));
	// 		setValues(GetStringArray(a));

	// 	}
	// 	//return  GetStringArray(a);
	// }

	// /** Checks if there are actual numbers entered into the JEditorPane */
	// public boolean hasNums(String str) {
	// 	String[] numArray = str.split(" ");
	// 	for (String s : numArray) {
	// 		if (s.matches("^[0-9]*$") && s.length() > 0) {
	// 			return true;
	// 		}

	// 	}
	// 	return false;
	// }

	// /**
	//  * Checks if all four lists have given confirmation that they have been sorted
	//  */
	// public boolean checkAllSorted() {
	// 	return selectionSortThread.isSorted() && insertionSortThread.isSorted() && mergeSortThread.isSorted()
	// 			&& quickSortThread.isSorted();
	// }

	/**
	 * Works as a toggle, initializing a new sort or terminating an ongoing sort.
	 */
	/* void start() {
		if (!hasNums(numbersPane.getText()))
			return;

		state = (state == State.PAUSED || state == State.STOPPED) ? State.STARTED : State.STOPPED;
		if (!isStarted())
			return;

		sortThreads.clear();
		pauseButton.setVisible(true);
		setValues(numbersPane.getText());
		if (selectionList.size() > 0) {
			selectionSortThread = new SelectionSortThread(this, selectionSort, delay);
			sortThreads.add(selectionSortThread);
			selectionSortThread.start();

			insertionSortThread = new InsertionSortThread(this, insertionSort, delay);
			sortThreads.add(insertionSortThread);
			insertionSortThread.start();

			mergeSortThread = new MergeSortThread(this, mergeSort, delay);
			sortThreads.add(mergeSortThread);
			mergeSortThread.start();

			quickSortThread = new QuickSortThread(this, quickSort, delay);
			sortThreads.add(quickSortThread);
			quickSortThread.start();

			startButton.setText("Stop");
			startButton.setToolTipText("Stop sort.");
			frame.repaint();
		}
	}
	 */

	/** Works as a toggle, pausing the threads */
	

	

	/** Interprets button events */
	private class MainListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == selectionsort) {
				SelectionMainWindow select = new SelectionMainWindow();
			} 

		}
	}

	/** Modifies delay value based on slider location */
	/* private class SliderListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			setDelay(source.getValue());
		}
	}
 */
	

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


/*public MainWindow() {
		
	delay = 500;

	frame = new JFrame("Sorting Algorithms Visualizer"); //change the name in every window
	frame.setLayout(new GridLayout(3, 2, 10, 10));
	frame.setLocation(5, 5);

	numbersPane = new JEditorPane();
	ButtonListener buttonListener = new ButtonListener();
	instructionsLabel = new JLabel(
			"<html> Enter numbers that you would like to sort, separated by spaces (positive integers only). </html>");

	startButton = new JButton(" ");
	startButton.setText("Start");
	startButton.setToolTipText("Start sort with numbers provided in text box.");
	startButton.addActionListener(buttonListener);
	pauseButton = new JButton("Pause");
	pauseButton.setToolTipText("Pause the current sort.");
	pauseButton.setVisible(false);
	pauseButton.addActionListener(buttonListener);
	sortedPresetButton = new JButton("Use sorted list");
	sortedPresetButton.addActionListener(buttonListener);
	reversedPresetButton = new JButton("Use reversed list");
	reversedPresetButton.addActionListener(buttonListener);
	randomPresetButton = new JButton("Use randomized list");
	randomPresetButton.addActionListener(buttonListener);
	randomizer = new JButton();
	randomizer.setText("Randomizer");
	randomizer.setToolTipText("Changes the position of numbers");
	randomizer.addActionListener(buttonListener);

	delaySlider = new JSlider(0, 500);
	delaySlider.setMajorTickSpacing(100);
	delaySlider.setMinorTickSpacing(50);
	delaySlider.setPaintTicks(true);
	delaySlider.setPaintLabels(true);
	delaySlider.addChangeListener(new SliderListener());
	delayLabel = new JLabel("Delay = " + delaySlider.getValue() + " ms");

	buttonPanel = new JPanel();
	buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
	buttonPanel.setBorder(new EmptyBorder(0, 10, 10, 10));
	buttonPanel.add(instructionsLabel);
	buttonPanel.add(startButton);
	buttonPanel.add(pauseButton);
	buttonPanel.add(delayLabel);
	buttonPanel.add(delaySlider);
	buttonPanel.add(sortedPresetButton);
	buttonPanel.add(reversedPresetButton);
	buttonPanel.add(randomPresetButton);
	buttonPanel.add(randomizer);

	selectionList = new ArrayList<Integer>();
	insertionList = new ArrayList<Integer>();
	mergeList = new ArrayList<Integer>();
	quickList = new ArrayList<Integer>();

	selectionSort = new SortPanel("Selection Sort");
	selectionSort.setList(selectionList);
	sortPanels.add(selectionSort);

	insertionSort = new SortPanel("Insertion Sort");
	insertionSort.setList(insertionList);
	sortPanels.add(insertionSort);

	mergeSort = new SortPanel("Merge Sort");
	mergeSort.setList(mergeList);
	sortPanels.add(mergeSort);

	quickSort = new SortPanel("Quick Sort");
	quickSort.setList(quickList);
	sortPanels.add(quickSort);

	selectionSortThread = new SelectionSortThread(this, selectionSort, delay);
	sortThreads.add(selectionSortThread);
	insertionSortThread = new InsertionSortThread(this, insertionSort, delay);
	sortThreads.add(insertionSortThread);
	mergeSortThread = new MergeSortThread(this, mergeSort, delay);
	sortThreads.add(mergeSortThread);
	quickSortThread = new QuickSortThread(this, quickSort, delay);
	sortThreads.add(quickSortThread);

	frame.setSize(1200, 1080);
	frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(selectionSort);
	frame.add(insertionSort);
	frame.add(mergeSort);
	frame.add(quickSort);
	frame.add(buttonPanel);
	frame.add(numbersPane);
} */