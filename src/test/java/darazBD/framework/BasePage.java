package darazBD.framework;

import java.util.Objects;

import static darazBD.framework.DriverTools.getWDriver;

public abstract class BasePage {
    private String pURL;
    private String pName;

    public BasePage(String pageURL, String pageName) {
        this.pURL = pageURL;
        this.pName = pageName;
    }

    public String getPURL() {
        return this.pURL;
    }

    public String getPName() {
        return this.pName;
    }

    public String getPTitile() {
        return getWDriver().getTitle();
    }

    public boolean isPageReady() {
        return Objects.requireNonNull(getWDriver().getPageSource()).isEmpty();
    }
}
