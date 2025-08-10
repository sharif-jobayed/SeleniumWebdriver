package framework;

public abstract class Page {
    protected DriverTools driverTools;
    protected String baseURL;
    protected String path;
    protected String pageName;

    protected Page(DriverTools driverTools, String path, String pageName) {
        this.driverTools = driverTools;
        this.baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php";
        this.path = path;
        this.pageName = pageName;
    }

    protected abstract String getBaseURL();

    protected abstract String getPath();

    protected abstract String getPageName();

    protected abstract String getPageTitle();

    protected abstract String getPageURL();

    protected abstract Boolean isPageOpen(Integer timeout);

    protected abstract Boolean isPageLoaded(Integer timeout);

    protected abstract Boolean isAlertOpen(Integer timeout);

    protected abstract Page typeInAlert(String text);

    protected abstract Page acceptAlert();

    protected abstract Page rejectAlert();

    protected abstract Page backToDefaultPage();

    protected abstract Page openInNewWindow(String url);

    protected abstract Page getWindow(Integer index);

    protected abstract Page closeCurrentWindow();

    protected abstract <P extends BasePage> P getPageInstance(Class<P> pClass);

    protected abstract Pages getPages();
}
