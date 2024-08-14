package framework.utils;

import com.google.gson.Gson;

import java.io.*;

public class DataProcessor {
    private final Gson GSON;
    private final File CREDENTIALS;
    private final File TIMEOUTS;

    public DataProcessor() {
        this.GSON = new Gson();
        this.CREDENTIALS = new File("./src/test/java/data/credentials.json");
        this.TIMEOUTS = new File("./src/test/java/data/timeouts.json");
    }

    public ProcessedData.URLs getURLs() {
        try (Reader reader = new FileReader(this.CREDENTIALS)) {
            return GSON.fromJson(reader, ProcessedData.URLs.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public ProcessedData.Users getUsers() {
        try(Reader reader = new FileReader(this.CREDENTIALS)) {
            return GSON.fromJson(reader, ProcessedData.Users.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public ProcessedData.Timeouts getTimeouts() {
        try(Reader reader = new FileReader(this.TIMEOUTS)) {
            return GSON.fromJson(reader, ProcessedData.Timeouts.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
