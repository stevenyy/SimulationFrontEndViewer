package frontend;

import javax.swing.JComponent;
import javax.swing.JPanel;
import frontend.*;

/**
 * CURRENTLY NOT USED
 * @author siyangwang
 *
 */
@SuppressWarnings("serial")
public class PanelManager extends JComponent{

    private JPanel myGraphicsPanel;
    
    public PanelManager(){
        myGraphicsPanel = new GraphicsPanel();
    }
    
    public static JPanel createPanel(){
        JPanel panel = new JPanel();
        return panel;
    }
}
