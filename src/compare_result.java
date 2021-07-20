
public class compare_result{
	private long start;

	public long getStart(long value){
        this.start = value;
        return this.start;
    }

	
} 

/* public class compare_result extends JFrame {

	JTable table;
	private JFrame frame;

	public void run() {
		setLayout(new FlowLayout());
		Object[] columns = { "Name", "Time Complexity", "Time taken" };
		Object[][] rows = { { "Selection Sort", "da", null }, { "Quick Sort", "sa", null },
				{ "Insertion Sort", "ads", null }, { "Merge Sort", "fa", null } };

		
		table = new JTable(rows, columns)
		{
			public boolean isCellEditable(int rows, int columns) {
				return false;
			}

			public Component prepareRenderer(TableCellRenderer r, int rows, int columns) {
				Component c = super.prepareRenderer(r, rows, columns);

				if (rows % 2 == 0)
					c.setBackground(Color.WHITE);

				else
					c.setBackground(Color.LIGHT_GRAY);

				if (isCellSelected(rows, columns) == true){
					c.setBackground(Color.GREEN);}
				else if(isCellSelected(rows, columns) == false){
					c.setBackground(Color.WHITE);
				}
				return c;
			}
		};
		//table.isCellEditable(rows, columns);
		table.setPreferredScrollableViewportSize(new Dimension(500, 65));
		table.setFillsViewportHeight(true);
		table.setValueAt(45, 0, 2);

		JScrollPane scroll = new JScrollPane(table);
		add(scroll);
	}
	
	 */

	/* public static void main(String[] args) {
		//JFrame result = new JFrame();
		compare_result result = new compare_result();
		result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		result.setSize(700, 250);
		result.setVisible(true);
		result.setTitle("Result Analysis");
		//result.add(res);
	} */


