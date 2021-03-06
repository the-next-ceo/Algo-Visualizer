import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ResultMainWindow {
    private JFrame frame; 
    private JTable table;

    public ResultMainWindow() {
        frame = new JFrame("Time Analysis"); 
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(700, 250);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());

        List<String> a = new ArrayList<>();

        a.add("2407 ms"); 
        a.add("1557 ms");
        a.add("1498 ms");
        a.add("1517 ms");
        a.add("3458 ms");
        a.add("4509 ms");
        a.add("2568 ms");
        a.add("2605 ms");
        a.add("2618 ms");
        a.add("2563 ms");
        a.add("1652 ms");
        a.add("1104 ms");
        a.add("1104 ms");
        a.add("1104 ms");
        a.add("1104 ms");
        a.add("1104 ms");
        
        //This is only for show not real results.


        
        String[] columns = { "Name", "Time Complexity", "Time taken" };
        Object[][] rows = { { "Selection Sort", "O(n^2)", rand_values(a)},
            { "Quick Sort", "O(n^2)", rand_values(a) }, { "Insertion Sort", "O(n^2)" , rand_values(a) }, { "Merge Sort", "O(nlogn)",rand_values(a) } };

        
            table = new JTable(rows, columns) {
            public boolean isCellEditable(int rows, int columns) {
                return false;
            }

            public Component prepareRenderer(TableCellRenderer r, int rows, int columns) {
                Component c = super.prepareRenderer(r, rows, columns);

                if (rows % 2 == 0)
                    c.setBackground(Color.WHITE);

                else
                    c.setBackground(Color.LIGHT_GRAY);

                if (isCellSelected(rows, columns) == true) {
                    c.setBackground(Color.GREEN);
                }
                return c;
            }
        };
        
        table.setPreferredScrollableViewportSize(new Dimension(500, 65));
        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);
        frame.add(scroll);
        table.repaint();
       
    }
    public String rand_values(List<String> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}