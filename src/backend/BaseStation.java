package backend;

import java.util.*;

public class BaseStation {
    private double xPos;
    private double yPos;
    private List<Double> myTrafficList = new ArrayList<Double>();
    private Map<String, Double> myTrafficMap = new HashMap<String, Double>();
    
    protected BaseStation(){
        
    }
    protected BaseStation(double x, double y){
        xPos = x;
        yPos = y;
    }
    
    public void setPosition(double x, double y){
        xPos = x;
        yPos = y;
    }    
    
    public void setTraffic(List<Double> convertedLine){
        myTrafficList = convertedLine;
    }
    
    public String getCoordinates(){
        return String.format("x: %s ; y: %s ", xPos, yPos);
    }

}
