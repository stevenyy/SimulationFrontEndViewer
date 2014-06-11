package backend;

import java.util.*;

public class BaseStation {
    private double xPos;
    private double yPos;
    private Map<String, Double> myTrafficMap = new HashMap<String, Double>();
    
    protected BaseStation(){
        
    }
    
    public void setPosition(double x, double y){
        xPos = x;
        yPos = y;
    }    
   
}
