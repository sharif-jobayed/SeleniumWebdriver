package saucedemo.framework.utils;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataConverter {
    private final Gson GSON;
    private final File APP_DATA;
    private final File USER_CREDS;
    private final File TIMEOUTS;

    public DataConverter() {
        this.GSON = new Gson();
        this.APP_DATA = new File("./src/test/java/saucedemo/data/appData.json");
        this.USER_CREDS = new File("./src/test/java/saucedemo/data/userCreds.json");
        this.TIMEOUTS = new File("./src/test/java/saucedemo/data/timeOuts.json");
    }

    public ConvertedData.AppData getAppData() {
        try (FileReader reader = new FileReader(this.APP_DATA)) {
            return this.GSON.fromJson(reader, ConvertedData.AppData.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public ConvertedData.UserCreds getUserCreds() {
        try (FileReader reader = new FileReader(this.USER_CREDS)) {
            return this.GSON.fromJson(reader, ConvertedData.UserCreds.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public ConvertedData.TimeOuts getTimeouts() {
        try (FileReader reader = new FileReader(this.TIMEOUTS)) {
            return this.GSON.fromJson(reader, ConvertedData.TimeOuts.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
