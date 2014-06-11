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
    private JButton myDrawButton;
    private JButton myLoadButton;
    private JButton myDuplicateWindowButton;
    private GraphicsPanel myGraphicsPanel;
    private Model myModel;
    private ActionListener myPaintButtonListener;
    // private ActionListener myExitButtonListener;
    private ActionListener myDrawButtonListener;
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

        myDrawButtonListener = new ActionListener() {
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
        myLoadButton = createButton("LOAD DATA");
        myLoadButton.addActionListener(myPaintButtonListener);
        // createButton("EXIT").addActionListener(myExitButtonListener);
        myDrawButton = createButton("DRAW");
        myDrawButton.addActionListener(myDrawButtonListener);
        myDuplicateWindowButton = createButton("DUPLICATE WINDOW");
        myDuplicateWindowButton.addActionListener(myDuplicateWindowButtonListener);
    }

    public JComponent arrangeButtons () {
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        result.add(myLoadButton, BorderLayout.WEST);
        result.add(myDrawButton, BorderLayout.CENTER);
        result.add(myDuplicateWindowButton, BorderLayout.EAST);
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
        return myDrawButtonListener;
    }

    public JButton getPaintButton () {
        return myLoadButton;
    }

    public JButton getShowInfoButton () {
        return myDrawButton;
    }

    public JButton getDuplicateWindowButton(){
        return myDuplicateWindowButton;
    }

    public ActionListener getDuplicateWindowListener(){
        return myDuplicateWindowButtonListener;
    }

}
