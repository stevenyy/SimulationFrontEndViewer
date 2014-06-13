package frontend;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import backend.Model;
/**
 * WindowPanel that shows what windows are open
 * @author siyangwang
 */
public class WindowPanel extends JList implements View{
    public static final List<Model> windowList = new ArrayList<Model>();
    public static final DefaultListModel<String> listModel = new DefaultListModel<String>();
    private FrontEndViewer myViewer;
    private JList myList = this;

    public WindowPanel (FrontEndViewer frontEndViewer) {
        super();
        this.setModel(listModel);
        myViewer = frontEndViewer;
        addListeners();
    }

    protected void addListeners () {
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && listModel.size()!= 0) {
                    int index = myList.locationToIndex(e.getPoint());
                    String item = listModel.get(index);
//              TODO: Bring front the specific window
//                    myViewer.updateCommandPanel(item + popForParameter());
//                    myViewer.startRunning();
                }
            }
        };
        this.addMouseListener(mouseListener);
    }

    @Override
    public void update (Model model) {
        // Do Nothing      
    }

    @Override
    public void update (String s) {
        showMessage(s);
    }

    public void showMessage (String message) {
        listModel.addElement(message);
    }


}
