package frontend;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import backend.Model;


// import jgame.JGPoint;
// import backend.Model;

public class SimulationDisplay {
    // create program specific components
    public static final String TITLE = "Simulation GUI";
    private static final int GRAPHICS_PANEL_SIZE_X = 700;
    private static final int GRAPHICS_PANEL_SIZE_Y = 500;

    // private List<Model> modelList= new ArrayList<Model>();
    public SimulationDisplay () {
        build();
    }

    public void build () {
        Model model = new Model();
        GraphicsPanel myGraphicsPanel = new GraphicsPanel(GRAPHICS_PANEL_SIZE_X, GRAPHICS_PANEL_SIZE_Y, model);
        FrontEndViewer display = new FrontEndViewer();
        display.setGraphicsPanel(myGraphicsPanel);
        display.setModel(model);
        display.makePanels();

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        jp.add(myGraphicsPanel, BorderLayout.CENTER);
//        VisualChooser vis = new ColorChooser(myGraphicsPanel);
//        WorkspacePanel wp = new WorkspacePanel(modelList, myGraphicsPanel, myCommandPanel, display);
//        jp.add(vis, BorderLayout.NORTH);
        jp.add(display.getButtonManager().arrangeButtons(), BorderLayout.SOUTH);
        
        // create container that will work with Window manager
        JFrame frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add our user interface components to Frame and show it
        frame.getContentPane().add(jp, BorderLayout.WEST);
        frame.getContentPane().add(display.makeAssistPanels(), BorderLayout.EAST);
//        frame.getContentPane().add(wp.getJPanel(), BorderLayout.SOUTH);
        frame.setJMenuBar(display.getMenuManager().makeMenu());

        frame.pack();
        frame.setVisible(true);
    }
}
