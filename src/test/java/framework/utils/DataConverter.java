package framework.utils;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataConverter {
    private final Gson GSON;
    private final File AppData;
    private final File TestData;

    public DataConverter() {
        this.GSON = new Gson();
        this.AppData = new File("./src/test/java/data/appData.json");
        this.TestData = new File("./src/test/java/data/testData.json");
    }

    public ConvertedData.AppData.AppDataBody getAppData() {
        try (FileReader reader = new FileReader(this.AppData)) {
            return this.GSON.fromJson(reader, ConvertedData.AppData.AppDataBody.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ConvertedData.TestData.TestDataBody getTestData() {
        try (FileReader reader = new FileReader(this.TestData)) {
            return this.GSON.fromJson(reader, ConvertedData.TestData.TestDataBody.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
