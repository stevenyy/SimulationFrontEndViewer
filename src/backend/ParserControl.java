package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.swing.JFileChooser;
import au.com.bytecode.opencsv.CSVReader;
import backend.BaseStation;


public class ParserControl{

    public static List<BaseStation> parseCSV() throws FileNotFoundException{
        List<BaseStation> BSList = new ArrayList<BaseStation>();

        JFileChooser fc = makeFileChooser();
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            try {
                @SuppressWarnings("resource")
                CSVReader reader = new CSVReader(new InputStreamReader(fis, "UTF-8"));
                // nextLine[] is an array of values from the line
                String [] nextLine;
                List<Double> convertedLine = new ArrayList<Double>();
                int counter = 0;
                while ((nextLine = reader.readNext()) != null) {
                    for (int i = 0; i<nextLine.length; i++){
                        convertedLine.add(Double.parseDouble(nextLine[i]));
                    }
                    if (nextLine.length == 2){
                        Double x = convertedLine.get(0);
                        Double y = convertedLine.get(1);
                        BSList.add(new BaseStation(x, y));
                        System.out.println(nextLine[0] + " and then " + nextLine[1] + "etc...");
                        //                    for (BaseStation bs: BSList){
                        //                        System.out.println(bs.toString());
                        //                    }
                    }
                    if (nextLine.length > 2){
                        if(BSList.isEmpty()){
                            //TODO: jump out a conversation dialog that notifies first to load coordinate file                            
                        }
                        else{
                            BSList.get(counter).setTraffic(convertedLine);
                        }
                    }
                    counter++;
                }
            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return BSList;
    }

    private static JFileChooser makeFileChooser () {
        final JFileChooser fc = new JFileChooser();
        File currentDirectory = null;
        try {
            currentDirectory = new File(new File("").getCanonicalPath());
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
        fc.setCurrentDirectory(currentDirectory);
        return fc;
    }

    @SuppressWarnings("unused")
    private static Double[] convertAllDouble (List<String[]> readAll) {
        // TODO: convert all String arrays to Double Arrays to facilitate faster BSList construction

        return null;
    }
}
