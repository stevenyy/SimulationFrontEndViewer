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

//import jgame.JGPoint;
//import backend.Model;

public class SimulationDisplay {
        // create program specific components
        public static final String TITLE = "Simulation GUI";
        private static final int GRAPHICS_PANEL_SIZE_X = 800;
        private static final int GRAPHICS_PANEL_SIZE_Y = 600;
//        private List<Model> modelList= new ArrayList<Model>();
        public SimulationDisplay(){
                build();
        }
          
        
        public void build(){
                FrontEndViewer display = new FrontEndViewer();
//                CommandPanel myCommandPanel = new CommandPanel(display);
                Model model= new Model();
                GraphicsPanel myGraphicsPanel = new GraphicsPanel(new JGPoint(GRAPHICS_PANEL_SIZE_X,GRAPHICS_PANEL_SIZE_Y), model);
                display.setCommandPanel(myCommandPanel);
                display.setGraphicsPanel(myGraphicsPanel);
                display.setModel(model);
                display.makePanels();
                
                model.makeTurtle();
                display.makeImageButton();
                JPanel jp = new JPanel();
                jp.setLayout(new BorderLayout());
                jp.add(myGraphicsPanel,BorderLayout.CENTER);
                jp.add(myCommandPanel,BorderLayout.SOUTH);
                ColorChooser col = new ColorChooser(myGraphicsPanel);
                WorkspacePanel wp = new WorkspacePanel(modelList, myGraphicsPanel, myCommandPanel, display);
                jp.add(col, BorderLayout.NORTH);
                // create container that will work with Window manager
                JFrame frame = new JFrame(TITLE);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // add our user interface components to Frame and show it
                frame.getContentPane().add(jp, BorderLayout.WEST);
                frame.getContentPane().add(display.makeAllPanelsAndButtons (), BorderLayout.EAST);
                frame.getContentPane().add(wp.getJPanel(), BorderLayout.SOUTH);
                frame.setJMenuBar(display.makeMenus());

                frame.pack();
                frame.setVisible(true);
        }
}