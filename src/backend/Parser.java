package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import javax.swing.JFileChooser;
import com.googlecode.jcsv.reader.CSVEntryParser;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;

public class Parser implements CSVEntryParser<BaseStation>{

    public static void parseCSV() throws FileNotFoundException{

        JFileChooser fc = makeFileChooser();
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            Reader reader = new FileReader(file);

            CSVReader<String[]> csvParser = CSVReaderBuilder.newDefaultReader(reader);
            try {
                List<String[]> data = csvParser.readAll();

                System.out.println("the data read from the java file instream is following : ");
                System.out.println(data);
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
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
    
    @Override
    public BaseStation parseEntry (String ... arg0) {
        // TODO Auto-generated method stub
        return null;
    }
}
