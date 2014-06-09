package frontend;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import backend.Model;
import frontend.SimulationDisplay;


@SuppressWarnings("serial")
public class ButtonManager extends JComponent {
    // private JButton exitProgram;
    private JButton myInfoButton;
    private JButton myRunButton;
    private JButton myDuplicateWindowButton;
    private GraphicsPanel myGraphicsPanel;
    private Model myModel;
    private ActionListener myPaintButtonListener;
    // private ActionListener myExitButtonListener;
    private ActionListener myShowInfoButtonListener;
    private ActionListener myDuplicateWindowButtonListener;

    protected ButtonManager () {
        // myFrontEndViwer = v;
        makeListeners();
        makeButtons();
    }

    public void setModel(Model m){
        myModel=m;
    }

    public void setGraphPanel(GraphicsPanel gp){
        myGraphicsPanel = gp;
    }

    private JFileChooser makeFileChooser () {
        final JFileChooser fc = new JFileChooser();
        File currentDirectory = null;
        try {
            currentDirectory = new File(new File("").getCanonicalPath());
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
        fc.setCurrentDirectory(currentDirectory);
        return fc;
    }

    private void makeListeners () {
        myPaintButtonListener = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                JFileChooser fc = makeFileChooser();
                int returnVal = fc.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    myGraphicsPanel.setImageFile(file.getName());
                    myGraphicsPanel.update(myModel);
                }
            }
        };

        myShowInfoButtonListener = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                // do stuff
                // displayHelpWindow();
            }
        };

        myDuplicateWindowButtonListener = new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent e){
                String currentVisual = myGraphicsPanel.getVisual();
                SimulationDisplay.build();
                // TODO: Need implement open default window function 
            }
        };     


        /*
         * myExitButtonListener = new ActionListener() {
         * 
         * @Override
         * public void actionPerformed (ActionEvent e) {
         * System.exit(0);
         * }
         * };
         */
    };

    private void makeButtons () {
        // TODO Auto-generated method stub
        myRunButton = createButton("LOAD DATA");
        myRunButton.addActionListener(myPaintButtonListener);
        // createButton("EXIT").addActionListener(myExitButtonListener);
        myInfoButton = createButton("SHOWINFO");
        myInfoButton.addActionListener(myShowInfoButtonListener);
        myDuplicateWindowButton = createButton("DUPLICATE WINDOW");
        myDuplicateWindowButton.addActionListener(myDuplicateWindowButtonListener);
    }

    public JComponent arrangeButtons () {
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        result.add(myDuplicateWindowButton, BorderLayout.EAST);
        result.add(myRunButton, BorderLayout.CENTER);
        result.add(myInfoButton, BorderLayout.WEST);
        return result;
    }

    public static JButton createButton (String name) {
        JButton button = new JButton(name);
        return button;
    }

    public ActionListener getPaintButtonListener () {
        return myPaintButtonListener;
    }

    public ActionListener getShowInfoButtonListener () {
        return myShowInfoButtonListener;
    }

    public JButton getPaintButton () {
        return myRunButton;
    }

    public JButton getShowInfoButton () {
        return myInfoButton;
    }

    public JButton getDuplicateWindowButton(){
        return myDuplicateWindowButton;
    }

    public ActionListener getDuplicateWindowListener(){
        return myDuplicateWindowButtonListener;
    }

}
