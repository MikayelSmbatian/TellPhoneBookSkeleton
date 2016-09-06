package OutPutProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Family on 04.09.2016.
 */
public class OutputProperties extends Properties
{
    private static OutputProperties property = new OutputProperties();
    static public void printMessage(String KEY)
    {
        System.out.println(property.getProperty(KEY));
    }
    public OutputProperties()
    {
        super();
        FileInputStream fis;
        try
        {
            fis = new FileInputStream("OutPutPROPERTIES.txt");
            this.load(fis);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
