package frontend;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.logging.Logger;

//import jgame.JGPoint;
//
//import backend.Model;
//import frontend.FrontendViewer;

public class Main {
        // constants
        public static final String TITLE = "Simulation GUI";
        private static final int GRAPHICS_PANEL_SIZE_X = 800;
        private static final int GRAPHICS_PANEL_SIZE_Y = 600;
//        private static final Logger LOGGER = Logger.getLogger(MyClass.class.getName()); 

        /**
         * Start of the program.
         */
        public static void main (String[] args) {
                // create program specific components
//              FrontendViewer display = new FrontendViewer();
//              CommandPanel myCommandPanel = new CommandPanel(display);
//              final Model model= new Model(myCommandPanel);
//              GraphicsPanel myGraphicsPanel = new GraphicsPanel(new JGPoint(GRAPHICS_PANEL_SIZE_X,GRAPHICS_PANEL_SIZE_Y), model);
//              display.setCommandPanel(myCommandPanel);
//              display.setGraphicsPanel(myGraphicsPanel);
//              display.setModel(model);
//              display.makePanels();
//              model.makeTurtle();
//              JPanel jp = new JPanel();
//              jp.setLayout(new BorderLayout());
//              jp.add(myGraphicsPanel,BorderLayout.CENTER);
//              jp.add(myCommandPanel,BorderLayout.SOUTH);
//              ColorChooser col = new ColorChooser(myGraphicsPanel);
//              jp.add(col, BorderLayout.NORTH);
//              // create container that will work with Window manager
//              JFrame frame = new JFrame(TITLE);
//              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//              // add our user interface components to Frame and show it
//              frame.getContentPane().add(jp, BorderLayout.WEST);
//              frame.getContentPane().add(display.makeAllPanelsAndButtons (), BorderLayout.EAST);
//              frame.setJMenuBar(display.makeMenus());
//
//              frame.pack();
//              frame.setVisible(true);
                
                new SimulationDisplay();
        }

}