import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ResultMainWindow extends JFrame {
    private JFrame frame;
    private SelectionSortThread ss;
	JTable table;
    public ResultMainWindow(){
    
    
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(700, 250);
	frame.setVisible(true);
	frame.setTitle("Result Analysis");
    }
    public void run() {
		setLayout(new FlowLayout());
		String[] columns = { "Name", "Time Complexity", "Time taken" };
		Object[][] rows = { { "Selection Sort", "da", ss.Selectionstart() - ss.Selectionend() }, { "Quick Sort", "sa", null },
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

		JScrollPane scroll = new JScrollPane(table);
		add(scroll);
	}
}
