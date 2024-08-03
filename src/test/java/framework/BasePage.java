package framework;

public class BasePage {
    private final String PAGE_URL;
    private final String PAGE_NAME;

    public BasePage(String pageURL, String pageName) {
        this.PAGE_URL = pageURL;
        this.PAGE_NAME = pageName;
    }

    public String getPAGE_URL() {
        return this.PAGE_URL;
    }
    public String getPAGE_NAME() {
        return this.PAGE_NAME;
    }
}
