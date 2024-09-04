package darazBD.framework.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataConverter {
    private final Gson GSON;
    private final File CREDENTIALS;
    private final File TIMEOUTS;

    public DataConverter() {
        this.GSON = new Gson();
        this.CREDENTIALS = new File("./src/test/java/darazBD/data/credentials.json");
        this.TIMEOUTS = new File("./src/test/java/darazBD/data/timeouts.json");
    }

    public ConvertedData getCreds() {
        try (FileReader reader = new FileReader(this.CREDENTIALS)) {
            return this.GSON.fromJson(reader, ConvertedData.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Credentials file not found", e);
        } catch (JsonSyntaxException | IOException e) {
            throw new RuntimeException("Failed to parse credentials file", e);
        }
    }

    public ConvertedData.Timeouts getTimeouts() {
        try(FileReader reader = new FileReader(this.TIMEOUTS)) {
            return this.GSON.fromJson(reader, ConvertedData.Timeouts.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Timeouts file not found", e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse timeouts file", e);
        }
    }
}
