package backend;

import com.googlecode.jcsv.reader.CSVEntryParser;

public class Parser implements CSVEntryParser<BaseStation> {

    @Override
    public BaseStation parseEntry (String ... data) {
        // TODO Auto-generated method stub
        if (data.length < 2){
            throw new IllegalArgumentException("this is not a valid data file with basic X Y " +
                    "coordinate of the BaseStation");
        }
        if (data.length > 3){
            //1. find JavaDoc for this component
            //2. Should control which parser to use in the Model
            //3. Think about the relationship of each files
        }
        Double x = Double.parseDouble(data[0]);
        Double y = Double.parseDouble(data[1]);

        return new BaseStation(x, y);
    }
}
