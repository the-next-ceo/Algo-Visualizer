
/** Runs an insertion sort algorithm. */
public class InsertionSortThread extends SortThread {

	private final InsertionMainWindow mainWindow;
	
	public InsertionSortThread(InsertionMainWindow mergeMainWindow, SortPanel sp, long msdelay) {
		super(sp, msdelay);
		this.mainWindow = mergeMainWindow;
	}
	
	

	public void initialSP(int index) {
		sp.setIndex(index);
		sp.setColorRange(0, index, Colors.ACTIVE);
		sp.setColor(index, Colors.TARGET);
		sp.setLine(sp.get(index));
		sp.setMessage("Finding location where previous numbers < "
				+ sp.get(index) + " < following numbers.");
	}

	private void finalSP() {
		sp.setColorRange(0, Colors.SORTED);
		sp.setLine(0);
		sp.setMessage("Sorted!");
		sp.setMessage("Time Complexity: O(n^2)");

	}
	
	public void run() {
		int listSize = sp.getListSize();
		int i, j, val;

		for (i = 0; i < listSize && (mainWindow.isStarted() || mainWindow.isPaused()); i++) {
			if (mainWindow.isStopped())
				return;

			while (mainWindow.isPaused())
				sleepThread(10);

			initialSP(i);
			val = sp.get(i);
			//sp.inbar(Integer.toString(sp.get(i+1)));
			sp.inbar(Integer.toString(sp.get(i)));
			repaint();
			sleepThread(msdelay);
			for (j = i - 1; j >= 0 && val < sp.get(j); j--) {
				//System.out.println(sp.get(i));
				if (mainWindow.isStopped())
				return;
				
				while (mainWindow.isPaused())
				sleepThread(10);
				
				sp.swap(j, j + 1);
				repaint();
				sleepThread(msdelay);
			}
			repaint();
		}

		if (i == listSize && mainWindow.isStarted()) {
			sorted = true;
			finalSP();
			repaint();
		}
		sleepThread(msdelay);
		
		if (mainWindow.checkAllSorted() && mainWindow.isStarted()) {
			mainWindow.stop();
		}
	}
}