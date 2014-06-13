package backend;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import frontend.View;
import sun.security.pkcs.ParsingException;

public class Model {
    public static final String PREFERENCES_FILEPATH = "backend.resources.Preferences";
    
    private List<View> views = new ArrayList<View>();
    private List<BaseStation> BSList = new ArrayList<BaseStation>();
    
    // One model corresponds to one JFrame
    // model itself keeps track of which visualization method is currently used
    
    public void loadData(){
        try {
            BSList = ParserControl.parseCSV();
            //                    myGraphicsPanel.setImageFile(file.getName());
            // TODO: Model delegate the drawing task to other thing, and the other thing has access to myGraphicsPanel
//            myGraphicsPanel.update(this);
        }
        catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public void loadProceduresFromFile (String defaultResourceDataLoad) {
        // TODO Auto-generated method stub
        
    }

    public void saveProceduresToFile (String defaultResourceResultSave) {
        // TODO Auto-generated method stub
        
    }

    public void run () throws ParsingException{
        // TODO Auto-generated method stub
        // Where Data Visualization Take Place
        
    }

    public void registerView (View view) {
        // TODO Auto-generated method stub
        views.add(view);
    }
    
    public List<BaseStation> getBSList(){
        return BSList;
    }

}
