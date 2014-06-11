package frontend;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.event.*;
import backend.Model;


public class SliderManager extends JPanel {
    public static final int SLIDER_MIN = 0;
    public static final int SLIDER_MAX = 24;
    public static final int SLIDER_INIT = 24; // initial range
    public static final int SLIDER_START = 0;
    private ChangeListener myHourSliderListener;
    private Model myModel;
    private GraphicsPanel myGraphicsPanel;
    private JSlider myHourSlider;

    public SliderManager () {
        makeListeners();
        makeSlider();
    }

    private void makeListeners () {
        myHourSliderListener = new ChangeListener() {
            @Override
            public void stateChanged (ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int timeUntil = (int) source.getValue();
                    if (timeUntil == 0) {
                        // show no graph at the GraphicsPanel
                    }
                    else {
                        System.out.println("@SliderManager printed : " + timeUntil + " is the current selected time");
                        // show graph between SLIDER_START to timeUntil
                        // call update graphicWindow method 
                    }
                }
            }
        };
        //Follow the same format to create more listener to add to the future slider bars
    }

    /**
     * create a working slider, and add change listener to it
     */
    private void makeSlider () {
        createHourSlider();
    }

    /**
     * create a hourslider for hour selection in the plot
     */
    private JComponent createHourSlider () {
        // Create a single JLabel-Slider Pair (with listener).
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        myHourSlider = new JSlider(JSlider.HORIZONTAL,
                                           SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
        // Create the label.
        JLabel sliderLabel = new JLabel("Visualization Time Range", JLabel.CENTER);
        sliderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Turn on labels at major tick marks.
        myHourSlider.setMajorTickSpacing(4);
        myHourSlider.setMinorTickSpacing(1);
        myHourSlider.setPaintTicks(true);
        myHourSlider.setPaintLabels(true);
        myHourSlider.setBorder(
                                BorderFactory.createEmptyBorder(0, 0, 0, 0));
        Font font = new Font("Serif", Font.ITALIC, 12);
        myHourSlider.setFont(font);
        
        // Add the changeListener to the HourSlider just created above
        myHourSlider.addChangeListener(myHourSliderListener);
        result.add(sliderLabel, BorderLayout.NORTH);
        result.add(myHourSlider, BorderLayout.SOUTH);
        return result;
    }
    
    public JComponent arrangeSliders(){
        JPanel result = new JPanel();
        result.setLayout(new BorderLayout());
        result.add(createHourSlider());
        return result;
    }

    public void setGraphPanel (GraphicsPanel graphicsPanel) {
        // TODO Auto-generated method stub
        myGraphicsPanel = graphicsPanel;
    }

    public void setModel (Model model) {
        myModel = model;
    }
}
