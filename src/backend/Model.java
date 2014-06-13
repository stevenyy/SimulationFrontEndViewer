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
    private String myVisual = "GoogleMap";

    public void loadData(){
        try {
            BSList = ParserControl.parseCSV();
            //                    myGraphicsPanel.setImageFile(file.getName());
            // TODO: Model delegate the drawing task to other thing, and the other thing has access to myGraphicsPanel
            //            myGraphicsPanel.update(this);
            analyzeData();
            updateViews();
        }
        catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
    /**
     * Analyzes the data during the single LOAD DATA session
     */
    private void analyzeData () {
        // TODO: Analyze the data and print information on the infoPanel
    }

    /**
     * Update all registered views
     */
    private void updateViews(){
        for (View v : views)
            v.update(this);
    }

    /**
     * Register a view
     * This is optional for any views using this Model's data.
     * All registered views will be updated on every run() of this Model.
     * @param v View to be registered
     */
    public void registerView (View v) {
        // TODO Auto-generated method stub
        if(!views.contains(v))
            views.add(v);
    }

    public void loadProceduresFromFile (String defaultResourceDataLoad) {
        // TODO Auto-generated method stub

    }

    public void saveProceduresToFile (String defaultResourceResultSave) {

    }

    public void run () throws ParsingException{
        // Where Data Visualization Take Place

    }

    public List<BaseStation> getBSList(){
        return BSList;
    }

    public String getAnalysis () {
        return null;

    }
    public void setVisual (String visualName) {
        myVisual = visualName;
    }

}
