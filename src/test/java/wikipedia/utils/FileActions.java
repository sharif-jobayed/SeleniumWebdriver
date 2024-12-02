package wikipedia.utils;

import aquality.selenium.browser.AqualityServices;

import java.io.File;

public class FileActions {

    private static final String FILE_DOWNLOAD_LOCATION="./downloads/";
    private static final File DOWNLOADED_FILE=new File(FILE_DOWNLOAD_LOCATION+DataProcessor.processedData().getFileName());




    public static File getDOWNLOADED_FILE(){return DOWNLOADED_FILE;}
    public static boolean doesFileExists(File file){
        try{
            DriverTools.getiConWait().waitFor(() -> file.exists());
        }catch(Exception err){
            AqualityServices.getLogger().error(err.getMessage());
            return false;
        }
        return true;
    }
    public static void deleteFile(Boolean condition){
        if(condition){
            DOWNLOADED_FILE.delete();
        }
    }

}
