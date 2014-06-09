package frontend;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
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
    
    /**
     * Use this method to create a screenshot of the JFrame object argFrame.
     *
     * Author(s):
     *   Dejan Lekic
     * License: 
     *   Public Domain
     *
     * @param argFrame JFrame you want to make screenshot of.
     */
    public static final void makeScreenshot(JFrame argFrame) {
        Rectangle rec = argFrame.getBounds();
        BufferedImage bufferedImage = new BufferedImage(rec.width, rec.height,
                BufferedImage.TYPE_INT_ARGB);
        argFrame.paint(bufferedImage.getGraphics());

        try {
            // Create temp file.
            File temp = File.createTempFile("screenshot", ".png");

            // Use the ImageIO API to write the bufferedImage to a temporary file
            ImageIO.write(bufferedImage, "png", temp);

            // Delete temp file when program exits.
            temp.deleteOnExit();
        } catch (IOException ioe) {
            Util.showError(ioe.toString());
        } // catch, should not reach here
    } 
}
