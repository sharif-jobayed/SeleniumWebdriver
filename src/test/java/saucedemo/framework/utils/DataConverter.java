package saucedemo.framework.utils;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataConverter {
    private final Gson GSON;
    private final File APP_DATA;
    private final File USER_CREDS;

    public DataConverter() {
        this.GSON = new Gson();
        this.APP_DATA = new File("./src/test/java/saucedemo/data/appData.json");
        this.USER_CREDS = new File("./src/test/java/saucedemo/data/userCreds.json");
    }

    public ConvertedData.AppData getAppData() {
        try(FileReader reader = new FileReader(this.APP_DATA)) {
            return this.GSON.fromJson(reader, ConvertedData.AppData.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ConvertedData.UserCreds getUserCreds() {
        try(FileReader reader = new FileReader(this.USER_CREDS)) {
            return this.GSON.fromJson(reader, ConvertedData.UserCreds.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
