package frontend;

import javax.swing.JOptionPane;

/**
 * Util class with some universal method intended for direct and easier access
 * @author siyangwang
 */
public class Util {
    
    /**
     * ShowError message for better error handling
     */
    public static void showError (String message) {
        JOptionPane.showMessageDialog(null, message, 
                                      "Error",
                                      JOptionPane.ERROR_MESSAGE);
    }
}
