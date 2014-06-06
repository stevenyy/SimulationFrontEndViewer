package frontend;

import javax.swing.JTextArea;
import backend.Model;

/**
 * This is the panel that displays the information and status about the result drawn
 * */

@SuppressWarnings("serial")
public class InfoPanel extends JTextArea implements View{
    private static final int INFO_PANEL_SIZE = 30;
    private static final String DISPLAY_OFFSET = " ";

    private Model myModel;

    public InfoPanel (Model model) {
        // TODO Auto-generated constructor stub
        super(INFO_PANEL_SIZE, INFO_PANEL_SIZE);
        this.setFocusable(false);
        myModel = model;
        myModel.registerView(this);
    }

    @Override
    public void update (Model model) {
        // TODO Auto-generated method stub
        this.setText(DISPLAY_OFFSET);

    }

    @Override
    public void update (String s) {
        // TODO Auto-generated method stub
        showMessage(DISPLAY_OFFSET + s);
    }


    public void showMessage (String message) {
        this.append(message + "\n");
        this.setCaretPosition(this.getText().length());
    }

public void setModel (Model md) {
    // TODO Auto-generated method stub
    myModel = md;
}


}
