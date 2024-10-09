package saucedemo.framework.utils;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataConverter {
    private final Gson GSON;
    private final File CREDENTIALS;

    public DataConverter() {
        this.GSON = new Gson();
        this.CREDENTIALS = new File("./src/test/java/saucedemo/data/credentials.json");
    }

    public ConvertedData getConvertedData() {
        try{
            return this.GSON.fromJson(new FileReader(this.CREDENTIALS), ConvertedData.class);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
