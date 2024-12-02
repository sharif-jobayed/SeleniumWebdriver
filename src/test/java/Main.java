import framework.utils.DataConverter;

public class Main {
    public static void main(String[] args) {
        DataConverter dc = new DataConverter();

        System.out.println("From AppData: " + dc.getAppData().getBaseURL());
        System.out.println("From Browsers: " + dc.getAppData().getBrowsers().getChrome());
        System.out.println("From TestData: " + dc.getTestData().getSearchTitle());
        System.out.println("From Timeouts: " + dc.getTestData().getTimeouts().getMax());
    }
}
