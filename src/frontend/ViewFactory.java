package frontend;

import java.awt.Dimension;
import java.awt.Panel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class ViewFactory {

        public ViewFactory(){

        }

        public static JButton createJButton(String str){
                JButton button = new JButton(str);
                return button;
        }

        public static JFileChooser createJFileChooser(){
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("./"));

                return chooser;
        }
        
        public static JComponent createDropDownMenuTable(){
                
                return null;
        }
        
        public static JComponent createScrollingTable(String[] colNames, Object[][] data){
                JTable table = new ScrollableTable(colNames, data);
                table.setPreferredScrollableViewportSize(new Dimension(500, 70));
                table.setFillsViewportHeight(true);
                //Create the scroll pane and add the table to it.
                JScrollPane scrollPane = new JScrollPane(table);                
                //Add the scroll pane to this panel.
                return scrollPane;
        }
        
        public static JPanel createOptionInputPanel(JComponent[] textAreas, String[] titles){
                JPanel myPanel = new JPanel();
                for(int i=0; i<textAreas.length; i++){
                        myPanel.add(new JLabel(titles[i]));
                        myPanel.add(textAreas[i]);
                        myPanel.add(Box.createHorizontalStrut(15));
                }
                return myPanel;
        }
}