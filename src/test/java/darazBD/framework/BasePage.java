package darazBD.framework;

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
}
