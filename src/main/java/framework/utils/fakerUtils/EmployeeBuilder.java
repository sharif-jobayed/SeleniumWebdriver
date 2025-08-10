package framework.utils.fakerUtils;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EmployeeBuilder {

    private final Faker FAKER;
    private final Gson JSON_WRITER;

    private record User(
            Integer id,
            String firstName,
            String middleName,
            String lastName,
            String email,
            String username,
            String password
    ) {}

    public EmployeeBuilder() {
        this.FAKER = new Faker();
        this.JSON_WRITER = new GsonBuilder().setPrettyPrinting().create();
    }

    public String getFirstName() {
        return this.FAKER.name().firstName();
    }

    public String getMiddleName() {
        return this.FAKER.name().nameWithMiddle();
    }

    public String getLastName() {
        return this.FAKER.name().lastName();
    }

    public Integer getID() {
        return this.FAKER.number().numberBetween(1, 9999);
    }

    public String getEmail() {
        return this.FAKER.internet().emailAddress();
    }

    public String getUsername() {
        return this.FAKER.name().username();
    }

    public String getPassword() {
        return this.FAKER.internet().password(10, 12, true, true, true);
    }

    public void writeJSON() {
        User user = new User(
                this.getID(),
                this.getFirstName(),
                this.getMiddleName(),
                this.getLastName(),
                this.getEmail(),
                this.getUsername(),
                this.getPassword()
        );

        String userJSON = this.JSON_WRITER.toJson(user);
        Path outputPath = Path.of("src/test/java/data/fakeEmployeeData.json");

        try {
            Files.createDirectories(outputPath.getParent());
            Files.writeString(outputPath, userJSON);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
