
/** Runs a selection sort algorithm. */
public class SelectionSortThread extends SortThread {
	

	private final SelectionMainWindow mainWindow;

	public SelectionSortThread(SelectionMainWindow mainWindow, SortPanel sp, long msdelay) {
		super(sp, msdelay);
		this.mainWindow = mainWindow;
	}
	public long Selectionstart(){
		long start = System.currentTimeMillis();
		return start;
	}
	public long Selectionend(){
		long end =  System.currentTimeMillis();
		return end;
	}


	public void run() {
		int i, smallestIndex;
		int listSize = sp.getListSize();
		Selectionstart();
		for (i = 0; i < listSize && (mainWindow.isStarted() || mainWindow.isPaused()); i++) {
			if (mainWindow.isStopped())
				return;

			while (mainWindow.isPaused())
				sleepThread(10);

			smallestIndex = i;

			sp.setLine(sp.get(smallestIndex));
			sp.setMessage("Searching remaining list for smallest element. Smallest found: " + sp.get(smallestIndex));

			for (int j = i; j < listSize && (mainWindow.isStarted() || mainWindow.isPaused()); j++) {
				if (mainWindow.isStopped())
					return;

				while (mainWindow.isPaused())
					sleepThread(10);

				//sp.setColor(smallestIndex, Colors.TARGET);
				sp.setIndex(j);

				if (sp.get(j) < sp.get(smallestIndex)) {
					sp.setColor(j, Colors.TARGET);
					sp.setColor(smallestIndex, Colors.ACTIVE);
					smallestIndex = j;
					sp.setLine(sp.get(smallestIndex));
				sp.inbar(Integer.toString(sp.get(smallestIndex)));

					sp.setMessage("Searching remaining list for smallest element. Smallest found: "
							+ sp.get(smallestIndex) + ".");
				}
				repaint();
				sleepThread(msdelay);
			}
			sp.swap(i, smallestIndex);
			sp.setColor(i, Colors.SORTED);
			repaint();
		}
		Selectionend();

		if (i == listSize) {
			sorted = true;
			sp.setLine(0);
			//sp.setMessage("Sorted!");
			sp.setMessage("Time Complexity: O(n^2)");
			//sp.setMessage("Time taken: " + (end-start) + "ms");

		} else {
			sp.setColorRange(i + 1, Colors.ACTIVE);
		}
		repaint();

		if (mainWindow.checkAllSorted() && mainWindow.isStarted()) {
			mainWindow.stop();
		}
	}
	
}