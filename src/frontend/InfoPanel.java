package frontend;

import javax.swing.JTextArea;
import backend.BaseStation;
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
        super(INFO_PANEL_SIZE, INFO_PANEL_SIZE);
        this.setFocusable(false);
        myModel = model;
        myModel.registerView(this);
    }

    @Override
    public void update (Model model) {
        this.setText(DISPLAY_OFFSET);
        update("HIGHLIGHTS: ");
        update(model.getAnalysis()); // TODO: returns highlights of the data
        update("COORDINATES: ");
        int BSCounter = 0;
        for (BaseStation bs: model.getBSList()){
            BSCounter++;
            update("BS"+ BSCounter + " : " + bs.getCoordinates());
            
        }
    }

    @Override
    public void update (String s) {
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
