package framework.utils;

import com.google.gson.Gson;
import framework.utils.fakerUtils.Employee;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

    private final Gson GSON;
    private final File FILE;

    public DataReader(String path) {
        this.GSON = new Gson();
        this.FILE = new File(path);
    }

    public Employee getEmployee() {
        try (FileReader reader = new FileReader(this.FILE)) {
            return this.GSON.fromJson(reader, Employee.class);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
