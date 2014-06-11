package frontend;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import backend.Model;


public class VisualChooser extends JPanel {
    private GraphicsPanel myGraphicsPanel;
    private JPanel visualPanel;
    private Model myModel;

    public VisualChooser (GraphicsPanel gp) {
        super(new BorderLayout());
        myGraphicsPanel = gp;
        myModel = myGraphicsPanel.getModel();
        createVisualChooser();
        // addListeners();
    }

    private void createVisualChooser () {
        // Create some items to add to the list\
        String listData[] =
        {
         "GoogleMap",
         "HeatMap",
         "Piechart",
         "Histogram"
        };

        JComboBox visualList = new JComboBox(listData);
        ActionListener visualListListener = new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                JComboBox vb = (JComboBox) e.getSource();
                String visualName = (String) vb.getSelectedItem();
                myGraphicsPanel.update(visualName);
            }
        };
        visualList.addActionListener(visualListListener);
        JLabel label = new JLabel("  Choose Data Visualization Tool ");
//        label.setFont(new Font("Serif",Font.PLAIN, 20));
        visualList.setBorder(
                             BorderFactory.createEmptyBorder(0, 0, 10, 0));
        label.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        add(visualList, BorderLayout.SOUTH);
        add(label, BorderLayout.NORTH);

    }

    public JPanel getColorPanel () {
        return visualPanel;
    }
}
