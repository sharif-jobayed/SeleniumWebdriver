package utils;

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

    public ConvertedData.AppData getAppData() {
        System.out.println("In the ConvertedData.AppData");

        try (FileReader reader = new FileReader(this.AppData)) {
            return this.GSON.fromJson(reader, ConvertedData.AppData.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ConvertedData.TestData getTestData() {
        System.out.println("In the ConvertedData.TestData");

        try (FileReader reader = new FileReader(this.TestData)) {
            return this.GSON.fromJson(reader, ConvertedData.TestData.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ConvertedData.TestData.Timeouts getTimeouts() {
        System.out.println("In the ConvertedData.TestData.Timeouts");

        try (FileReader reader = new FileReader(this.TestData)) {
            return this.GSON.fromJson(reader, ConvertedData.TestData.Timeouts.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
