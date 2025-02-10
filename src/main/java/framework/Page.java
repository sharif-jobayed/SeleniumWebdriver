package framework;

public abstract class Page {
    protected DriverTools driverTools;

    protected Page(DriverTools driverTools) {
        this.driverTools = driverTools;
    }

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
}
