package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import backend.Model;


@SuppressWarnings("serial")
public class ButtonManager extends JComponent {
    private JButton paintResult;
//    private JButton exitProgram;
    private JButton showInfo;
    private JButton loadAndPaint;
    private FrontEndViewer myFrontEndViwer;
    private GraphicsPanel myGraphicsPanel;
    private Model myModel;
    private ActionListener myPaintButtonListener;
//    private ActionListener myExitButtonListener;
    private ActionListener myShowInfoButtonListener;

    protected ButtonManager(FrontEndViewer v, GraphicsPanel gp, Model m) {
        myFrontEndViwer = v;
        myGraphicsPanel = gp;
        myModel = m;
        makeListeners();
        makeButtons();
    }
    
    private JFileChooser makeFileChooser(){
        final JFileChooser fc = new JFileChooser();
        File currentDirectory = null;
        try {
                currentDirectory = new File(new File("").getCanonicalPath());
        } catch (IOException e1) {
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

/*        myExitButtonListener = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        };*/
    };

    private void makeButtons () {
        // TODO Auto-generated method stub
        loadAndPaint = createButton("LOAD DATA");
        loadAndPaint.addActionListener(myPaintButtonListener);
//        createButton("EXIT").addActionListener(myExitButtonListener);
        showInfo = createButton("SHOWINFO");
        showInfo.addActionListener(myShowInfoButtonListener);
    }

    public static JButton createButton (String name) {
        JButton button = new JButton(name);
        return button;
    }
    
    public ActionListener getPaintButtonListener(){
        return myPaintButtonListener;
    }
    
    public ActionListener getShowInfoButtonListener(){
        return myShowInfoButtonListener;
    }
    
    public JButton getPaintButton(){
        return loadAndPaint;
    }
    
    public JButton getShowInfoButton(){
        return showInfo;
    }

    public void setMyModel(Model m){
        myModel=m;
}
}
