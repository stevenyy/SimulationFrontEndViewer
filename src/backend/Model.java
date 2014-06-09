package backend;

import java.util.ArrayList;
import java.util.List;
import com.google.apphosting.api.ApiProxy.ArgumentException;
import frontend.View;
import sun.security.pkcs.ParsingException;

public class Model {
    public static final String PREFERENCES_FILEPATH = "backend.resources.Preferences";
    
    private List<View> views = new ArrayList<View>();
    
    // One model corresponds to one JFrame
    // model itself keeps track of which visualization method is currently used

    public void loadProceduresFromFile (String defaultResourceDataLoad) {
        // TODO Auto-generated method stub
        
    }

    public void saveProceduresToFile (String defaultResourceResultSave) {
        // TODO Auto-generated method stub
        
    }

    public void run () throws ParsingException, ArgumentException{
        // TODO Auto-generated method stub
        // Where Data Visualization Take Place
        
    }

    public void registerView (View view) {
        // TODO Auto-generated method stub
        views.add(view);
    }

}
