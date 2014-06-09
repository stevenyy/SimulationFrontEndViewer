package frontend;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import frontend.Util;
import backend.*;
import frontend.FrontEndViewer;

@SuppressWarnings("serial")
public class MenuManager extends JComponent {

    private static final String DISPLAY_OFFSET = " ";
    private static final int DEFAULT_PANEL_SIZE_X = 200;
    private static final int DEFAULT_PANEL_SIZE_Y = 300;
    private static final String DEFAULT_RESOURCE_DATA_LOAD = "backend.resources.SavedData";
    private static final String DEFAULT_RESOURCE_RESULT_SAVE = "src/backend/resources";
    private static final String DEFAULT_RESOURCE_DATA = "src/backend/resources/SavedData.ser";
    private Model myModel;
    private FrontEndViewer myFrontViewer;
    
    public MenuManager () {
//        makeMenu();
    }
    
    public void setModel(Model md){
        myModel = md;
    }
    
    public void setFrontViewer(FrontEndViewer viewer){
        myFrontViewer = viewer;
    }

    public JMenuBar makeMenu () {
        JMenuBar result = new JMenuBar();
        result.add(makeFileSubMenu());
        return result;
    }

    private JMenu makeFileSubMenu () {

        JMenu result = new JMenu("Menu");
        result.add(new AbstractAction("Load Experiment Data") {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    myModel.loadProceduresFromFile(DEFAULT_RESOURCE_DATA_LOAD);
                    JOptionPane.showMessageDialog(null, "Load Procedures Done", "Done",
                                                  JOptionPane.INFORMATION_MESSAGE);
                    myFrontViewer.updataVariablesPanel();
                    myFrontViewer.updateProceduresPanel();
                }
                catch (Exception io) {
                    Util.showError(io.toString());
                }
            }
        });
/*        result.add(new AbstractAction("Load Variables") {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    myModel.loadVariablesFromFile(DEFAULT_RESOURCE_DATA_LOAD);
                    JOptionPane.showMessageDialog(null, "Load Variables Done", "Done",
                                                  JOptionPane.INFORMATION_MESSAGE);
                    myFrontViewer.updataVariablesPanel();
                    myFrontViewer.updateProceduresPanel();
                }
                catch (Exception io) {
                    Util.showError(io.toString());
                }
            }
        });*/
        result.add(new AbstractAction("Visualize in Google Map") {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    myModel.saveProceduresToFile(DEFAULT_RESOURCE_RESULT_SAVE);
                    JOptionPane.showMessageDialog(null, "Save Procedures Done", "Done",
                                                  JOptionPane.INFORMATION_MESSAGE);
                    myFrontViewer.updataVariablesPanel();
                    myFrontViewer.updateProceduresPanel();
                }
                catch (Exception io) {
                    Util.showError(io.toString());
                }
            }
        });
        result.add(new AbstractAction("Save Graph Drawn") {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                    Util.makeScreenshot((JFrame)SwingUtilities.getRoot(myFrontViewer));
/*                    Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                    BufferedImage capture = new Robot().createScreenCapture(screenRect);
                    ImageIO.write(capture, "png", new File("SavedGraph"));*/
                    
/*                    myModel.saveProceduresToFile(DEFAULT_RESOURCE_RESULT_SAVE);
                    JOptionPane.showMessageDialog(null, "Save Procedures Done", "Done",
                                                  JOptionPane.INFORMATION_MESSAGE);
                    myFrontViewer.updataVariablesPanel();
                    myFrontViewer.updateProceduresPanel();*/
                }
                catch (Exception io) {
                    Util.showError(io.toString());
                }
            }
        });
        result.add(new JSeparator());
        result.add(new AbstractAction("Exit") {
            @Override
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        });
        return result;
    }

}
