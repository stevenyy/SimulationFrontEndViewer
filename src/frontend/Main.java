package frontend;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.logging.Logger;



public class Main {
        // constants
        public static final String TITLE = "Simulation GUI";
        private static final int GRAPHICS_PANEL_SIZE_X = 600;
        private static final int GRAPHICS_PANEL_SIZE_Y = 400;
//        private static final Logger LOGGER = Logger.getLogger(MyClass.class.getName()); 

        /**
         * Start of the program.
         */
        public static void main (String[] args) {
                
                new SimulationDisplay();
                
        }

}