package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
    private String currentVisual;
    private Map<String, Object> visualMap = new HashMap<String, Object>();
    private String initPic = "BigMapResize.bmp";
    private JLabel myLabel;

    public GraphicsPanel (int SizeX, int SizeY, Model md) {
        myModel=md;
        myModel.registerView(this);
        this.setPreferredSize(new Dimension(SizeX, SizeY));
        simplePaint();
        initializeMap();
    }
    
    private void initializeMap () {
        visualMap.put("BigGoogleMap", "BigMapResize.bmp");
        visualMap.put("SmallGoogleMap", "SmallMapResize.bmp");
        visualMap.put("HeatMap", null); // TODO: instead of null, call new JHeatMap etc...
        visualMap.put("Piechart", null);
        visualMap.put("Histogram", null);
    }

    private void simplePaint(){
        try {
            myImage = ImageIO.read(new File("src/frontend/resources/BigMapResize.bmp"));
            myLabel = new JLabel(new ImageIcon(myImage));
            this.add(myLabel, BorderLayout.CENTER);
//            this.add(picLabel);
            this.repaint();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void simplePaint(Object name){
        try {
//            this.repaint();
//            System.out.println("@GraphicsPanel the name is :" + name);
            this.remove(myLabel);
            this.setLayout(new BorderLayout());
            myImage = ImageIO.read(new File("src/frontend/resources/" + (String) name));
            myLabel = new JLabel(new ImageIcon(myImage));
            this.add(myLabel, BorderLayout.CENTER);
            this.repaint();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

/*    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.drawImage(myImage, 0, 0, null); // see javadoc for more info on the parameters
    }*/

    @Override
    public void update (Model model) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update (String s) {
        // TODO Auto-generated method stub
        currentVisual = s;
        simplePaint(visualMap.get(currentVisual));
    }

    public void setImageFile (String name) {
        // TODO Auto-generated method stub
        
    }
    
    public Model getModel(){
        return myModel;
    }
    
    public String getVisual(){
        return currentVisual;
    }

}
