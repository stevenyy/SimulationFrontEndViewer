package frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

//import frontend.InfoPanel;
//import frontend.EchoPanel;
import backend.Model;
import frontend.ButtonManager;
/**
 * This is the front end model that packs multiple JComponents
 * together and add listeners to them.
 * */

@SuppressWarnings("serial")
public class FrontEndViewer extends JPanel{
        
        private static final String DISPLAY_OFFSET = " ";
        private static final int DEFAULT_PANEL_SIZE_X = 200;
        private static final int DEFAULT_PANEL_SIZE_Y = 300;
        
        private JButton myHelpButton;
        private JButton myRunButton;
        private LoadResultButton myLoadResultButton;
        private InfoPanel myInfoPanel;
        private EchoPanel myEchoPanel;
        private CommandPanel myCommandPanel;
        private ProceduresPanel myProceduresPanel;
        private VariablesPanel myVariablesPanel;
        private GraphicsPanel myGraphicsPanel;
        
        private ActionListener myEchoListener;
        private ActionListener myRunButtonListener;
        private ActionListener myHelpButtonListener;
        
        private Model myModel;
        private ButtonManager myButtonManager;
        private PanelManager myPanelManager;
        private MenuManager myMenuManager;
        
        public FrontEndViewer () {
                myButtonManager = new ButtonManager();
                myPanelManager = new PanelManager();
                myMenuManager = new MenuManager();
                
                makeListeners();
                makeRunButton();
                makeHelpButton();
                //makeImageButton();
        }
        
        
        protected void makePanels() {
                myInfoPanel = new InfoPanel(myModel);
                myEchoPanel = new EchoPanel(this);
                myProceduresPanel = new ProceduresPanel(this);
                myVariablesPanel = new VariablesPanel(myModel);
                //makeImageButton();
        }
        
        
        public void setCommandPanel(CommandPanel cp){
                myCommandPanel = cp;
        }
                
        public void setGraphicsPanel(GraphicsPanel graphicsPanel) {
                myGraphicsPanel = graphicsPanel;
                
        }

        public void setModel(Model md){
                myModel = md;
                if(myInfoPanel!=null)
                        myInfoPanel.setModel(md);
                if (myLoadImageButton!=null)
                myLoadImageButton.setMyModel(myModel);
        }

        protected void makeListeners () {
        
        myEchoListener = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                updateEchoPanel(); 
                updateProceduresPanel();
                updataVariablesPanel();
            }
        };
                  
        myRunButtonListener = new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                //do stuff
                startRunning();
            }
        };
        
        myHelpButtonListener = new ActionListener(){
                 public void actionPerformed (ActionEvent e) {
                //do stuff
                displayHelpWindow();
             }
        };
        }
        
        public void updateEchoPanel(){
                myEchoPanel.update(myCommandPanel.getText());
                myCommandPanel.update("");
        }
        
        public void updateCommandPanel(String s){
                myCommandPanel.update(s);
        }
        
        public void updateProceduresPanel(){
                for(String procedure : myModel.getProcedures()){
                        myProceduresPanel.update(procedure);
                } 
        }
        
        public void updataVariablesPanel(){
                myVariablesPanel.update(myModel);
        }
        
        public void displayHelpWindow(){
                Desktop desktop=Desktop.getDesktop();
                File helpFile= new File("src/frontend/help.html");
                try {
                        desktop.open(helpFile);
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

        }
        
        public void startRunning(){
                try {
                        myModel.run();
                } catch (ParsingException e1) {
                        showError("Parsing Error");
                } catch (ArgumentException e1) {
                        showError("Argument Error");
                }
        }

        private void showError (String message) {
                JOptionPane.showMessageDialog(this, message, 
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
        }

        protected JComponent makeAllPanelsAndButtons () {
                // create with size in rows and columns
                JPanel result = new JPanel();
                result.setLayout(new BorderLayout());
                result.add(makeAllPanelsAndButtonsLeft(), BorderLayout.WEST);
                result.add(makeAllPanelsAndButtonsRight(), BorderLayout.EAST);
                return result;
        }
        
        protected JComponent makeAllPanelsAndButtonsLeft () {
                JPanel result = new JPanel();
                result.setLayout(new BorderLayout());
                result.add(makeInfoPanel(), BorderLayout.NORTH);
                result.add(makeEchoPanel(), BorderLayout.SOUTH);                
                return result;
        }
        
        protected JComponent makeAllPanelsAndButtonsRight () {
                JPanel result = new JPanel();
                result.setLayout(new BorderLayout());
                result.add(makeUserDefinedPanel(), BorderLayout.NORTH);
                result.add(makeButtons(),BorderLayout.SOUTH);
                return result;
        }
        
        private JComponent makeButtons(){
                JPanel result= new JPanel();
                result.setLayout(new BorderLayout());           
                result.add(myRunButton,BorderLayout.SOUTH);
                result.add(myHelpButton, BorderLayout.CENTER);
                result.add(myLoadImageButton.getImageButton(), BorderLayout.NORTH);
                return result;
        }
        
        private JComponent makeInfoPanel(){
                JPanel result = new JPanel();
                result.setLayout(new BorderLayout());
                JScrollPane sp = new JScrollPane(myInfoPanel);
                sp.setPreferredSize(new Dimension(DEFAULT_PANEL_SIZE_X,DEFAULT_PANEL_SIZE_Y+100));
                result.add(new JLabel(DISPLAY_OFFSET + "Info Panel"),BorderLayout.CENTER);
                result.add(sp, BorderLayout.SOUTH);             
                return result;
        }
        
        private JComponent makeEchoPanel(){
                JPanel result = new JPanel();
                result.setLayout(new BorderLayout());
                JScrollPane sp = new JScrollPane(myEchoPanel);
                sp.setPreferredSize(new Dimension(DEFAULT_PANEL_SIZE_X,DEFAULT_PANEL_SIZE_Y));
                result.add(new JLabel(DISPLAY_OFFSET + "Input Commands"),BorderLayout.CENTER);
                result.add(sp,BorderLayout.SOUTH);
                return result;
        }
        
        private JComponent makeVariablesPanel(){
                JPanel result = new JPanel();
                result.setLayout(new BorderLayout());
                JScrollPane sp = new JScrollPane(myVariablesPanel);
                sp.setPreferredSize(new Dimension(DEFAULT_PANEL_SIZE_X,DEFAULT_PANEL_SIZE_Y));
                result.add(new JLabel(DISPLAY_OFFSET + "User Defined Variables"),BorderLayout.CENTER);
                result.add(sp,BorderLayout.SOUTH);
                return result;
        }
        
        private JComponent makeProceduresPanelPanel(){
                JPanel result = new JPanel();
                result.setLayout(new BorderLayout());
                JScrollPane sp = new JScrollPane(myProceduresPanel);
                sp.setPreferredSize(new Dimension(DEFAULT_PANEL_SIZE_X,DEFAULT_PANEL_SIZE_Y));
                result.add(new JLabel(DISPLAY_OFFSET + "User Defined Functions"),BorderLayout.CENTER);
                result.add(sp,BorderLayout.SOUTH);
                return result;
        }
        
        private JComponent makeUserDefinedPanel(){
                JPanel result = new JPanel();
                result.setLayout(new BorderLayout());
                result.add(new JLabel(DISPLAY_OFFSET + "User Definded Variables and Methods"),BorderLayout.NORTH);
                result.add(makeVariablesPanel(), BorderLayout.NORTH);   
                result.add(makeProceduresPanelPanel(), BorderLayout.SOUTH);             
                return result;
        }
        
                
        protected void makeRunButton () {
                myRunButton = new JButton("RUN");
                myRunButton.addActionListener(myEchoListener);
                myRunButton.addActionListener(myRunButtonListener);
        }
        
        protected void makeHelpButton(){
                myHelpButton=new JButton("HELP");
                myHelpButton.addActionListener(myHelpButtonListener);
        }

        public void makeImageButton() {
                LoadImageButton o = new LoadImageButton(myGraphicsPanel, myModel);      
                myLoadImageButton=o;
        }
        
        public JMenuBar makeMenus () {
        JMenuBar result = new JMenuBar();
        result.add(makeFileMenu());
        return result;
    }
        
        protected JMenu makeFileMenu () {
        JMenu result = new JMenu("Menu");
        result.add(new AbstractAction("Load Procedures") {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                   myModel.loadProceduresFromFile(DEFAULT_RESOURCE_PROCEDURE);
                   JOptionPane.showMessageDialog(null, "Load Procedures Done", "Done", JOptionPane.INFORMATION_MESSAGE);
                   updataVariablesPanel();
                   updateProceduresPanel();
                }
                catch (Exception io) {
                    showError(io.toString());
                }
            }
        });
        result.add(new AbstractAction("Load Variables") {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                        myModel.loadVariablesFromFile(DEFAULT_RESOURCE_VARIABLE_LOAD);
                        JOptionPane.showMessageDialog(null, "Load Variables Done", "Done", JOptionPane.INFORMATION_MESSAGE);
                        updataVariablesPanel();
                    updateProceduresPanel();
                }
                catch (Exception io) {
                    showError(io.toString());
                }
            }
        });
        result.add(new AbstractAction("Save Procedures") {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                        myModel.saveProceduresToFile(DEFAULT_RESOURCE_PROCEDURE);
                        JOptionPane.showMessageDialog(null, "Save Procedures Done", "Done", JOptionPane.INFORMATION_MESSAGE);
                        updataVariablesPanel();
                    updateProceduresPanel();
                }
                catch (Exception io) {
                    showError(io.toString());
                }
            }
        });
        result.add(new AbstractAction("Save Variables") {
            @Override
            public void actionPerformed (ActionEvent e) {
                try {
                        myModel.saveVariablesToFile(DEFAULT_RESOURCE_VARIABLE_SAVE);
                        JOptionPane.showMessageDialog(null, "Save Variables Done", "Done", JOptionPane.INFORMATION_MESSAGE);
                        updataVariablesPanel();
                    updateProceduresPanel();
                }
                catch (Exception io) {
                    showError(io.toString());
                }
            }
        });
        result.add(new JSeparator());
        result.add(new AbstractAction("Exit") {
            @Override
            public void actionPerformed (ActionEvent e) {             
                System.exit(0);
            }
        });
        return result;
    }
        
}
