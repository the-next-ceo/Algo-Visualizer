import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class InsertionMainWindow {
    private JFrame frame;
	private JButton startButton, pauseButton, sortedPresetButton, reversedPresetButton, randomPresetButton, randomizer;
	private JLabel instructionsLabel, delayLabel;
    private SortPanel insertionSort;
	private JSlider delaySlider;
	private JPanel buttonPanel;
	private JEditorPane numbersPane;
	private ArrayList<Integer> insertionList;
	private ArrayList<SortPanel> sortPanels = new ArrayList<SortPanel>();

	private InsertionSortThread insertionSortThread;
	private ArrayList<SortThread> sortThreads = new ArrayList<SortThread>();

	private State state = State.STOPPED;
	private int delay;
	public SortPanel sp;

    public InsertionMainWindow() {
		
		delay = 500;
	
		frame = new JFrame("Insertion Sort"); //change the name in every window
		frame.setLayout(new GridLayout(3, 3, 10, 10));
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
	
		insertionList = new ArrayList<Integer>();
	
		insertionSort = new SortPanel("Insertion Sort");
		insertionSort.setList(insertionList);
		sortPanels.add(insertionSort);
	
		
		insertionSortThread = new InsertionSortThread(this, insertionSort, delay);
		sortThreads.add(insertionSortThread);
		frame.setVisible(true);
		
		
		frame.setSize(800, 1080);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		frame.add(insertionSort);
		frame.add(buttonPanel);
		frame.add(numbersPane);
	}
    private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == startButton) {
				if (startButton.getText().equalsIgnoreCase("Start"))
					start();
				else
					stop();
			} else if (event.getSource() == pauseButton) {
				pause();
			} else if (event.getSource() == sortedPresetButton) {
				fillSorted();
			} else if (event.getSource() == reversedPresetButton) {
				fillReversed();
			} else if (event.getSource() == randomPresetButton) {
				fillRandomized();
			} else if (event.getSource() == randomizer) {
				makeRandomized();
			}

		}
	}
	private class SliderListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			setDelay(source.getValue());
		}
	}
	public void startDisplay() {
		frame.setVisible(true);
	}

	/** Sets delay between sort actions */
	private void setDelay(int delay) {
		this.delay = delay;
		delayLabel.setText("Delay = " + delay + " ms");
		if (insertionSortThread.isAlive()) {
			insertionSortThread.setDelay(delay);
		}
		
	}
    private void setValues(String nums) {
		String[] numArray = nums.split(" ");
		insertionList.clear();
	
		for (String s : numArray) {
			if (s.matches("^[0-9]*$") && s.length() > 0) {
				int num = Integer.parseInt(s);
				insertionList.add(num);
				
			}
		}
		insertionSort.setColorRange(0, insertionList.size(), Colors.ACTIVE);
		
	}


    	/** Fills the JEditorPane with numbers 1 to 35 */
	private void fillSorted() {
		if (checkAllSorted() || isPaused() || isStopped()) {
			String s = "";
			for (int i = 1; i <= 35; i++) {
				s += i + " ";
			}
			numbersPane.setText(s);
			setValues(s);
		}
	}

	/** Fills the JEditorPane with numbers 35 to 1 */
	private void fillReversed() {
		if (checkAllSorted() || isPaused() || isStopped()) {
			String s = "";
			for (int i = 35; i >= 1; i--) {
				s += i + " ";
			}
			numbersPane.setText(s);
			setValues(s);
		}
	}

	/** Fills the JEditorPane with numbers randomly from 1 to 35 */
	private String fillRandomized() {
		String s = "";
		if (checkAllSorted() || isPaused() || isStopped()) {
			for (int i = 1; i <= 35; i++) {
				s += Math.round(Math.random() * 35 + 1) + " ";
				// s += Math.round(Math.random() * 35 + 1) + " ";
			}
			numbersPane.setText(s);
			setValues(s);
		}
		return s;
	}

	private static String GetStringArray(ArrayList<String> arr) {
		
		//String str[] = new String[arr.size()];
		String str = "";
		// declaration and initialise String Array
		// Collections.shuffle(arr, new Random());
		// System.out.println(arr);
		
		// ArrayList to Array Conversion
		for (int j = 0; j < arr.size(); j++) {
			
			// Assign each value to String array
			str+= arr.get(j) + " ";
		}
		

		//String str1 = Arrays.toString(str);
		
		return str;
	}
	
	private void makeRandomized() {
		ArrayList<String> a = new ArrayList<String>(40);
		if (checkAllSorted() || isPaused() || isStopped()) {
			
			String[] values = numbersPane.getText().split(" ");

			
			for(int i = 0; i < values.length; i++){
				a.add(values[i]);
				
			}
			
			Collections.shuffle(a, new Random());

			//System.out.println(a);
		
			numbersPane.setText(GetStringArray(a));
			setValues(GetStringArray(a));

		}
		//return  GetStringArray(a);
	}

	/** Checks if there are actual numbers entered into the JEditorPane */
	public boolean hasNums(String str) {
		String[] numArray = str.split(" ");
		for (String s : numArray) {
			if (s.matches("^[0-9]*$") && s.length() > 0) {
				return true;
			}

		}
		return false;
	}

	/**
	 * Checks if all four lists have given confirmation that they have been sorted
	 */
	public boolean checkAllSorted() {
		return insertionSortThread.isSorted();
	}

    void start() {
		if (!hasNums(numbersPane.getText()))
			JOptionPane.showMessageDialog(null, "Enter Valid Input");

		state = (state == State.PAUSED || state == State.STOPPED) ? State.STARTED : State.STOPPED;
		if (!isStarted())
			return;

		sortThreads.clear();
		pauseButton.setVisible(true);
		setValues(numbersPane.getText());
		if (insertionList.size() > 0) {
			insertionSortThread = new InsertionSortThread(this, insertionSort, delay);
			sortThreads.add(insertionSortThread);
			insertionSortThread.start();
			startButton.setText("Stop");
			startButton.setToolTipText("Stop sort.");
			frame.repaint();
		}
	}
	

	/** Works as a toggle, pausing the threads */
	private void pause() {
		state = (state == State.STARTED || state == State.STOPPED) ? State.PAUSED : State.STARTED;
		if (isPaused()) {
			startButton.setVisible(false);
			pauseButton.setText("Unpause");
			pauseButton.setToolTipText("Unpause the current sort.");
		} else if (isStarted()) {
			startButton.setVisible(true);
			pauseButton.setText("Pause");
			pauseButton.setToolTipText("Pause the current sort.");
		}
	}

	protected void stop() {
		state = (state == State.STARTED || state == State.PAUSED) ? State.STOPPED : State.STARTED;
		if (!isStopped())
			return;

		/*
		 * for (SortPanel sortPanel : sortPanels) { // Do something }
		 */

		for (SortThread sortThread : sortThreads) {
			if (sortThread.isAlive())
				sortThread.stopThread();
		}
		pauseButton.setVisible(false);

		startButton.setText("Start");
		startButton.setToolTipText("Start sort with numbers provided in text box.");

		sortThreads.clear();
		sortPanels.clear();
	}

    public boolean isStarted() {
		return state == State.STARTED;
	}

	public boolean isPaused() {
		return state == State.PAUSED;
	}

	public boolean isStopped() {
		return state == State.STOPPED;
	}

	public enum State {
		STARTED, PAUSED, STOPPED;
	}
}
