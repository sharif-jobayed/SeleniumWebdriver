import utils.DataConverter;

public class Main {
    public static void main(String[] args) {
        DataConverter dc = new DataConverter();

        System.out.println(dc.getAppData().getBaseURL());
        System.out.println(dc.getTestData().getSearchTitle());
        System.out.println(dc.getTimeouts().getMin());
    }
}
