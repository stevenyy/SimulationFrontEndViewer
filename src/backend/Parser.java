package backend;


/**
 * CURRENTLY NOT USED
 * @author siyangwang
 *
 */
public class Parser implements CSVEntryParser<BaseStation> {

    public BaseStation parseEntry (String ... data) {
        // TODO Auto-generated method stub
        if (data.length < 2) { throw new IllegalArgumentException(
                                                                  "this is not a valid data file with basic X Y "
                                                                          +
                                                                          "coordinate of the BaseStation"); }
        if (data.length > 3) {
            // 1. find JavaDoc for this component
            // 2. Should control which parser to use in the Model
            // 3. Think about the relationship of each files
        }

        try {
            String[] split = data.toString().split(",");
            System.out.println("printing data is :" + data.toString());
            Double x = Double.parseDouble(split[0]);
            System.out.println("printing data at x is : " + x);
            
            Double y = Double.parseDouble(split[1]);
            System.out.println("printing data at y is : " + y);
            return new BaseStation(x, y);
        }
        catch (NumberFormatException e) {
            System.err
                    .println("Caught NumberFormatException at parseEntry Method in Parser.java" +
                             e.getMessage());
        }
        return null;
    }
}
