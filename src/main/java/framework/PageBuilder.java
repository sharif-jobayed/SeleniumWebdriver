package framework;

import org.openqa.selenium.InvalidArgumentException;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.Locale;

public class PageBuilder {
    private DriverTools driverTools;

    public PageBuilder(DriverTools driverTools) {
        this.driverTools = driverTools;
    }

    public <P extends BasePage> P getPage(String pageName) {
        String pn = pageName.toLowerCase(Locale.ROOT);

        switch (pn) {
            case "login":
                return (P) new LoginPage(
                        this.driverTools,
                        "auth/login"
                );
            case "dashboard":
                return (P) new DashboardPage(
                        this.driverTools,
                        "dashboard/index"
                );
            default:
                throw new InvalidArgumentException("Invalid Page request");
        }
    }

}
