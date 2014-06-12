package backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
import javax.swing.JFileChooser;
import com.googlecode.jcsv.reader.CSVEntryParser;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import frontend.Main;

public class ParserControl{

    public static void parseCSV() throws FileNotFoundException{

        JFileChooser fc = makeFileChooser();
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String name = fc.getSelectedFile().getPath();
//            Reader reader = new FileReader(file);
            Reader reader = new InputStreamReader(Main.class.getResourceAsStream(name));
            CSVReader<BaseStation> csvParser = new CSVReaderBuilder<BaseStation>(reader).entryParser(new Parser()).build();
            try {
                
                List<BaseStation> data = csvParser.readAll();
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

}
