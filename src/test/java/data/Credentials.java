package data;

public class Credentials {
    private final String BASE_URL;

    public Credentials() {
        this.BASE_URL = "https://status.epicgames.com/";
    }

    public String getBASE_URL() {
        return this.BASE_URL;
    }
}
