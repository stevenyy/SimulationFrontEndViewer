package frontend;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import backend.Model;
/**
 * WindowPanel that shows what windows are open
 * @author siyangwang
 */
public class WindowPanel extends JList implements View{
    public static final List<String> windowList = new ArrayList<String>();
    

    public WindowPanel (FrontEndViewer frontEndViewer) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void update (Model model) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update (String s) {
        // TODO Auto-generated method stub
        
    }

}
