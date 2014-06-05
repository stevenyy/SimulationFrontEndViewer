package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;


@SuppressWarnings("serial")
public class ButtonManager extends JComponent {
    private JButton paintResult;
    private JButton exitProgram;
    private JButton showInfo;
    private ActionListener myPaintButtonListener;
    private ActionListener myExitButtonListener;
    private ActionListener myShowInfoButtonListener;

    protected void initialize () {
        makeListeners();
        makeButtons();
    }
    
    private void makeListeners () {
        myPaintButtonListener = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                // do stuff

            }
        };

        myShowInfoButtonListener = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                // do stuff
                // displayHelpWindow();
            }
        };

        myExitButtonListener = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                System.exit(0);
            }
        };
    };

    private void makeButtons () {
        // TODO Auto-generated method stub
        createButton("PAINT").addActionListener(myPaintButtonListener);
        createButton("EXIT").addActionListener(myExitButtonListener);
        createButton("SHOWINFO").addActionListener(myShowInfoButtonListener);
    }



    public static JButton createButton (String name) {
        JButton button = new JButton(name);
        return button;
    }

}
