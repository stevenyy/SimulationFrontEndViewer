package frontend;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import backend.Model;


/**
 * Sudo GraphicPanel to be replaced with WebKit that shows GoogleMap using its API
 * @author siyangwang
 */

@SuppressWarnings("serial")
public class GraphicsPanel extends JPanel implements View {
    private BufferedImage myImage;
    private Model myModel;

    public GraphicsPanel (Model md) {
        myModel=md;
        myModel.registerView(this);
        simplePaint();
    }
    
    private void simplePaint(){
        try {
            myImage = ImageIO.read(new File("frontend/resources/SampleMap.png"));
        }
        catch (IOException ex) {
            // should not reach here
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.drawImage(myImage, 0, 0, null); // see javadoc for more info on the parameters
    }

    @Override
    public void update (Model model) {
        // TODO Auto-generated method stub
    }

    @Override
    public void update (String s) {
        // TODO Auto-generated method stub

    }

    public void setImageFile (String name) {
        // TODO Auto-generated method stub
        
    }

}
