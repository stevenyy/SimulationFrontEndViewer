package frontend;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import backend.ReflectionException;

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
     * Check and see if same instance
     */
    private static boolean isInstance (Class<?> clss, Object instance)
    {
        final String TYPE = "TYPE";

        try
        {
            // handle primitives specially
            if (clss.isPrimitive())
            {
                Class<?> thePrimitive = (Class<?>)getFieldValue(instance, TYPE);
                if (! isAssignableFrom(clss, thePrimitive))
                {
                    // primitives are not exactly the same
                    return false;
                }
            }
            else if (! clss.isInstance(instance))
            {
                // not an instance of class or its sub-classes
                return false;
            }
            return true;
        }
        catch (Exception e)
        {
            // tried to compare primitive to non-primitive
            return false;
        }
    }
    
    /**
     * Given a target object with an instance variable with the given name,
     * get the value of the named variable on that object and return it.
     */
    public static Object getFieldValue (Object target, String name)
        throws ReflectionException
    {
        try
        {
            return target.getClass().getDeclaredField(name).get(target);
        }
        catch (Exception e)
        {
            throw new ReflectionException("No matching public instance variable for " + 
                                          target.getClass().getName());
        }
    }
    
    private static boolean isAssignableFrom (Class<?> formal, Class<?> arg)
    {
        return formal.isAssignableFrom(arg);
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
