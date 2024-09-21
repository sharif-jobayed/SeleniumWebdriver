package wikipedia.utils;

import aquality.selenium.browser.AqualityServices;
import com.google.gson.Gson;
import java.io.FileReader;

public class DataProcessor {

    private static final Gson GSON=new Gson();
    private static final String PRE_TEST_DATA="./src/test/java/wikipedia/data/preTestData.json";




    public static ProcessedData processedData(){
        try{
            return GSON.fromJson(new FileReader(PRE_TEST_DATA),ProcessedData.class);
        }catch(Exception err){
            AqualityServices.getLogger().error(err.getMessage());
            throw new RuntimeException(err.getMessage());
        }
    }

}
