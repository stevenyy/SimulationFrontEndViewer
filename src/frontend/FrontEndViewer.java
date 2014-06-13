package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.security.pkcs.ParsingException;
// import frontend.InfoPanel;
// import frontend.EchoPanel;
import backend.Model;
import frontend.ButtonManager;


/**
 * This is the front end model that packs multiple Managers (JComponents)
 * and Panels together and arrange organize them together to make GUI
 * @author siyangwang
 * */
@SuppressWarnings("serial")
public class FrontEndViewer extends JPanel {

    private static final String DISPLAY_OFFSET = " ";
    private static final int DEFAULT_PANEL_SIZE_X = 200;
    private static final int DEFAULT_PANEL_SIZE_Y = 500;

    private JButton myRunButton;
    private GraphicsPanel myGraphicsPanel;
    private WindowPanel myWindowPanel;

    private Model myModel;
    private ButtonManager myButtonManager;
    private MenuManager myMenuManager;
    private InfoPanel myInfoPanel;
    private SliderManager mySliderManager;

    //TODO: need to fix problem in ButtonManager's initialization 
    public FrontEndViewer () {
        myButtonManager = new ButtonManager();
        myMenuManager = new MenuManager();
        mySliderManager = new SliderManager();
    }

    protected void makePanels () {
        myWindowPanel = new WindowPanel(this);
        myInfoPanel = new InfoPanel(myModel);
        // makeImageButton();
    }

    public void setGraphicsPanel (GraphicsPanel graphicsPanel) {
        myGraphicsPanel = graphicsPanel;
        myButtonManager.setGraphPanel(graphicsPanel);
        mySliderManager.setGraphPanel(graphicsPanel);
    }

    public void setInfoPanel (InfoPanel infoPanel) {
        myInfoPanel = infoPanel;
    }
    
    public void setModel (Model md) {
        myModel = md;
        if (myInfoPanel != null)
            myInfoPanel.setModel(myModel);
        myButtonManager.setModel(myModel);
        mySliderManager.setModel(myModel);
    }
//TODO Finish the update part of all panels
    public void updateProceduresPanel () {
        for (String procedure : myModel.getProcedures()) {
            myProceduresPanel.update(procedure);
        }
    }

    public void updataVariablesPanel () {
        myVariablesPanel.update(myModel);
    }
    
    public void updateWindowPanel(){
        myWindowPanel.update("");
    }

    public void displayHelpWindow () {
        Desktop desktop = Desktop.getDesktop();
        File helpFile = new File("src/frontend.resources/help.html");
        try {
            desktop.open(helpFile);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void startRunning () {
        try {
            myModel.run();
        }
        catch (ParsingException e1) {
            Util.showError("Parsing Error");
        }
        catch (ArgumentException e1) {
            Util.showError("Argument Error");
        }
    }

    protected JComponent makeAssistPanels() {
        // create with size in rows and columns
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        result.add(makeInfoPanel(), BorderLayout.WEST);
        result.add(makeWindowPanel(), BorderLayout.EAST);
        return result;
    }

    private JComponent makeInfoPanel () {
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        JScrollPane sp = new JScrollPane(myInfoPanel);
        sp.setPreferredSize(new Dimension(DEFAULT_PANEL_SIZE_X, DEFAULT_PANEL_SIZE_Y + 100));
        result.add(new JLabel(DISPLAY_OFFSET + "Info Panel"), BorderLayout.NORTH);
        result.add(sp, BorderLayout.SOUTH);
        return result;
    }

    private JComponent makeWindowPanel () {
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        JScrollPane sp = new JScrollPane(myWindowPanel);
        sp.setPreferredSize(new Dimension(DEFAULT_PANEL_SIZE_X - 80, DEFAULT_PANEL_SIZE_Y));
        result.add(new JLabel(DISPLAY_OFFSET + "Opened Windows"), BorderLayout.NORTH);
        result.add(sp, BorderLayout.SOUTH);
        return result;
    }
    
    public JPanel makeButtonAndSlider(){
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        result.add(mySliderManager.arrangeSliders(), BorderLayout.NORTH);
        result.add(myButtonManager.arrangeButtons(), BorderLayout.SOUTH);
        return result;
    }
    
    public ButtonManager getButtonManager(){
        return myButtonManager;
    }
    
    public MenuManager getMenuManager(){
        return myMenuManager;
    }
}
